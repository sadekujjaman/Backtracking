package ex;

import java.util.Vector;

public class PrintSubsets {

	static Vector<Integer> mainSet;
	
	public static void main(String[] args) {
		mainSet = new Vector<>();
		mainSet.add(1);
		mainSet.add(2);
		mainSet.add(3);
		
		printSubsets(mainSet, new Vector<Integer>());
	}

	private static void printSubsets(Vector<Integer> set, Vector<Integer> subset) {
		if(set.size() == 0){
			printVector(subset);
			return;
		}
		else{
			Vector<Integer>temp = new Vector<>(set);
			for(int i = 0; i < set.size(); i++){
				subset.add(set.get(i));
				
				temp.remove(0);
				printSubsets(temp, subset);
			
				subset.remove(subset.size() - 1);
			}
		}
		printVector(subset);
	}

	private static void printVector(Vector<Integer> subset) {
		System.out.print("{");
		for(Integer i : subset){
			System.out.print(i + " ");
		}
		System.out.println("}");
	}

}
