package ex;

import java.util.Scanner;

public class StringPermutation {

	
	private static String str = "ABAC";
	private static int r = 3;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		str = sc.next();
		r = str.length();//sc.nextInt();
		
		calculateCombination(new StringBuilder().append(str), new StringBuilder());
		
		sc.close();
	}
	
	private static void calculateCombination(StringBuilder st, StringBuilder choosen){
		if(st.length()  == str.length() - r){
			System.out.println(choosen);
		}
		else{
			for(int k = 0; k < st.length(); k++){
				char c = st.charAt(k);
				choosen.append(c);
				st.replace(k, k + 1, "");
				calculateCombination(st, choosen);
				st.insert(k, c);
				choosen.replace(choosen.length() - 1, choosen.length(), "");
			}
		}
		
	}

}
