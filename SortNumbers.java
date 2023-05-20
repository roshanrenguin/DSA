//Bubble sort in Java
public class SortNumbers {
    public static void bubbleSort(int[] numbers) {
        int n = numbers.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    // Swap the numbers
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 3, 1};
        System.out.println("Array before sorting:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        bubbleSort(numbers);
        
        // Print the sorted numbers
        System.out.println("Sorted Array in Ascending Order:");
        for (int j = 0; j < numbers.length; j++) {
            System.out.print(numbers[j] + " ");
        }
    }
}
