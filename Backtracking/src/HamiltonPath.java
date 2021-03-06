import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HamiltonPath {

	static int res = 0;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		for(int t = 1; t <= test; t++){
			int nodes = sc.nextInt();
			int edges = sc.nextInt();
			
			Graph g = new Graph(nodes);
			for(int i = 0; i < edges; i++){
				int u = sc.nextInt();
				int v = sc.nextInt();
				g.addEdge(u, v);
			}
			int ans = 0;
			for(int i = 1; i <= nodes; i++){
				boolean visited[] = new boolean[nodes + 1];
				visited[i] = true;
				ans = call(g, i, 1, visited);
				if(ans == 1)
					break;
			}
			
			System.out.println(ans);
		}
		
		
		sc.close();
	}
	
	private static int call(Graph g, int u, int depth, boolean[] visited) {
		if(depth == g.nodes){
			return 1;
		}
		
		for(Integer v : g.adjList[u]){
			if(!visited[v]){
				visited[v] = true;
				int ans = call(g, v, depth + 1, visited);
				if(ans == 1)
					return 1;
				
				visited[v] = false;
			}
		}
		
		
		return 0;
	}

	

	private static class Graph{
		int nodes;
		List<Integer> adjList[];
		
		Graph(int nodes){
			this.nodes = nodes;
			adjList = new ArrayList[nodes + 1];
			for(int i = 0; i <= nodes; i++){
				adjList[i] = new ArrayList<>();
			}
		}
		
		public void addEdge(int u, int v){
			adjList[u].add(v);
			adjList[v].add(u);
		}
	}
}