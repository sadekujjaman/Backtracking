package ex;


public class BinaryCombination {

	
	private static int n = 4;
	
	public static void main(String[] args){
		
	
		generateCombination("");
		
		System.out.println();
		
		generateCombination("", 0);
		
	}

	private static void generateCombination(String str) {
		
		if(str.length() == n)
			System.out.println(str);
		else{
			generateCombination(str + "0");
			generateCombination(str + "1");
		}
	}
	private static int bitset = 2;
	private static void generateCombination(String str, int bit){

		if(str.length() == n){
		
			if(bit == bitset){
				System.out.println(str);
			}
		}
		else{
			generateCombination(str + "0", bit);
			generateCombination(str + "1", bit + 1);
		}
	}
	
}
