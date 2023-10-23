package main;
import java.util.Random;


public class driver {

	public static void main(String[] args) {
		int[] array  = GenerateRandomArray(1000-000-000);
		long start = System.nanoTime();
		MergeSort(array, 0, 1000-000-000 - 1);
		long end = System.nanoTime();
		System.out.println("Merge Sort 1000,000,000 array took " + (end - start) + " ns.");
		
	}
	
	public static int[] GenerateRandomArray(int size) {
		Random rand = new Random();
		int[] returnVal = new int[size];
		for(int i = 0; i < size; i++) {
			returnVal[i] = i;
		}
		for(int i = 0; i < size; i++) {
			int index = rand.nextInt(size);
			if (index != i) {
				int temp = returnVal[i];
				returnVal[i] = returnVal[index];
				returnVal[index] = returnVal[i];
			}
		}
		return returnVal;
	}
	
	public static void MergeSort(int[] arr, int start, int end) {
		//terminate step
		if (start == end) {
			return;
		}
		int mid = (start + end) / 2;
		MergeSort(arr, start, mid);
		MergeSort(arr, mid + 1, end);
		Merging(arr, start, mid, end);
	}
	
	public static void Merging(int[] arr, int start, int mid, int end) {
		//origin = 3, 6, 8, 2, 4, 5
		//leftArray = 3, 6, 8
		//rightArray = 2, 4, 5;
		//result array = 2, 3, 4, 5, 6, 9
		int leftStart = start;
		int leftEnd = mid;
		int rightStart = mid + 1;
		int rightEnd = end;
		int[] tempArr = new int[end - start + 1];
		int counter = 0;
		while(leftStart <= leftEnd && rightStart <= rightEnd) {
			if (arr[leftStart] < arr[rightStart]) {
				tempArr[counter] = arr[leftStart];
				counter++;
				leftStart++;
			} else {
				tempArr[counter] = arr[rightStart];
				counter++;
				rightStart++;
			}
		}
		
		while (leftStart<=leftEnd) {
			tempArr[counter] = arr[leftStart];
			counter++;
			leftStart++;
		}
		
		while(rightStart<=rightEnd) {
			tempArr[counter] = arr[rightStart];
			counter++;
			rightStart++;
		}
		
		//move everything from tempArr to arr
		for(int i = 0; i< counter;i++) {
			arr[start] = tempArr[i];
			start++;
		}
		
	}

}
