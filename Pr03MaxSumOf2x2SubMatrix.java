import java.util.Scanner;

public class Pr03MaxSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int[][] templateMatrix = new int[2][2];
        int tmpSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                tmpSum = matrix[i][j]
                        + matrix[i][j + 1]
                        + matrix[i + 1][j]
                        + matrix[i + 1][j + 1];

                if(tmpSum > maxSum){
                    maxSum = tmpSum;
                    templateMatrix[0][0] = matrix[i][j];
                    templateMatrix[0][1] = matrix[i][j + 1];
                    templateMatrix[1][0] = matrix[i + 1][j];
                    templateMatrix[1][1] = matrix[i + 1][j + 1];
                }
            }
        }
        for (int i = 0; i < templateMatrix.length; i++) {
            for (int j = 0; j < templateMatrix[i].length; j++) {
                System.out.print(templateMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);

    }

    private static int[][] readMatrix(Scanner scanner) {
        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int matrix[][] = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            String[] row = scanner.nextLine().split(", ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        return matrix;
    }
}
