package driver;

public class Quicksort {

	public static void main(String[] args) {
		int[] array = new int[] {2, 1, 5, 4, 0, 3};
		QuickSort(array, 0, 5);
		for(int i: array) {
			System.out.print(i + " > ");
		}

	}
	
	public static int Partition(int[] arr, int lowIndex, int highIndex) {
		int low = lowIndex;
		int high = highIndex;
		
		int pivot = arr[(low + high)/2]; //this is integer division
		
		boolean done = false;
		while(!done) {
			//check the item at the low index, and stop when this item is larger
			//or equal to the pivot
			while(arr[low] < pivot && low <= highIndex) {
				low = low + 1;//low += 1;
			}
			//check the item at the high index, and stop when item is smaller
			//than the pivot
			while(arr[high] >= pivot && high > lowIndex) {
				high = high-1;
			}
			
			if (high > low) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			} else {
				done = true;
			}
		}
		return high;
	}
	
	public static void QuickSort(int[] arr, int low, int high) {
		//when quicksort stop?
		//when there is only one item is past into the quicksort method
		//when low == high
		if (low >= high) {
			return;
		} else {
			//partition
			int mid = Partition(arr, low, high);
			//recursively call quicksort
			QuickSort(arr, low, mid);
			QuickSort(arr, mid + 1, high);
		}
	}

}
