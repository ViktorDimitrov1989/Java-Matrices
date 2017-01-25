import java.util.Scanner;

public class PrE09TeroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (true){
            int startIndex = input.indexOf("|");
            if(startIndex == -1){
                break;
            }
            int endIndex = input.indexOf("|", startIndex + 1) + 1;
            String bomb = input.substring(startIndex + 1,endIndex - 1);
            int power = calcPower(bomb);
            if(endIndex + power > input.length() - 1){
                endIndex = input.length();
                power = 0;
            }
            if(startIndex - power < 0){
                startIndex = 0;
                power = 0;
            }
            String toReplace = input.substring(startIndex - power, endIndex + power);
            input = input.replace(toReplace, repeat(toReplace));
        }
        System.out.println(input);
    }

    private static CharSequence repeat(String toReplace) {
        String dot = ".";
        for (int i = 0; i < toReplace.length() - 1; i++) {
            dot += ".";
        }
        return dot;
    }

    private static int calcPower(String bomb) {
        int power = 0;
        for (int i = 0; i < bomb.length(); i++) {
            power += (char)bomb.charAt(i);
        }
        power = power % 10;
        return power;
    }
}
