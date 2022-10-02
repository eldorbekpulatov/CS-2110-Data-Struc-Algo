/* Time spent on a7:  2 hours and 20 minutes.

 * Name: Eldor Bekpulatov and Billy Wilkinson
 * Netid: eb654 and wjw97
 * What I thought about this assignment:
 * 
 * 
 *
 */

package student;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import graph.Edge;
import graph.Node;

/** This class contains Dijkstra's shortest-path algorithm and some other methods. */
public class Paths {

	/** Return the shortest path from start to end, or the empty list if a path
	 * does not exist.
	 * Note: The empty list is NOT "null"; it is a list with 0 elements. */
	public static List<Node> shortestPath(Node start, Node end) {
		/* TODO Read note A7 FAQs on the course piazza for ALL details. */
		try{
			//Min-heap storing nodes from the hashmap.
			Heap<Node> F=new Heap<Node>();
			F.add(start, 0);

			//Stores all the nodes in the settled and frontier set
			HashMap<Node, SFdata> newHashMap = new HashMap<Node, SFdata>();
			SFdata l= new SFdata(0, null);
			newHashMap.put(start, l);

			while(F.size()>0){
				Node f= F.poll();

				if (f == end){ return constructPath(f,newHashMap); }

				for (Edge newEdge: f.getExits()){
					int distance= newHashMap.get(f).distance + newEdge.length;
					Node node1 = newEdge.getOther(f);
						if(newHashMap.get(node1) == null) {
							F.add(node1, distance);
							newHashMap.put(node1,  new SFdata(distance, f));
						} else if (distance < newHashMap.get(node1).distance) {
							newHashMap.get(node1).distance = distance;
							newHashMap.get(node1).backPointer = f;
							F.updatePriority(node1, distance);
						}
				}
			}
			
		}catch ( NullPointerException e){
		}
		return new LinkedList();
	}


	/** Return the path from the start node to node end.
	 *  Precondition: nData contains all the necessary information about
	 *  the path. */
	public static List<Node> constructPath(Node end, HashMap<Node, SFdata> nData) {
		LinkedList<Node> path= new LinkedList<Node>();
		Node p= end;
		// invariant: All the nodes from p's successor to the end are in
		//            path, in reverse order.
		while (p != null) {
			path.addFirst(p);
			p= nData.get(p).backPointer;
		}
		return path;
	}

	/** Return the sum of the weights of the edges on path path. */
	public static int pathDistance(List<Node> path) {
		if (path.size() == 0) return 0;
		synchronized(path) {
			Iterator<Node> iter= path.iterator();
			Node p= iter.next();  // First node on path
			int s= 0;
			// invariant: s = sum of weights of edges from start to p
			while (iter.hasNext()) {
				Node q= iter.next();
				s= s + p.getEdge(q).length;
				p= q;
			}
			return s;
		}
	}

	/** An instance contains information about a node: the previous node
	 *  on a shortest path from the start node to this node and the distance
	 *  of this node from the start node. */
	private static class SFdata {
		private Node backPointer; // backpointer on path from start node to this one
		private int distance; // distance from start node to this one

		/** Constructor: an instance with distance d from the start node and
		 *  backpointer p.*/
		private SFdata(int d, Node p) {
			distance= d;     // Distance from start node to this one.
			backPointer= p;  // Backpointer on the path (null if start node)
		}

		/** return a representation of this instance. */
		public String toString() {
			return "dist " + distance + ", bckptr " + backPointer;
		}
	}
}
