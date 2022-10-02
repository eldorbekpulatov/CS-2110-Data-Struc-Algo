package student;

import models.RescueStage;
import models.ReturnStage;
import models.Spaceship;
import student.Paths;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import models.Board;
import models.Node;
import models.NodeStatus;

/** An instance implements the methods needed to complete the mission */
public class MySpaceship extends Spaceship {

	/**
	 * Explore the galaxy, trying to find the missing spaceship that has crashed
	 * on Planet X in as little time as possible. Once you find the missing
	 * spaceship, you must return from the function in order to symbolize that
	 * you've rescued it. If you continue to move after finding the spaceship
	 * rather than returning, it will not count. If you return from this
	 * function while not on Planet X, it will count as a failure.
	 * 
	 * At every step, you only know your current planet's ID and the ID of all
	 * neighboring planets, as well as the ping from the missing spaceship.
	 * 
	 * In order to get information about the current state, use functions
	 * currentLocation(), neighbors(), and getPing() in RescueStage. You know
	 * you are standing on Planet X when foundSpaceship() is true.
	 * 
	 * Use function moveTo(long id) in RescueStage to move to a neighboring
	 * planet by its ID. Doing this will change state to reflect your new
	 * position.
	 */
	
	//Hashset of visited planets, contains their id
	HashSet<Long> visited= new HashSet<Long>();
	
	
	@Override
	public void rescue(RescueStage state) {
		// TODO : Find the missing spaceship
		Random rand = new Random();
		//if found planet X, clear the list of visited and return 
		if (state.foundSpaceship()) { visited.clear(); return; }
		//collection of neighbors
		Collection<NodeStatus> neighbours=state.neighbors();
		//pick a random planet
		NodeStatus closest=(NodeStatus) neighbours.toArray()[rand.nextInt(neighbours.size())];;
		//while the planet is already visited, randomly pick another
		while (visited.contains(closest)){
			closest=(NodeStatus) neighbours.toArray()[rand.nextInt(neighbours.size())];
		}
		//from all the neighbors, pick the one thats closest and not visited
		for (NodeStatus j: neighbours){
			boolean v= visited.contains(j.getId());
			if ((closest.getPingToTarget() < j.getPingToTarget()) && !v) {
				closest = j;
			}
		}
		visited.add(closest.getId()); //add the closest planet to the visited list
		state.moveTo(closest.getId()); // move to the closest planet
		rescue(state); //recursive case
		return;
	}


	/**
	 * Get back to Earth, avoiding hostile troops and searching for speed
	 * upgrades on the way. Traveling through 3 or more planets that are hostile
	 * will prevent you from ever returning to Earth.
	 *
	 * You now have access to the entire underlying graph, which can be accessed
	 * through ScramState. currentNode() and getEarth() will return Node objects
	 * of interest, and getNodes() will return a collection of all nodes in the
	 * graph.
	 *
	 * You may use state.grabSpeedUpgrade() to get a speed upgrade if there is
	 * one, and can check whether a planet is hostile using the isHostile
	 * function in the Node class.
	 *
	 * You must return from this function while on Earth. Returning from the
	 * wrong location will be considered a failed run.
	 *
	 * You will always be able to return to Earth without passing through three
	 * hostile planets. However, returning to Earth faster will result in a
	 * better score, so you should look for ways to optimize your return.
	 */
	
	@Override
	public void returnToEarth(ReturnStage state) {
		// TODO: Return to Earth

		if(state.currentNode()==state.getEarth()) { return;} //return at Earth
		//if has speed upgrade, equip
		if(state.currentNode().hasSpeedUpgrade()) state.grabSpeedUpgrade(); 
		//get the usual Dijkstra's path
		List<Node> p= Paths.shortestPath(state.currentNode(), state.getEarth());
		
		if (containsHostiles(p)){//if has more than three hostile planets
			//use a different algorithm
				p=Paths.shortPath(state.currentNode(), state.getEarth());}
		
		state.moveTo(p.get(1)); //move to the first planet 
		returnToEarth(state); //recursive call
		return;
	}
	
	
	/** Returns true if the given path contains more than three hostile
	 * planets. */
	private boolean containsHostiles (List<Node> path){
		int num=0;
		for (Node x: path){
			if (x.isHostile()) num++;
		}
		return (num<3) ? false:true;
	}
}