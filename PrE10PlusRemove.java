import java.util.*;

public class PrE10PlusRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<ArrayList<String>> matrix = new ArrayList<>();
        ArrayList<ArrayList<String>> matrixToLower = new ArrayList<>();
        int row = 0;
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }
            String[] inputRow = line.split("");
            String[] inputRowToLowerCase = line.toLowerCase().split("");
            matrix.add(row,new ArrayList<String>(inputRow.length));
            matrix.get(row).addAll(Arrays.asList(inputRow));

            matrixToLower.add(row,new ArrayList<String>(inputRowToLowerCase.length));
            matrixToLower.get(row).addAll(Arrays.asList(inputRowToLowerCase));
            row++;

        }

        for (int i = 1; i < matrixToLower.size() - 1; i++) {
            for (int j = 1; j < matrixToLower.get(i).size() - 1; j++) {
                String middle = matrixToLower.get(i).get(j % matrixToLower.get(i).size());
                String up = matrixToLower.get(i - 1).get(j % matrixToLower.get(i - 1).size());
                String down = matrixToLower.get(i + 1).get(j % matrixToLower.get(i + 1).size());
                String left = matrixToLower.get(i).get(j - 1);
                String right = matrixToLower.get(i).get(j + 1);

                if(middle.equals(up)
                        && middle.equals(down)
                        && middle.equals(left)
                        && middle.equals(right)){
                    matrix.get(i).set(j, " ");
                    matrix.get(i - 1).set(j, " ");
                    matrix.get(i + 1).set(j, " ");
                    matrix.get(i).set(j - 1, " ");
                    matrix.get(i).set(j + 1, " ");
                }
            }
        }

        for (int i = 0; i < matrix.size(); i++) {
            for (String el: matrix.get(i)){
                if(!el.equals(" ")){
                    System.out.print(el);
                }
            }
            System.out.println();
        }
    }
}
