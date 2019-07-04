package greedyalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * 

Motu and Patlu are very good friends and they love to eat ice-creams. Once they thought of playing a game, so they bought “n” ice-creams from the market of varying heights (may be same). They arranged the ice-creams in a line in random order. Motu starts to eat ice-creams from left to right and Patlu from right to left. The heights of the ice-creams are known.

Motu eats the ice-cream as twice the speed of Patlu (that’s the secret for his health :p ). If, anyone of them is eating the ice-cream , then definitely other one cannot have that ice-cream. However, if both of them reach the same ice-cream, Motu snatches it away from Patlu (he got more power than patlu :( ) and eats it. The winner will be the one who will eat more number of ice-creams.

Since, both of them are too busy in eating ice-creams they forgot to count the number of ice-creams they have already eaten. Can you help them in deciding the winner.

P.S.- Since, ‘WINTER HAS ALREADY ARRIVED’ ,so ice-creams will not melt as it is freezing out there.

Note : Time taken to eat a ice-cream is directly proportional to its height.

Input :

The first line contains one integer t, the number of test cases.

The first line of each test case contains one integer n,the number of ice-creams.

The second line contains a sequence , a1, a2, a3 . . . an where ai denotes height of ith ice-cream.

Output :

For each test case print two new lines.

First line contains two spaced integers, the no. of ice-creams eaten by Motu and Patlu respectively.

Second line contains the name of the winner, if motu eats more no. of icecreams print ‘Motu’ (without inverted commas), if patlu eats more no. of ice-creams print ‘Patlu’ (without inverted commas). In case of Tie print ‘Tie’ (without inverted commas).

Constraints :

1 ≤ t ≤ 100
1 ≤ n ≤ 100000
1 ≤ ai ≤ 10^9

 */

// https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/motu-and-patlu-1-ab612ad8/

public class MotuPatluIcecream {

	static ArrayList<Integer> arrInputs = new ArrayList<Integer>();
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int numOftest = scanner.nextInt();

		for(int i = 0; i < numOftest; i++) {
			int numofValues = scanner.nextInt();
			
			for(int j = 0; j < numofValues; j++)
				arrInputs.add(Integer.valueOf(scanner.next()));
			compete(numofValues);
		}
	}
	
	private static void compete(int numofIcecreams) {
		int indexMotu = 0, indexPatlu = arrInputs.size() - 1;
		int countMotu = 0, countPatlu = 0;
		int motu = speedofMotu(indexMotu);
		int patlu = speedofPatlu(indexPatlu);
		while(indexMotu < indexPatlu) {
			if(motu < patlu) {
				countMotu++;
				indexMotu++;
				patlu -= motu;
				motu = speedofMotu(indexMotu);
			} else if(patlu < motu) {
				countPatlu++;
				indexPatlu--;
				motu -= patlu;
				patlu = speedofPatlu(indexPatlu);
			} else {
				countMotu++;
				countPatlu++;
				patlu = speedofPatlu(indexPatlu);
				motu = speedofMotu(indexMotu);
			}
		}
		System.out.println(countMotu + " " + countPatlu);
		if(countMotu > countPatlu)
			System.out.println("Motu");
		else if(countMotu < countPatlu)
			System.out.println("Patlu");
		else
			System.out.println("Tie");
	}
	
	private static int speedofMotu(int indexMotu) {
		return (int) Math.ceil((arrInputs.get(indexMotu))/2);
	}
	
	private static int speedofPatlu(int indexPatlu) {
		return arrInputs.get(indexPatlu);
	}
}
