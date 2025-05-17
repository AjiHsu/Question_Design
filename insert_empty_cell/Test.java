package insert_empty_cell;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        int index = 1;
        while (true) {
            BufferedReader bfr;
            try {
                bfr = new BufferedReader(new FileReader("src/insert_empty_cell/testcase/testcase" + index + "_input.txt"));
            } catch (FileNotFoundException e) {
                break;
            }

            String[] read;
            // arr
            read = bfr.readLine()
                    .trim()
                    .replace("[", "")
                    .replace("]", "")
                    .split(",");
            int[] arr = new int[read.length];
            for (int i = 0; i < read.length; i++) arr[i] = Integer.parseInt(read[i]);

            // operations
            String[] operations = bfr.readLine()
                    .trim()
                    .replace("[", "")
                    .replace("]", "")
                    .replace("\"", "")
                    .split(",");

            // numbers
            read = bfr.readLine()
                    .trim()
                    .replace("[", "")
                    .replace("]", "")
                    .split(",");

            int[][] numbers = new int[read.length][2];
            for (int i = 0; i < read.length; i += 2) {
                numbers[i / 2][0] = Integer.parseInt(read[i]);
                numbers[i / 2][1] = Integer.parseInt(read[i + 1]);
            }

            // output
            bfr.close();
            bfr = new BufferedReader(new FileReader("src/insert_empty_cell/testcase/testcase" + index + "_output.txt"));
            read = bfr.readLine()
                    .trim()
                    .replace("[", "")
                    .replace("]", "")
                    .split(",");
            int[] answer = new int[read.length];
            for (int i = 0; i < read.length; i++) {
                answer[i] = Integer.parseInt(read[i]);
            }

            Solution solution = new Solution();
            int[] yourAnswer = solution.insertEmptyCell(arr, operations, numbers);

            if (Arrays.equals(answer, yourAnswer)) System.out.println("testcase" + index + " passed");
            else {
                System.out.println("testcase" + index + " fail");
                System.out.println("your answer is:   " + Arrays.toString(yourAnswer));
                System.out.println("expect answer is: " + Arrays.toString(answer));
            }

            bfr.close();
            index++;
        }
    }
}
