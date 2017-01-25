import java.util.Scanner;

public class Pr05PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        long[][] matrix = new long[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = new long[i + 1];
        }

        matrix[0][0] = 1;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 1;
            matrix[i][matrix[i].length - 1] = 1;
            for (int j = 1; j < matrix[i].length - 1; j++) {
               matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(long[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
