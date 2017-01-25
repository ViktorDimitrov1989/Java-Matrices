import java.util.ArrayList;
import java.util.Scanner;

public class PrE11StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();


        ArrayList<ArrayList<String>> matrix = new ArrayList<>();
        int row = 0;
        while (true) {
            String inputLine = scanner.nextLine();
            if (inputLine.equals("END")) {
                break;
            }
            String[] splitedLine = inputLine.split("");

            matrix.add(new ArrayList<>());
            for (int col = 0; col < splitedLine.length; col++) {
                matrix.get(row).add(splitedLine[col]);
            }
            row++;
        }
        int startIndex = command.indexOf("(") + 1;
        int endIndex = command.indexOf(")");
        int degrees = Integer.parseInt(command.substring(startIndex, endIndex));
        int rotations = degrees / 90;



        for (int i = 0; i < rotations; i++) {
            matrix = rotateMatrix(matrix);
        }
        printMatrix(matrix);
    }

    private static ArrayList<ArrayList<String>> rotateMatrix(ArrayList<ArrayList<String>> matrix) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        int maxLength = getMaxRowLength(matrix);

        for (int i = matrix.get(maxLength).size() - 1; i >= 0; i--) {
            result.add(new ArrayList<>());
            for (int j = 0; j < matrix.size(); j++) {
                int elementRow = matrix.size() - 1 - j;
                int elementCol = matrix.get(maxLength).size() - 1 - i;
                String element;
                if (elementCol > matrix.get(elementRow).size() - 1) {
                    element = " ";
                } else {
                    element = matrix.get(elementRow).get(elementCol);
                }
                int resultRow = matrix.get(maxLength).size() - 1 - i;
                int resultCol = j;
                result.get(resultRow).add(resultCol, element);
            }
        }

        return result;
    }

    private static int getMaxRowLength(ArrayList<ArrayList<String>> matrix) {
        int maxLength = 0;
        int maxSize = 0;
        for (int i = 0; i < matrix.size(); i++) {
            if(matrix.get(i).size() > maxSize){
                maxLength = i;
                maxSize = matrix.get(i).size();
            }
        }
        return maxLength;
    }

    private static void printMatrix(ArrayList<ArrayList<String>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j));
            }
            System.out.println();
        }
    }
}
