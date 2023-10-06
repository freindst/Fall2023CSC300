import java.util.Random;
import java.lang.Math;

public class driver {
    public static void main(String[] args){
        int[] arr = RandomArrayGenerator(1000000);
        long a = System.currentTimeMillis();
        ShellSort(arr);
        System.out.println(System.currentTimeMillis() - a);
    }

    public static int[] RandomArrayGenerator(int size) {
    	int[] result = new int[size];
		Random r = new Random();
        for(int i = 0; i < size; i++){
            result[i] = i;
        }
		for(int i = 0; i < size; i++) {
			int pos = r.nextInt(size);
            int temp = result[i];
			result[i] = result[pos];
			result[pos] = temp;
		}
		return result;
	}

    //round 1
	//1     4     7     10
	//  2     5     8
	//    3     6     9
    //round 2
	//1   3   5   7   9
	//  2   4   6   8
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

    public static void ShellSort(int[] arr){
        //interval 2^n -1 , 2^(n-1) - 1, 2^(n-2) -1, ..., 2, 1
        int length = arr.length;
        int n = (int)Math.floor(Math.log(length + 1));
        for(int i = n; i > 0; i--){
            int interval = (int)Math.pow(2, i) - 1;
            for(int start = 0; start < interval; start++){
                ShellSortPartition(arr, start, interval);
            }
        }
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

    public static void displayArray(int[] arr){
        //for-each loop in Java
        for(int element: arr){
            System.out.print(element + " >> ");
        }
        System.out.println(" ");
    }
}
