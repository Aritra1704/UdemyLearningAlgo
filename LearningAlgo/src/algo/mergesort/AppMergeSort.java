package algo.mergesort;

public class AppMergeSort {

	public static void main(String[] args) {
		int[] myarray = new int[] { 9, 8, 5, 20, 56, 1, 2, 76, 23};
		
		mergesort(myarray, 0, myarray.length - 1);
		
		for(int i = 0; i < myarray.length; i++) {
			System.out.print(myarray[i] + " ");
		}

	}

	public static void mergesort(int[] a, int min, int max) {
		if(max <= min)
			return;
		
		int middle = (max + min)/2;
		mergesort( a, min, middle);
		mergesort( a, middle + 1, max);
		
		merge(a, min, middle, max);
	}
	
	private static void merge(int[] a, int min, int middle, int max) {
		int[] tempArray = new int[max - min + 1];
		
		int leftslot = min;
		int rightslot = middle+1;
		
		int k = 0;
		while(leftslot <= middle && rightslot <= max) {
			if(a[leftslot] < a[rightslot]) {
				tempArray[k] = a[leftslot++];
			} else {
				tempArray[k] = a[rightslot++];
			}
			k++;
		}
		
		if(leftslot <= middle) {
			while(leftslot <= middle) {
				tempArray[k++] = a[leftslot++];
			}
		} else if(rightslot <= max) {
			while(rightslot <= max) {
				tempArray[k++] = a[rightslot++];
			}
		}
		
		for(int i = 0; i < tempArray.length; i++) {
			a[min + i] = tempArray[i];
		}
	}
}
