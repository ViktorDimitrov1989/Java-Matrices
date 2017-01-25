import java.util.Scanner;

public class PrE09TeroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());

        while (true){
            int startIndex = input.indexOf("|");
            if(startIndex != - 1){
                int endIndex = input.indexOf("|",startIndex + 1);
                String bombContent = input.substring(startIndex + 1,endIndex);
                int bombPower = calcPower(bombContent);
                int start = Math.max(0,startIndex - bombPower);
                int end = Math.min(input.length() - 1,endIndex + bombPower);
                while (start <= end){
                    input.setCharAt(start, '.');
                    start++;
                }
            }
            else{
                break;
            }

        }
        System.out.println(input.toString());

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
