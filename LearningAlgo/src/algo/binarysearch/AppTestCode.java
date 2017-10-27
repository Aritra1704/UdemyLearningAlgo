package algo.binarysearch;

import java.util.HashMap;

public class AppTestCode {

	private static HashMap<Integer, String> hash;
	private final static String GOOD = "GOOD";
	private final static String BAD = "BAD";
	public static void main(String[] args) {
		hash = new HashMap<Integer, String>();
		hash.put(1, GOOD);
		hash.put(2, GOOD);
		hash.put(3, BAD);
		hash.put(4, BAD);
		hash.put(5, BAD);
		
		System.out.println(findFirstBadRev(1, 5));
	}
	
	static boolean isGood(int rev) {
		if(hash.get(rev).equalsIgnoreCase(GOOD))
			return true;
		else
			return false;
	}

	static int findFirstBadRev(int startRev, int endRev) {
	  int middle = 0;
	  while(startRev <= endRev) {
	    middle = (startRev + endRev) / 2;
	    boolean goodRev = isGood(middle);
	    if(goodRev)
	      startRev = middle + 1;//4
	    else if(startRev == middle)
	    	break;
	    else 
	      endRev = middle;
	  }
	  
	  return middle;
	}

}
