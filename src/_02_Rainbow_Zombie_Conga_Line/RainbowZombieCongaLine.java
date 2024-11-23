package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {

	/*
	 * You are hosting a rainbow zombie conga dance party! Zombies are not very
	 * smart(maybe that's why they crave brains) and need your help to direct
	 * them through the choreography.
	 * 
	 * Each method is a dance move you will need to implement.
	 * 
	 * When you think you've gotten your zombies trained well enough you can
	 * start the party by running the main method in RainbowZombieDanceParty and
	 * typing how many rounds you want in the console to see if they followed
	 * your choreography correctly.
	 * 
	 * Note: The party will always start with a rainbow brains and every 5
	 * rounds the head and tail of the dance line will be removed.
	 */

	private LinkedList<Zombie> congaLine;
	private ZombieHatColor[] zombieHats;
	Node<Zombie> head;

	public RainbowZombieCongaLine() {

		congaLine = new LinkedList<Zombie>();
		zombieHats = ZombieHatColor.values();

		head = congaLine.getHead();

	}

	// Make the passed in zombie the first Zombie in the conga line!
	public void engine(Zombie dancer) {
		congaLine.getHead().setValue(dancer);
	}

	// Make the passed in zombie the last Zombie in the conga line!
	public void caboose(Zombie dancer) {

		congaLine.remove(congaLine.size()-1);
		congaLine.add(dancer);

	}

	// Place the zombie at the designated position in the conga line!
	public void jumpInTheLine(Zombie dancer, int position) {
		for (int i = 0; i < position; i++) {
			if (i==position) {
				head.setValue(dancer);
			}
			head = head.getNext();
		}
		head=congaLine.getHead();

		//NOTE: this one's kinda weird, it works sometimes
	}

	/*
	 * Remove all zombies with the same hat color as the passed in zombie from
	 * the conga line!
	 */
	public void everyoneOut(Zombie dancer) {
		for (int i = 0; i < congaLine.size(); i++) {
			if (head.getValue().getZombieHatColor() == dancer.getZombieHatColor()) {
				congaLine.remove(i);
				i--;
			}
			head = head.getNext();
		}
		head=congaLine.getHead();
	}

	/*
	 * Remove the first zombie with the same hat color as the passed in zombie
	 * from the conga line!
	 */
	public void youAreDone(Zombie dancer) {
		boolean found = false;
		int position = 0;
		while (found=false) {
			if (head.getValue().getZombieHatColor()==dancer.getZombieHatColor()) {
				congaLine.remove(position);
				found=true;
			} else {
				position++;
				head=head.getNext();
			}
			//NOTE: so like this doesn't work. It just doesn't get rid of any zombies, idk why
		}
		head=congaLine.getHead();
	}

	/*
	 * Make three more zombies with the same hat color as the passed in zombie and
	 * add one to the front, one to the end and one in the middle.
	 */
	public void brains(Zombie dancer) {
		for (int i = 0; i < congaLine.size()/2; i++) {
			head = head.getNext();
		}
		head.setValue(dancer);

		congaLine.getHead().setValue(dancer);
		congaLine.add(dancer);

		head=congaLine.getHead();
	}

	/*
	 * Add the passed in zombie to the front and then add one zombie of each hat
	 * color to the end of the line.
	 */ 
	public void rainbowBrains(Zombie dancer) {
		//head = congaLine.getHead();
		//head.setValue(dancer);
		//NOTE: this line doesn't work so fix it later. find a way to add to the front without an error

		congaLine.add(new Zombie(ZombieHatColor.R));
		congaLine.add(new Zombie(ZombieHatColor.O));
		congaLine.add(new Zombie(ZombieHatColor.Y));
		congaLine.add(new Zombie(ZombieHatColor.G));
		congaLine.add(new Zombie(ZombieHatColor.B));
		congaLine.add(new Zombie(ZombieHatColor.I));
		congaLine.add(new Zombie(ZombieHatColor.V));

		head = congaLine.getHead();
	}

	public LinkedList<Zombie> getCongaLine() {
		return congaLine;
	}
}
