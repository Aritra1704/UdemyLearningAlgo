package algo.quicksort;

import java.util.Arrays;

public class AppQuickSort {

	public static void main(String[] args) {
		int[] myarray = new int[] { 9, 8, 5, 20, 56, 1, 2, 76, 23};
		
		quickSort(myarray, 0, myarray.length - 1);
		
		System.out.print(Arrays.toString(myarray));

	}

	public static void quickSort(int[] inputArray, int start, int end) {
		if(start < end) {
			int pivot = partition(inputArray, start, end);
			quickSort(inputArray, start, pivot - 1);
			quickSort(inputArray, pivot + 1, end);
		}
	}
	
	public static int partition(int[] inputArray, int start, int end) {
		int pivot = end;
		
		int i = start - 1;
		for(int j = start; j <= end - 1; j++) {
			if(inputArray[j] < inputArray[pivot]) {
				i++;
				swap(inputArray, i, j);
			}
		}
		i++;
		swap(inputArray, i, pivot);
		return i;
	}
	
	public static void swap(int o[], int initial, int actual) {
		int temp = o[initial];
		o[initial] = o[actual];
		o[actual] = temp;
	}
}
