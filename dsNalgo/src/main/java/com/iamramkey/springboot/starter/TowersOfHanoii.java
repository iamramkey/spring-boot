package com.iamramkey.springboot.starter;

public class TowersOfHanoii {

	public void move(int numberOfDiscs, String from, String to, String inter) {
		if (numberOfDiscs == 1) {
			System.out.println("moving disc 1 from " + from + " to " + to);
		} else {
			move(numberOfDiscs - 1, from, inter, to);
			System.out.println("Moving disc " + numberOfDiscs + " from " + from + " to " + to);
			move(numberOfDiscs - 1, inter, to, from);
		}
	}

	public static void main(String[] args) {
		TowersOfHanoii toh = new TowersOfHanoii();
		toh.move(4, "A", "C", "B");
	}
}
