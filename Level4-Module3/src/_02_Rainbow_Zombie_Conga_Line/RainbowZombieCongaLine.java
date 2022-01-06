package _02_Rainbow_Zombie_Conga_Line;

import java.util.ArrayList;
import java.util.Iterator;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {

	/*
	 * You are hosting a rainbow zombie conga dance party! Zombies are not very
	 * smart(maybe that's why they crave brains) and need your help to direct them
	 * through the choreography.
	 * 
	 * Each method is a dance move you will need to implement.
	 * 
	 * When you think you've gotten your zombies trained well enough you can start
	 * the party by running the main method in RainbowZombieDanceParty and typing
	 * how many rounds you want in the console to see if they followed your
	 * choreography correctly.
	 * 
	 * Note: The party will always start with a rainbow brains and every 5 rounds
	 * the head and tail of the dance line will be removed.
	 */

	private LinkedList<Zombie> congaLine;
	private ZombieHatColor[] zombieHats;

	public RainbowZombieCongaLine() {

		congaLine = new LinkedList<Zombie>();
		zombieHats = ZombieHatColor.values();

	}

	// Make the passed in zombie the first Zombie in the conga line!
	public void engine(Zombie dancer) {

		if (congaLine.size() == 0) {
			congaLine.add(dancer);
		} else {

			Node<Zombie> prevHead = congaLine.getHead();
			Node<Zombie> newHead = new Node<Zombie>(dancer);
			congaLine.setHead(newHead);
			newHead.setNext(prevHead);
			prevHead.setPrev(newHead);
		}
	}

	// Make the passed in zombie the last Zombie in the conga line!
	public void caboose(Zombie dancer) {
		congaLine.add(dancer);
	}

	// Place the zombie at the designated position in the conga line!
	public void jumpInTheLine(Zombie dancer, int position) {

		if (position == 0) {
			engine(dancer);
		} else if (position == congaLine.size() - 1) {
			caboose(dancer);
		} else {

			Node<Zombie> current = congaLine.getHead();

			while (current != null) {

				if (position == 0) {

					Node<Zombie> next = current;
					Node<Zombie> prev = current.getPrev();
					current = new Node<Zombie>(dancer);

					prev.setNext(current);
					current.setPrev(prev);
					current.setNext(next);
					next.setPrev(current);
					break;
				}

				position--;
				current = current.getNext();
			}

		}
	}

	/*
	 * Remove all zombies with the same hat color as the passed in zombie from the
	 * conga line!
	 */
	public void everyoneOut(Zombie dancer) {
		ZombieHatColor hatColor = dancer.getZombieHatColor();
		Node<Zombie> current = congaLine.getHead();

		while (current != null) {

			if (current.getValue().getZombieHatColor() == hatColor) {

				Node<Zombie> next = current.getNext();
				Node<Zombie> prev = current.getPrev();

				if (current == congaLine.getHead()) {
					congaLine.setHead(next);
				}

				if (current == congaLine.getTail()) {
					congaLine.setTail(prev);
				}

				current = next;

				if (prev != null) {
					prev.setNext(next);
				}

				if (next != null) {
					next.setPrev(prev);
				}

			} else {

				current = current.getNext();
			}
		}
	}

	/*
	 * Remove the first zombie with the same hat color as the passed in zombie from
	 * the conga line!
	 */
	public void youAreDone(Zombie dancer) {
		ZombieHatColor hatColor = dancer.getZombieHatColor();
		Node<Zombie> current = congaLine.getHead();

		while (current != null) {

			if (current.getValue().getZombieHatColor() == hatColor) {

				Node<Zombie> next = current.getNext();
				Node<Zombie> prev = current.getPrev();

				if (current == congaLine.getHead()) {
					congaLine.setHead(next);
				}

				if (current == congaLine.getTail()) {
					congaLine.setTail(prev);
				}

				current = next;

				if (prev != null) {
					prev.setNext(next);
				}

				if (next != null) {
					next.setPrev(prev);
				}

				break;

			} else {

				current = current.getNext();
			}
		}

	}

	/*
	 * Make two more zombies with the same hat color as the passed in zombie and add
	 * one to the front, one to the end and one in the middle.
	 */
	public void brains(Zombie dancer) {
		ZombieHatColor hatColor = dancer.getZombieHatColor();

		this.engine(new Zombie(hatColor));
		this.jumpInTheLine(new Zombie(hatColor), congaLine.size() / 2);
		this.caboose(new Zombie(hatColor));
	}

	/*
	 * Add the passed in zombie to the front and then add one zombie of each hat
	 * color to the end of the line.
	 */
	public void rainbowBrains(Zombie dancer) {
		engine(dancer);
		for (int i = 0; i < zombieHats.length; i++) {
			congaLine.add(new Zombie(zombieHats[i]));
		}
	}

	public LinkedList<Zombie> getCongaLine() {
		return congaLine;
	}
}