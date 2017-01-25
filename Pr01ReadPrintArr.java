import java.util.Arrays;
import java.util.Scanner;

public class Pr01ReadPrintArr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String[] arr = new String[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine();
        }
        Arrays.sort(arr);
        for (String name: arr){
            System.out.println(name);
        }
    }
}
