
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: array is already sorted or empty
        }
        
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    
                    swapped = true;
                }
            }
            
            // If no two elements were swapped in the inner loop,
            // the array is already sorted
            if (!swapped) {
                break;
            }
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
        
        bubbleSort(arr);
        
        System.out.println("Sorted array: ");
        printArray(arr);
    }
}
