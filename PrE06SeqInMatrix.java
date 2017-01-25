import java.util.*;

public class PrE06SeqInMatrix {
        private  static int SEQUENCE_COUNT=0;
        private static String SEQUENCE_SYMBOL="";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input=console.nextLine().split(" ");
        int rows=Integer.parseInt(input[0]);
        int cols=Integer.parseInt(input[1]);

        String[][] matrix= new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i]=console.nextLine().split(" ");
        }

        List<String> sequence=new ArrayList<>();

        //rows
        for (int i = 0; i < matrix.length; i++) {
            sequence.addAll(Arrays.asList(matrix[i]));
            checkForSequence(sequence);
        }
        //by column
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                sequence.add(matrix[row][col]);
            }

            checkForSequence(sequence);
        }

        //by diagonal
        int diagSize=Math.min(rows,cols);

        for (int i = 0; i < diagSize; i++) {
            sequence.add(matrix[i][i]);
        }
        checkForSequence(sequence);

        for (int i = 0; i < SEQUENCE_COUNT; i++) {
            System.out.printf("%s, ",SEQUENCE_SYMBOL);
        }
    }

    private static void checkForSequence(List<String> sequence) {

        for (int startPos = 0; startPos < sequence.size()-1; startPos++) {
            int currentPos=startPos+1;
            int count=1;
            String symbol=sequence.get(startPos);

            while (symbol.equals(sequence.get(currentPos))){
                count++;
                if (count>=SEQUENCE_COUNT){
                    SEQUENCE_COUNT=count;
                    SEQUENCE_SYMBOL=symbol;
                }
                currentPos++;
                if (currentPos>=sequence.size()){
                    break;
                }
            }
        }
        sequence.clear();
    }
}
