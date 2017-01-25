import java.util.ArrayDeque;
import java.util.Scanner;

public class PrE13ToTheStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Star> starDeque = new ArrayDeque<>();

        for (int i = 0; i < 3; i++) {
            String[] starData = scanner.nextLine().split(" ");
            String name = starData[0];
            double x = Double.parseDouble(starData[1]);
            double y = Double.parseDouble(starData[2]);

            Star currentStar = new Star(x, y, name);
            starDeque.add(currentStar);
        }

        String[] startCoordinates = scanner.nextLine().split(" ");
        double startRow = Double.parseDouble(startCoordinates[1]);
        double startCol = Double.parseDouble(startCoordinates[0]);

        int moves = scanner.nextInt();


        while (moves != -1) {
            String output = checkLocation(starDeque, startRow, startCol);
            if(output != null){
                System.out.println(output.toLowerCase());
            }
            else{
                System.out.println("space");
            }
            startRow++;
            moves--;
        }
    }

    private static String checkLocation(ArrayDeque<Star> starDeque, double startRow, double startCol) {
        for (int i = 0; i < 3; i++) {
            Star currentStar = starDeque.removeFirst();

            double starX = currentStar.x;
            double starY = currentStar.y;

            double leftBorder = starX - 1;
            double rightBorder = starX + 1;

            double downBorder = starY - 1;
            double upBorder = starY + 1;

            if (startRow >= downBorder
                    && startRow <= upBorder
                    && startCol >= leftBorder
                    && startCol <= rightBorder) {
                starDeque.addLast(currentStar);
                return currentStar.name;
            }
            else{
                starDeque.addLast(currentStar);
            }
        }
        return null;
    }

    public static class Star {
        double x;
        double y;
        String name;

        public Star(double x, double y, String name) {
            this.x = x;
            this.y = y;
            this.name = name;
        }
    }
}
