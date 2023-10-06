package binary;

public class Driver {

	public static void main(String[] args) {
		int[] target = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int returnVal = -1;
		returnVal = BinarySearch(target, 1);
		//System.out.println("1 is at the position of: " + returnVal);
		
		int[][] matrix = new int[4][3];
		int c = 0;
		for(int y = 0; y < matrix[0].length; y++) {
			for (int x = 0; x < matrix.length; x++) {
				c = y * 4 + x;
				matrix[x][y] = c;
			}
		}
		String output = "";
		for(int y = 0; y < 3; y++) {
			for (int x = 0; x < 4; x++) {
				output = output + matrix[x][y] + ", ";
			}
			output = output + ";\r";
		}
		System.out.println(output);
		System.out.println("Search 5 in the array");
		int[] result1 = BinaryMatrixSearch1(matrix, 9);
		System.out.println("9 is at (" + result1[0] + "," + result1[1] + ")");
	}
	
	//what does this function do
	//BinarySearch is doing binary search on an integer array
	//what are the arguments of the function
	//arr is a sorted ascending array 
	//what is the return value
	//if the function find the value: return 0-(length-1)
	//if we do not find the value: return -1
	public static int BinarySearch(int[] arr, int value) {
		int low, high, mid;
		low = 0;
		high = arr.length - 1;
		while(low <= high) {
			mid = (low + high) / 2;
			//(1 + 6) / 2 = 3.5f -> 3(int)
			if (arr[mid] == value) {
				return mid; //found it!
			} else if(arr[mid] < value) {
				//the value should be on the upper half
				low = mid + 1;
			} else {
				//the value must be on the lower half
				high = mid - 1;
			}
		}
		return -1;
	}
	
	static int width = 4;
	static int height = 3;
	//convert the 2-d matrix into 1-d
	public static int[] BinaryMatrixSearch1(int[][] arr, int value) {
		int low, high, mid, y, x;
		low = 0;
		high = width * height - 1;
		while(low <= high) {
			mid = (low + high) / 2;
			//(1 + 6) / 2 = 3.5f -> 3(int)
			y = mid / width;
			x = mid - y * width;
			if (arr[x][y] == value) {
				return new int[] {x, y}; //found it!
			} else if(arr[x][y] < value) {
				//the value should be on the upper half
				low = mid + 1;
			} else {
				//the value must be on the lower half
				high = mid - 1;
			}
		}
		return null;
	}
	
	//two step solution
	//use binary search on the first element of each row, and then
	//search the row which is likely to contain the searching value
	public static int[] BinaryMatrixSearch2(int[][] arr, int value) {
		int low, high, mid, x, y;
		low = 0;
		high = arr.length - 1;
		while(low <= high) {
			mid = (low + high) / 2;
			//(1 + 6) / 2 = 3.5f -> 3(int)
			if (arr[mid][0] <= value && arr[mid][arr.length - 1] >= value) {
				//another binary search;
				x = BinarySearch(arr[mid], value);
				return new int[] {x, mid};
			} else if(arr[mid][0] < value) {
				//the value should be on the upper half
				low = mid + 1;
			} else {
				//the value must be on the lower half
				high = mid - 1;
			}
		}
		return null;
	}
}

