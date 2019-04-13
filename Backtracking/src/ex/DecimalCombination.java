package ex;

public class DecimalCombination {

	private static int N = 8;
	public static void main(String[] args){
		
		generateCombination("");
	}
	private static void generateCombination( String s) {
		if(s.length() == N){
			System.out.println(s);
		}
		else{
			for(int i = 0; i <= 9; i++){
				generateCombination(s + String.valueOf(i));
			}
		}
	}
}
