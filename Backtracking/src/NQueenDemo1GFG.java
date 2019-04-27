import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueenDemo1GFG {

	static int res = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		
		for(int t = 1; t <= test; t++){
			sb = new StringBuilder();
			int queen = sc.nextInt();
			int arr[][] = new int[queen][queen];
			call(arr, 0, queen);
			if(sb.toString().length() == 0){
				System.out.println("-1");
			}
			else{
				System.out.println(sb.toString());
			}
		}
		
		
		sc.close();
	}

static StringBuilder sb = new StringBuilder();
	private static boolean call(int[][] arr, int col, int queen) {
		
		if(col == queen){
			sb.append("[");
			for (int i = 0; i < queen; i++){
				for (int j = 0; j < queen; j++){
//					System.out.print(arr[i][j] + " ");
					if(arr[j][i] == 1){
						sb.append((j + 1) + " ");
					}
					
				}
					
//				System.out.println();
			}
			sb.append("] ");
//			System.out.println();

			return true;
		}
		boolean ans = false;
		for(int row = 0; row < queen; row++){
			if(isSafe(arr, row, col, queen)){
				arr[row][col] = 1;
				 ans = call(arr, col + 1, queen);
				arr[row][col] = 0;
			}
		}
		
		return ans;
	}


	private static boolean isSafe(int[][] arr, int row, int col, int queen) {
		
		for(int i = 0; i < col; i++){
			if(arr[row][i] != 0)
				return false;
		}
		
		for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
			if(arr[i][j] != 0)
				return false;
		}
		
		for(int i = row, j = col; j >= 0 && i < queen; i++, j--){
			if(arr[i][j] != 0)
				return false;
		}
		
		
		return true;
	}


	private static class Graph {
		int nodes;
		List<Integer> adjList[];

		Graph(int nodes) {
			this.nodes = nodes;
			adjList = new ArrayList[nodes + 1];
			for (int i = 0; i <= nodes; i++) {
				adjList[i] = new ArrayList<>();
			}
		}

		public void addEdge(int u, int v) {
			adjList[u].add(v);
			adjList[v].add(u);
		}
	}
}