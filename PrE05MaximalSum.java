import java.util.Scanner;

public class PrE05MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];
        int[][] templateMatrix = new int[3][3];
        
        
        for (int i = 0; i < matrix.length; i++) {
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        int tmpSum = 0;
        int maxSum = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                tmpSum = calcSum(matrix, i, j);
                if(tmpSum > maxSum){
                    maxSum = tmpSum;
                    templateMatrix = fillTemplate(matrix,templateMatrix,i,j);
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMatrix(templateMatrix);

    }

    private static int[][] fillTemplate(int[][] matrix, int[][] templateMatrix, int startRow, int startCol) {
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                templateMatrix[k][i] = matrix[k + startRow][i + startCol];
            }
        }
        return templateMatrix;
    }

    private static int calcSum(int[][] matrix, int startRow, int startCol) {
        int sum = 0;
        for (int k = startRow; k < startRow + 3; k++) {
            for (int i = startCol; i < startCol + 3; i++) {
                sum += matrix[k][i];
            }
        }
        return sum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
