import java.util.Scanner;

public class Pr03EDiagonalDiff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        int leftSum = 0;
        int rightSum = 0;

        for (int j = 0; j < matrix.length; j++) {
            leftSum += matrix[j][j];
            rightSum += matrix[matrix.length - 1 - j][j];
        }
        int result = Math.abs(leftSum - rightSum);
        System.out.println(result);
    }
}
