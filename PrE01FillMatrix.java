import java.util.Scanner;

public class PrE01FillMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        String pattern = input[1];
        int dimensions = Integer.parseInt(input[0]);
        int[][] matrix = new int[dimensions][dimensions];
        if(pattern.equals("A")){
            matrix = fillUpToDown(matrix);
        }
        else{
            matrix = fillDownToUp(matrix);
        }
        printMatrix(matrix);

    }

    private static int[][] fillDownToUp(int[][] matrix) {
        int cnt = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i % 2 == 0){
                    matrix[j][i] = cnt;
                    cnt++;
                }
                else{
                    matrix[matrix.length - 1 - j][i] = cnt;
                    cnt++;
                }
            }
        }

        return matrix;
    }

    private static int[][] fillUpToDown(int[][] matrix) {
        int cnt = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = cnt;
                cnt++;
            }
        }
        return matrix;
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
