package _01_Spies_On_A_Train;

import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

	/*
	 * A spy has made off with important intel from your intelligence agency!
	 * You know the spy is somewhere on this train(LinkedList). Your job is to
	 * find the suspect that matches the description given to you by the list of
	 * clues(the array).
	 * 
	 * Walk through the train, questioning each of the passengers about what
	 * they have seen and return the name of the most likely suspect.
	 * 
	 * The results are randomly generated each time so you should have a general
	 * case solution that carefully compares the clues to each passenger's
	 * testimony. Remember to use String methods to break up the passengers'
	 * statements.
	 */
	String findIntel(LinkedList<TrainCar> train, String[] clues) {

		String spy = "";
		HashMap<String, String> evidence = new HashMap<>();

		for (String i : clues) {
			System.out.println(i);
		}

		Node<TrainCar> head = train.getHead();

		for (int i = 0; i < train.size(); i++) {
			System.out.println(head.getValue().questionPassenger());
			head = head.getNext();
		}

		//NOTE: find an efficient way to get the name and evidence, probably start with sorting based on name
		//frequency, spies always get mentioned 3 times. Make sure to put name and evidence in a hashmap

		return spy;

	}

}
