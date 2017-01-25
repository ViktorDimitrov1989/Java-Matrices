import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PrE07CollextTheCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[4][];

        for (int i = 0; i < 4; i++) {
            char[] input = scanner.nextLine().toCharArray();
            matrix[i] = new char[input.length];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input[j];
            }
        }
        char[] commands = scanner.nextLine().toCharArray();
        int hitCnt = 0;
        int coins = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case 'V': row += 1;
                    break;
                case '^': row -= 1;
                    break;
                case '>': col += 1;
                    break;
                case '<': col -= 1;
                    break;
            }
            if(row < 0){
                row = 0;
                hitCnt++;
            }
            else if(row > matrix.length - 1){
                row = matrix.length - 1;
                hitCnt++;
            }
            else if(matrix[row].length < col){
                row--;
                hitCnt++;
            }

            if(col < 0){
                col = 0;
                hitCnt++;
            }
            else if(col > matrix[row].length - 1){
                col = matrix[row].length - 1;
                hitCnt++;
            }
            if(matrix[row][col] == '$'){
                coins++;
            }
        }

        System.out.println("Coins = " + coins);
        System.out.println("Walls = " + hitCnt);
    }
}
