import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Pr04GroupNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        HashMap<Integer, ArrayList<Integer>> result = new HashMap<>();

        result.put(0, new ArrayList<>());
        result.put(1, new ArrayList<>());
        result.put(2, new ArrayList<>());

        for (String num: input){
            int number = Integer.parseInt(num);
            if(Math.abs(number) % 3 == 0){
                result.get(0).add(number);
            }
            if(Math.abs(number) % 3 == 1){
                result.get(1).add(number);
            }
            if(Math.abs(number) % 3 == 2){
                result.get(2).add(number);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}
