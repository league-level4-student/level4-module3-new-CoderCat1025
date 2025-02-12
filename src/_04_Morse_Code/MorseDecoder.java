package _04_Morse_Code;

import java.util.Scanner;

import _03_Intro_to_Binary_Trees.BinaryTree;
import _03_Intro_to_Binary_Trees.Node;

public class MorseDecoder {

	BinaryTree<MorseCode> mcTree = new BinaryTree<MorseCode>();

	public static void main(String[] args) {

		MorseDecoder md = new MorseDecoder();
		md.initialize();
		md.decode();

	}

	public void initialize() {

		mcTree.insert(new MorseCode("start", ""));
		mcTree.insert(new MorseCode("e", "."));
		mcTree.insert(new MorseCode("t", "-"));

		mcTree.insert(new MorseCode("i", ".."));
		mcTree.insert(new MorseCode("a", ".-"));
		mcTree.insert(new MorseCode("n", "-."));
		mcTree.insert(new MorseCode("m", "--"));

		mcTree.insert(new MorseCode("s", "..."));
		mcTree.insert(new MorseCode("u", "..-"));
		mcTree.insert(new MorseCode("r", ".-."));
		mcTree.insert(new MorseCode("w", ".--"));
		mcTree.insert(new MorseCode("d", "-.."));
		mcTree.insert(new MorseCode("k", "-.-"));
		mcTree.insert(new MorseCode("g", "--."));
		mcTree.insert(new MorseCode("o", "---"));

		mcTree.insert(new MorseCode("h", "...."));
		mcTree.insert(new MorseCode("v", "...-"));
		mcTree.insert(new MorseCode("f", "..-."));
		mcTree.insert(new MorseCode("l", ".-.."));
		mcTree.insert(new MorseCode("p", ".--."));
		mcTree.insert(new MorseCode("j", ".---"));
		mcTree.insert(new MorseCode("b", "-..."));
		mcTree.insert(new MorseCode("x", "-..-"));
		mcTree.insert(new MorseCode("c", "-.-."));
		mcTree.insert(new MorseCode("y", "-.--"));
		mcTree.insert(new MorseCode("z", "--.."));
		mcTree.insert(new MorseCode("q", "--.-"));

		mcTree.printVertical();

		//scioly codebusters moment... :agony:

	}

	/*
	 * 1.) See if you can decode the following message using the binary tree and
	 * print it to the console:
	 * 
	 * -.-- --- ..- .- .-. . .- -- .- --.. .. -. --.
	 * 
	 * 2.) Then use the binary tree and the scanner class to create a morse code
	 * translator. The user should be able to type multiple letters in morse
	 * code on a single line and have it repeated back to them, decoded into the
	 * english alphabet.
	 * 
	 */
	void decode() {
		String morseCode = "-.-- --- ..- .- .-. . .- -- .- --.. .. -. --.";
		Scanner scan = new Scanner(System.in);
		// Y O U A R E A M A Z I N G
		//System.out.println("You are amazing");

		//NOTE: i also added "x" to show a new letter and "xx" to show a space (like in codebusters) but it still works without them
		//NOTE: this doesn't work with both space and x's, you can only use one or the other
		System.out.println("Type in the morse code you want to translate.");
		morseCode = scan.nextLine();

		Node letter = mcTree.getRoot();
		String plainText = "";

		for (int i = 0; i < morseCode.length(); i++) {
			if (morseCode.charAt(i) == '-') {
				letter = letter.getRight();
			} else if (morseCode.charAt(i) == '.') {
				letter = letter.getLeft();

			} else if (morseCode.charAt(i) == 'x' && morseCode.charAt(i-1) == 'x') {
				plainText = plainText + " ";
				letter = mcTree.getRoot();
			} else {
				plainText = plainText + letter.getValue();
				letter = mcTree.getRoot();
			}
		}
		plainText = plainText + letter.getValue();

		System.out.println(plainText);
	}

}
