package Testing;
import static java.lang.Math.*;

public class Exam1 {

	public static void main(String[] args) {
		
		int[] arr = {9,6,3,2,4,1,20,10};
//		System.out.println(arr.length);
		int[] k;
		k = new int[10];
		int[] p;
		p = new int[]{1,2,3,4,5};
		k = new int[]{4,3,5,6,4,3,5,7,5};
		
		selectionSort(arr);
		
		//print array after sort
		for(int i : arr) {
			System.out.print(i);
		}	
		System.out.println("\n");
		
		//big array for search
		int[] bigArr = new int[100];
		
		for(int i = 0; i < bigArr.length; i++) {
			bigArr[i] = i;
		}
		
		binarySearch(bigArr, 51);
	}//end main
	
	public static void selectionSort(int[] arr) {
		//selection sort with j array
		for(int i = 0; i < arr.length - 1; i++) {
			//current min index
			int min = i;
			System.out.println("\nMain iteration number " + i + " minimum value is currently " + arr[min]);
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
				System.out.println("After inner loop min is now " + arr[min]);
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			System.out.println("After inner loop temp var is " + temp + " and index " + i + " of array is " + arr[i]);
		}
	}
	
	public static int binarySearch(int[] array, int target) {
		int low = 0;//beginning
		int high = array.length - 1;//end
		
		while(low <= high) {
			System.out.println("The high index is " + high + " and the low index is " + low);
			int middle = low + (high - low) / 2;
			int value = array[middle];
			System.out.println("middle: " + value + " at index " + middle);
			
			if(value < target)
				low = middle + 1;
			else if(value > target)
				high = middle - 1;
			else
				return middle;
		}//end while
		
		
		return -low -1;
	}
	

}
