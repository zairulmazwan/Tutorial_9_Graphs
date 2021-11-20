

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	
	int value;
	ArrayList<Node> edges = new ArrayList<Node>();
	
	Node(int v) {
		this.value = v;
	}
}

public class Graphs {
	
	static ArrayList<Node> dfs = new ArrayList<Node>();
	
	public static void addNode(Node n) {
		dfs.add(n);
	}
	
	void setEdge(Node n1, Node n2) {
		
		if (n1.edges.contains(n2)==false) {
			n1.edges.add(n2);
		}
		
		if (n2.edges.contains(n1)==false) {
			n2.edges.add(n1);
		}
	}

	public static Node getNode(int n) {
		Node res = null;
		for(int i=0; i<dfs.size(); i++) {
			if(dfs.get(i).value == n)
				res = dfs.get(i);
		}
		return res;
	}
	
	public static ArrayList<Node> getEdges (Node n) {
		int i = dfs.indexOf(n);
		ArrayList<Node> nn = dfs.get(i).edges;
		return nn;
	}
	
	public static void printEdges (Node n) {
		for (Node x : n.edges ) {
			System.out.print(x.value+" ");
		}
	}
	
	public static void printGraphNodes() {
		
		for (int i=0; i<dfs.size(); i++) {
			System.out.print(dfs.get(i).value+" ");
		}
	}
	
	public static boolean containNode (int n) {
		
		boolean res = false;
		for (Node x : dfs) {
			if(x.value == n)
				res = true;
		}
		return res;
	}
	
	public static void traverseBFS(int nodeValue) {
		
		//Write your code here
	}
	
	
	public static ArrayList<Node> traverseDFSAlgo2 (int nodeValue, ArrayList<Node> visited) {
		
		//Write your code here
		return visited;
	}
	
	public static void traverseDFSAlgo1 (int nodeValue) {
		
		//Write your code here
	}
	
	public void createGraph() {
		
		Graphs graph = new Graphs();

		Node a = new Node(10);
		Node b = new Node(20);
		Node c = new Node(30);
		Node d = new Node(40);
		Node e = new Node(50);
		Node f = new Node(60);
		
		graph.addNode(a);
		graph.addNode(b);
		graph.addNode(c);
		graph.addNode(d);
		graph.addNode(e);
		graph.addNode(f);
		
		//edges for a
		graph.setEdge(a,b);
		graph.setEdge(a,e);
		
		//edges for b
		graph.setEdge(b,a);
		graph.setEdge(b,c);
		graph.setEdge(b,f);
		
		//edges for c
		graph.setEdge(c,b);
		graph.setEdge(c,d);
		graph.setEdge(c,e);
		
		//edges for d
		graph.setEdge(d,c);
		
		//edges for e
		graph.setEdge(e,a);
		graph.setEdge(e,c);
		
		//edges for f
		graph.setEdge(f,b);
		
	}
	
	public static void printNodes (ArrayList<Node> n) {
		for(Node x : n) {
			System.out.print(x.value+" ");
		}
	}


	public static void main(String[] args) {
		
		Graphs graph = new Graphs();
		graph.createGraph();
		
		System.out.println("Number of nodes in the graph : "+dfs.size());
		System.out.println("Nodes in the graph are : ");
		printGraphNodes();

		System.out.println("\nThe graph contains 60 ? : "+graph.containNode(60));
		
		System.out.println("\nEdges in 20 : ");
		printEdges(dfs.get(1));
		
		System.out.println("\nEdges in 30 : ");
		printEdges(dfs.get(dfs.indexOf(getNode(30))));
		
		System.out.println();
		
		System.out.println("\nDFS Traverse starts from node 50 Algo 1 : ");
		traverseDFSAlgo1(60);
		
		System.out.println("\nBFS Traverse starts from node 50 : ");
		traverseBFS(60);
		
		System.out.println("\nDFS Traverse starts from node 50 Algo 2 : ");
		ArrayList<Node> visited = new ArrayList<Node>();
		visited = traverseDFSAlgo2(60,visited);
		
		printNodes(visited);
		

	}

}
