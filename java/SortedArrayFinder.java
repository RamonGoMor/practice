public class SortedArrayFinder{
	public int find(int[] arr, int f, boolean mode){
		if(mode){
			return findAsc(arr,f);
		}else{
			return findDesc(arr,f);
		}
	}
	private int findDesc(int[] arr, int f){
		int start = 0;
		int end = arr.length -1;
		int middle = arr.length/2;
		while(start <= end){
			int x = arr[start];
			int y = arr[end];
			int z = arr[middle];
			if(z == f){
				return middle;
			}else{
				if(z < f && x < f ){
					start = middle+1;
				}else if(z > f && y > f){
					end = middle-1;
				}else if(z < f){
					end = middle-1;
				}else{
					start = middle+1;
				}
				middle = (start+end)/2;
			}
		}
		return -1;
	}
	private int findAsc(int[] arr, int f){
		int start = 0;
		int end = arr.length -1;
		int middle = arr.length/2;
		while(start <= end){
			int x = arr[start];
			int y = arr[end];
			int z = arr[middle];
			if(z == f){
				return middle;
			}else{
				if(z > f && x > f ){
					start = middle+1;
				}else if(z < f && y < f){
					end = middle-1;
				}else if(z > f){
					end = middle-1;
				}else{
					start = middle+1;
				}
				middle = (start+end)/2;
			}
		}
		return -1;
	}
}