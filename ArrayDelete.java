//java program for deleting an element from a specified position of an array 
import java.util.Scanner;
public class ArrayDelete {
	    public static void main(String[] args) {
	    	int n, positionToDelete;
	    	Scanner s = new Scanner(System.in);
	    	System.out.print("Enter no. of elements in array:");
	    	n = s.nextInt();
	    	
	        int[] arr = new int[n];
	        System.out.println("Enter the elements:");
	        for(int i = 0; i < n; i++)
	        {
	        	arr[i] = s.nextInt();
	        }
	        System.out.print("Enter the position to delete element:");
	        positionToDelete = (s.nextInt())-1;
	        s.close();
	        

	        // Display the original array
	        System.out.println("Original Array:");
	        displayArray(arr);

	        // Delete element at the specified position
	        arr = deleteElement(arr, positionToDelete);

	        // Display the modified array
	        System.out.println("Array after deletion:");
	        displayArray(arr);
	    }

	    public static int[] deleteElement(int[] array, int position) {
	        if (position < 0 || position >= array.length) {
	            System.out.println("Invalid position");
	            return array; // Return the array as is
	        }

	        int[] newArray = new int[array.length - 1];
	        int newArrayIndex = 0;

	        for (int i = 0; i < array.length; i++) {
	            if (i != position) {
	                newArray[newArrayIndex] = array[i];
	                newArrayIndex++;
	            }
	        }

	        return newArray;
	    }

	    public static void displayArray(int[] array) {
	        for (int i = 0; i < array.length; i++) {
	            System.out.print(array[i] + " ");
	        }
	        System.out.println();
	    }
	}
