package _01_Spies_On_A_Train;

import java.util.ArrayList;
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
		ArrayList<String> names = new ArrayList<>();
		

		for (String i : clues) {
			System.out.println(i);
		}

		Node<TrainCar> head = train.getHead();

		for (int i = 0; i < train.size(); i++) {
			System.out.println(head.getValue().questionPassenger());
			String e = head.getValue().questionPassenger();
			StringBuilder build = new StringBuilder(e);
			
			do {
				build.delete(0, 1);
			} while (build.charAt(0) != '?');
			
			String name = "";
			build.delete(0, 8);
			do {
				name = name + build.charAt(0);
				build.delete(0, 1);
			} while(build.charAt(0) !=' ');
			System.out.println(name);
			
			build.delete(0, 8);
			do {
				build.delete(0, 1);
			} while (build.charAt(0) != ' ');
			
			String evi = "";
			do {
				evi = evi + build.charAt(0);
				build.delete(0, 1);
			} while(build.charAt(0) !='.');
			System.out.println(evi);
			
			evidence.put(name, evi);
			names.add(name);
			
			head = head.getNext();
		}
		
		for (String i : clues) {
			for (int e = 0; e < evidence.size(); e++) {
				if (i.contains(evidence.get(names.get(e)))) {

					spy = names.get(e);
				}
			}
		}

		return spy;

	}

}
