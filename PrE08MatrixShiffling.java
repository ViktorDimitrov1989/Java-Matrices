import java.util.Scanner;

public class PrE08MatrixShiffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = row[j];
            }
        }


        while (true){
            String[] command = scanner.nextLine().split(" ");
            if(command[0].equals("END")){
                break;
            }
            if(!command[0].equals("swap") || command.length != 5){
                System.out.println("Invalid input!");
            }
            else{
                matrix = swap(matrix, command);
            }

        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] swap(String[][] matrix, String[] command) {
        int row1 = Integer.parseInt(command[1]);
        int col1 = Integer.parseInt(command[2]);
        int row2 = Integer.parseInt(command[3]);
        int col2 = Integer.parseInt(command[4]);


        String tmp = "";
        try{
            tmp = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = tmp;
            printMatrix(matrix);
        }
        catch (Exception e){
            System.out.println("Invalid input!");
        }
        return matrix;
    }
}
