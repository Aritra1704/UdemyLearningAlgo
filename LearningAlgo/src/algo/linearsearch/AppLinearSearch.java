package algo.linearsearch;

public class AppLinearSearch {

	public static void main(String[] args) {
		

		int[] a = {2,3,4,5,6,7,8,90,1,23};
		int x = 6;
		
		String response = "";
//		int resp = linearSearch(a, x);
		int resp = linearSearchRecur(a, 0, x);
		if(resp >= 0)
			response = "Value is at position: " + resp;
		else
			response = "Value not found.";
		
		System.out.println(response);
	}
	
	public static int linearSearch(int[] a, int x) {
		int i;
		int answer = -1;
		for(i = 0; i < a.length; i++) {
			if(a[i] == x) {
				answer = i;
				break;
			}
		}
		
		return answer;
	}

	public static int linearSearchRecur(int[] a, int i, int x) {
		
		if(i > (a.length - 1))
			return -1;
		else if(a[i] == x)
			return i;
		else 
			return linearSearchRecur(a,  i + 1, x);
	}
}
