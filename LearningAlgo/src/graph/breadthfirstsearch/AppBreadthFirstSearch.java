package graph.breadthfirstsearch;

import java.util.Iterator;
import java.util.LinkedList;

public class AppBreadthFirstSearch {

	private int numofVertices = 0;// Number of vertices
	
	private LinkedList<Integer> adjacency[];//Array of list for adjacency list representation
	
	//Constructor
	AppBreadthFirstSearch(int vertices) {
		this.numofVertices = vertices;
		adjacency = new LinkedList[numofVertices];
		for (int i = 0; i < numofVertices; i++) {
			adjacency[i] = new LinkedList<Integer>();
		}
	}
	
	//Function to add edge into the graph
	void addEdge(int vertex, int value) {
		adjacency[vertex].add(value);// Add value to vertices list
	}
	
//	//A function used by DFS
//	void DFSUtil(int vertex, boolean visited[]) {
//		//Mark the current node as visited
//		visited[vertex] = true;
//		System.out.print(vertex + " ");
//		
//		//Recur for all vertices around to this vertex
//		Iterator<Integer> iterator = adjacency[vertex].listIterator();
//		while(iterator.hasNext()) {
//			int next = iterator.next();
//			if(!visited[next])
//				DFSUtil(next, visited);
//		}
//	}
	
	//Function to do DFS traversal
	void BFS(int vertex) {
		// Mark all the vertices as false initially
		boolean visited[] = new boolean[numofVertices];
		
		// Create the queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		// Mark the current node for BFS
		visited[vertex] = true;
		queue.add(vertex);
		
		while(queue.size() != 0) {
			// Deque a vertex from queue and print it
			vertex = queue.poll();
			System.out.print(vertex + " ");
			
			// Get all adjacent vertices of the dequeued vertex 
			// If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
			Iterator<Integer> iterator = adjacency[vertex].listIterator();
			while(iterator.hasNext()) {
				int n = iterator.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		AppBreadthFirstSearch graph = new AppBreadthFirstSearch(4);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		System.out.println("Following is a depth first traversal: " + "starting from vertices 2");
		
		graph.BFS(2);

	}

}
