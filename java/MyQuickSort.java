import java.util.*;

public class MyQuickSort{
	public int partition(int[] arr, int start , int end){
		int pivot = arr[end];
		int current_element = start - 1;
		for(int x = start ; x <= end - 1; x++){
			if(arr[x] <= pivot){
				current_element++;
				int temp = arr[current_element];
				arr[current_element] = arr[x];
				arr[x] = temp;
			}
		}
		int temp = arr[current_element+1];
		arr[current_element+1] = arr[end];
		arr[end] = temp;
		return current_element+1;
	}
	public void sort(int[] arr, int start , int end){
		if(start < end){
			int pivot_index = partition(arr,start,end);
			sort(arr,start,pivot_index-1);
			sort(arr,pivot_index+1,end);
		}
	}
	public static void main(String[] args){
		int[] arr = arrayPopulate();
		MyQuickSort mqs = new MyQuickSort();
		long time = System.currentTimeMillis();
		mqs.sort(arr, 0 , arr.length-1);
		printArray(arr);
		time = System.currentTimeMillis() - time;
		//printArray(arr);
		System.out.println("Time (milliseconds) : " + time);
	}
	public static int[] arrayPopulate(){
		int[] arr = new int[10000];
		Random ran = new Random();
		for(int x = 0 ; x < arr.length ; x++){
			arr[x] = ran.nextInt(1000000);
		}
		return arr;
	}
	public static void printArray(int[] arr){
		for(int x : arr){
			System.out.print(x + " | ");
		}
		System.out.print("\n");
	}
	public static boolean isSorted(int[] arr){
		for(int x = 0 ; x < arr.length-1 ; x++){
			if(arr[x] > arr[x+1]){
				return false;
			}
		}
		return true;
	}
}