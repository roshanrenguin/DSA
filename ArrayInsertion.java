//java program for inserting a new element to the specified position of an array 
import java.util.Scanner;
public class ArrayInsertion {
    public static void main(String[] args) {
    	int n, position;
    	Scanner s = new Scanner(System.in);
    	System.out.print("Enter no. of elements in array:");
    	n = s.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements:");
        for(int i = 0; i < n; i++)
        {
        	array[i] = s.nextInt();
        }
        System.out.print("Enter the element to be inserted:");
        int element = s.nextInt();
        System.out.print("Enter the position to insert element:");
        position = s.nextInt();
        s.close();

        
        System.out.println("Original Array:");
        printArray(array);
        
     // Create a new array with increased size
        int[] newArray = new int[array.length + 1];
        
        // Copy elements to the new array until the specified position
        for (int i = 0; i < position-1; i++) {
            newArray[i] = array[i];
        }
        // Insert the new element at the specified position
        newArray[position-1] = element;
        // Copy the remaining elements from the original array
        for (int i = position-1; i < array.length; i++) {
            newArray[i + 1] = array[i];
        }
        System.out.println("Array after insertion:");
        printArray(newArray);
    }
    
    // Helper method to print the elements of an array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
