public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: array is already sorted or empty
        }
        
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        
        // Split the array into two halves
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }
        
        // Recursive calls to sort the two halves
        mergeSort(left);
        mergeSort(right);
        
        // Merge the sorted halves
        merge(arr, left, right);
    }
    
    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
    
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
			System.out.println();
	}
    
    public static void main(String[] args) {
        int[] arr = { 5, 2, 9, 1, 7, 6, 3 };
        
        System.out.println("Original array: " );
        printArray(arr);
        
        
        mergeSort(arr);
        
        System.out.println("Sorted array: ");
        printArray(arr);
        
    }
}
