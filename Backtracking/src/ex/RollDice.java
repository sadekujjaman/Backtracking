package ex;

import java.util.Vector;

public class RollDice {

	private static int N = 2;

	public static void main(String[] args) {

		rollDice(N, new Vector<Integer>());
	}

	private static void rollDice(int dice, Vector<Integer> subset) {
		if (dice == 0) {
			printVector(subset);
			return;
		} else {
			for (int i = 1; i <= 6; i++) {
				subset.add(i);
				rollDice(dice - 1, subset);
				subset.remove(subset.size() - 1);
			}
		}
	}

	private static void printVector(Vector<Integer> subset) {
		System.out.print("{");
		for(Integer i : subset){
			System.out.print(i + " ");
		}
		System.out.println("}");
	}

}
