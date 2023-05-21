//Program to find the sum of each row  and coloumn elements of a matrix
public class MatrixSum {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        // Calculate row sums
        int[] rowSums = new int[rows];
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < columns; j++) {
                rowSum += matrix[i][j];
            }
            rowSums[i] = rowSum;
        }
        
        // Calculate column sums
        int[] columnSums = new int[columns];
        for (int j = 0; j < columns; j++) {
            int columnSum = 0;
            for (int i = 0; i < rows; i++) {
                columnSum += matrix[i][j];
            }
            columnSums[j] = columnSum;
        }
        
        // Print row sums
        System.out.println("Row sums:");
        for (int i = 0; i < rows; i++) {
            System.out.println("Row " + (i + 1) + ": " + rowSums[i]);
        }
        
        // Print column sums
        System.out.println("Column sums:");
        for (int j = 0; j < columns; j++) {
            System.out.println("Column " + (j + 1) + ": " + columnSums[j]);
        }
    }
}
