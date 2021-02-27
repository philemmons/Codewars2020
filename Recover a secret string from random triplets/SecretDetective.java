/*
 * classical method - Topological Sort
 * https://stackoverflow.com/questions/24747611/guess-the-string-given-random-triplets
 * alternative method
 * https://www.interviewcake.com/concept/java/topological-sort
 * 
 */

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class SecretDetective {

	public static String recoverSecret(char[][] triplets) {
		//display the triplets
		for (char[] row : triplets) {
			for (char letter : row) {
		        System.out.print(letter + " ");
		    }
		    System.out.println();
		}
		
		//Create the graph from triplets in a adjacency list format
		Map< Character, LinkedList<Character> > adjList = new HashMap<>();
		char cur, // source node
			 next; // destination node
		int numEdges= 0; 

		for(int row= 0; row< triplets.length; row++) {
			for(int col= 0; col< triplets[row].length-1; col++) {
				cur= triplets[row][col];
				next= triplets[row][col+1];
				
				if(!adjList.containsKey( cur )) 
					adjList.put( cur , new LinkedList<>() );
				
				adjList.putIfAbsent( next  , new LinkedList<>() );
				
				if(!adjList.get( cur ).contains( next ) ) { 
					adjList.get( cur ).add( next );
					numEdges++;
				}
			}
		}
			
		System.out.println("adj list: "+ adjList + 
				"\nKey Set: "+ adjList.keySet()+
				"\nValue Set: "+ adjList.values()+
				"\nVertices: "+ adjList.keySet().size()+
				"\nEdges: "+ numEdges);
		
		Set<Character> setChar; 
		char c;
		StringBuilder sb = new StringBuilder();
		
		// determine the graph's root(starting node) 
		while(!adjList.isEmpty()) {
			setChar= new HashSet<>();
			setChar.addAll(adjList.keySet());
			// this identifies and eliminates all in-degree nodes
			// eg a->b->c  results in a
			// rinse and repeat
			for(LinkedList<Character> llChar: adjList.values()) {
				for(char letter: llChar) {
					setChar.remove(letter);
				}			
			}
			// quick and dirty to get the one node value in the set
			c= setChar.iterator().next();
			sb.append(c);
			adjList.remove(c);
		}
					
		return sb.toString();
	}
