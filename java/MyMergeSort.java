import java.util.*;
import java.lang.*;
public class MyMergeSort{
	public void sort(int[] arr){
		mergesort(arr,0,arr.length-1);
	}
	private void mergesort(int[] arr , int start , int end){
		if(start < end){
			int middle = (start+end)/2;
			mergesort(arr,start,middle);
			mergesort(arr,middle+1,end);
			merge(arr,start,middle,end);
		}
	}
	private void merge(int[] arr, int start, int middle, int end){
		int[] tempArr = new int[arr.length];
		for(int x = start ; x <= end; x++){
			tempArr[x] = arr[x];
		}
		int first_part_index =  start;
		int temp_index  = start;
		int second_part_index = middle + 1;
		while( first_part_index <= middle && second_part_index <= end){
			if(tempArr[first_part_index] <= tempArr[second_part_index]){
				arr[temp_index] = tempArr[first_part_index];
				first_part_index++;
			}else{
				arr[temp_index] = tempArr[second_part_index];
				second_part_index++;
			}
			temp_index++;
		}
		while( first_part_index <= middle){
			arr[temp_index] = tempArr[first_part_index];
			first_part_index++;
			temp_index++;
		}
		while(second_part_index <= end){
			arr[temp_index] = tempArr[second_part_index];
			second_part_index++;
			temp_index++;
		}
	}
	public static void main(String[] args){
		int[] arr = arrayPopulate();
		//printArray(arr);
		//System.out.println(isSorted(arr));
		MyMergeSort mms = new MyMergeSort();
		long time = System.currentTimeMillis();
		mms.sort(arr);
		time = System.currentTimeMillis() - time;
		//printArray(arr);
		System.out.println(isSorted(arr));
		System.out.println("Time (milliseconds) : " + time);
	}
	public static int[] arrayPopulate(){
		int[] arr = new int[100000];
		Random ran = new Random();
		for(int x = 0 ; x < arr.length ; x++){
			arr[x] = ran.nextInt(999);
		}
		return arr;
	}
	public static void printArray(int[] arr){
		for(int x : arr){
			System.out.print(x + " ");
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