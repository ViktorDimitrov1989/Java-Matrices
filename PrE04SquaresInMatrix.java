import java.util.Scanner;

public class PrE04SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        String[][] matrix = new String[rows][cols];

        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = row[j];
            }
        }
        cnt = checkForSquares(matrix);
        System.out.println(cnt);

    }

    private static int checkForSquares(String[][] matrix) {
        int cnt = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j].equals(matrix[i][j + 1])
                        && matrix[i][j + 1].equals(matrix[i + 1][j])
                        && matrix[i + 1][j].equals(matrix[i + 1][j + 1])) {
                        cnt++;
                }
            }
        }
        return cnt;
    }
}
