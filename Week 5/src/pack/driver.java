package pack;
import java.util.Random;

public class driver {

	public static void main(String[] args) {
		/*
		int[] array = new int[] {6, 2, 3, 4, 5};
		int[] array2 = new int[] {6, 2, 3, 4, 5};
		int[] array3 = new int[]{6, 2, 3, 4, 5};
		long a = System.nanoTime();
		InsertionSort(array);
		long b = System.nanoTime();
		System.out.println(b - a);
		long c = System.nanoTime();
		SelectionSort(array2);
		long d = System.nanoTime();
		System.out.println(d - c);
		long e = System.nanoTime();
		BubbleSort(array3);
		long f = System.nanoTime();
		System.out.println(f - e);
		*/
		RandomArrayGenerator(5);
	}
	
	public static void SelectionSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int smallestIndex = i;
			for(int j = i; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					smallestIndex = j;
				}
			}
			if (smallestIndex != i) {
				int temp = arr[i];
				arr[i] = arr[smallestIndex];
				arr[smallestIndex] = temp;
			}
		}
	}
	
	public static void InsertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int curr = i;
			for(int j = i - 1; j >= 0; j--) {
				if (arr[curr] >= arr[j]) {
					break;
				} else {
					int temp = arr[j];
					arr[j] = arr[curr];
					arr[curr] = temp;
					curr = j;
				}
			}
		}
	}
	
	public static void BubbleSort(int[] arr) {
		for(int i = 0; i < arr.length - 2; i++) {
			for(int j = 0; j < arr.length - 2 - i; j++) {
				if (arr[j + 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	//array containing non-repeat numbers
	//[1, 2, 2, 1, 2, 2] I don't want
	//[3, 1, 5, 4, 2, 6] I want
	//ideas?
	//roll the dice, and check if it has appeared, if not, keep it
	//1 - 100, random pick one item out one by one, and place in a sequence
	//shuffle
	public static int[] RandomArrayGenerator(int size) {
		int[] result = new int[size];
		Random r = new Random();
		for(int i = 0; i < size; i++) {
			int pos = r.nextInt(size);
			result[i] = pos;
			result[pos] = i;
		}
		return result;
	}
	
	//1. partitionally shell sort
	//1 2 3 4 5 6 7 8 9
	//round 1
	//1     4     7
	//  2     5     8
	//    3     6     9
	//round 2
	//1   3   5   7   9
	//  2   4   6   8
	//round 3
	//1 2 3 4 5 6 7 8 9
	public static void ShellSortPartition(int[] arr, int startIndex, int interval) {
		for(int i = startIndex; i < arr.length; i = i + interval) {
			int pos = i;
			while(pos - interval >= startIndex && arr[pos - interval] > arr[pos]) {
				int temp = arr[pos];
				arr[pos] = arr[pos - interval];
				arr[pos - interval] = temp;
				pos = pos - interval;
 			}
		}
	}
}

