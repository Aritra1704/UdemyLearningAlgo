package dynamicprog;

/*
 * "Imagine you have a collection of N wines placed next to each other on a shelf. For simplicity, 
 * let's number the wines from left to right as they are standing on the shelf with integers from 1 to N, respectively. 
 * The price of the ith wine is pi. (prices of different wines can be different).
 * 
 * Because the wines get better every year, supposing today is the year 1, on year y the price of the ith wine will be y*pi, 
 * i.e. y-times the value that current year.
 * 
 * You want to sell all the wines you have, but you want to sell exactly one wine per year, starting on this year. 
 * One more constraint - on each year you are allowed to sell only either the leftmost or the rightmost wine on the shelf and you are not 
 * allowed to reorder the wines on the shelf (i.e. they must stay in the same order as they are in the beginning).
 * 
 * You want to find out, what is the maximum profit you can get, if you sell the wines in optimal order?"
 */

//https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/tutorial/

public class GreedyWineCellar {

	static int N = 0;
	static int p[];
	
	public static void main(String[] args) {
		
		p = new int[] {2,3,5,1,4};
//		p = new int[] {2,3}; 
		N = p.length;
		
		System.out.println("Begin: " + 0 + " End: " + (N - 1));
		int result = profit(0, N - 1);
		System.out.println(result);
	}

	private static int profit(int begin, int end) {
		if(begin > end)
			return 0;
		
		int year = N - (end - begin + 1) + 1;
		
	/*	
	 * Explanation
		int left = profit(begin + 1, end) + year * p[begin];
		int right = profit(begin, end - 1) + year * p[end];
		System.out.println("Begin: " + begin + " End: " + end + " Year: " + year + " Left: " + left + " Right: " + right);
		return max(left, right);
	 * 
	 */
		
		return max(
				profit(begin + 1, end) + year * p[begin],
				profit(begin, end - 1) + year * p[end]);
	}
	
	private static int max(int begin, int end) {
		if(begin > end)
			return begin;
		return end;
	}
}
