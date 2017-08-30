package algo.binarysearch;

public class AppBinarySearch {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int value = 52;
		int position = binarySearchRecur(arr, value, 0, (arr.length - 1));
//		int position = binarySearch(arr, value);
		
		if(position >= 0)
			System.out.println("Value is located at: " + (position + 1));
		else
			System.out.println("Value not found.");
	}
	
	private static int binarySearch(int[] arr, int value) {
		
		int start = 0;
		int end = arr.length - 1;
		int middle;
		
		while(start <= end) {
			middle = (start + end)/2;
			if(arr[middle] == value)
				return middle;
			else if(arr[middle] > value)
				end = middle - 1;
			else if(arr[middle] < value)
				start = middle + 1;
		}
		
		return -1;
	}
	
	private static int binarySearchRecur(int[] arr, int value, int start, int end) {
		
		if(start > end)
			return -1;
		else {
			int middle = (start + end) /2;
			if(arr[middle] == value)
				return middle;
			else if(arr[middle] > value)
				return binarySearchRecur(arr, value, start, middle -1);
			else
				return binarySearchRecur(arr, value, middle + 1, end);
		}
	}
	
}
