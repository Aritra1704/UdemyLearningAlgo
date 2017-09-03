package algo.selectionsort;

public class AppSelectionSort {

	public static void main(String[] args) {
		int[] myarray = selectionSort(new int[] {9,8,5,20,56,1});
		for(int i = 0; i < myarray.length; i++) {
			System.out.print(myarray[i] + " ");
		}

	}

	public static int[] selectionSort(int o[]) {
		int minimum = -1;
		for(int i = 0; i < o.length; i++) {
			minimum = i;
			for(int j = i + 1; j < o.length; j++) {
				if(o[j] < o[minimum])//if we find a smaller value 
					minimum = j;
			}
			if(minimum != i)
				swap(o, i, minimum);
		}
		return o;
	}
	
	public static void swap(int o[], int initial, int actual) {
		int temp = o[initial];
		o[initial] = o[actual];
		o[actual] = temp;
	}
}
