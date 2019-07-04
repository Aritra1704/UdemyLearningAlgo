package greedyalgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * There are number of shows with their respective durations.
 * You have a certain amount of time where you need to see as many shows as possible
 * 
 * First input is number of shows N
 * Second input is maximum time you have to view the shows M
 * Next inputs are the show duration * N
 */

/*
 * Solution approach:
 * First sort the array of the shows list.
 * Run a loop and deduct the show timings from the total time you have until it becomes 0, increment the show count at the same time.
 */
public class MaxNoOfThingsToTodo {

	public static void main(String[] args) {
		
		ArrayList<Integer> arrValues = new ArrayList<Integer>();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of test values: ");
		int numoftest = s.nextInt();
		System.out.println("Enter the max time allowed: ");
		int maxTime = s.nextInt();
		System.out.println("Enter the show times: ");
		for(int i = 0; i < numoftest; i++) {
			arrValues.add(s.nextInt());
		}
		
		//Sorting the array
		Collections.sort(arrValues);
		
		int count = 0;
		for(int i = 0; i < numoftest; i++) {
			if(maxTime >= 0) {
				maxTime -= arrValues.get(i);
				count++;
			}
		}
		
		System.out.println("Max number of shows you can check is: " + count);

	}
	
	

}
