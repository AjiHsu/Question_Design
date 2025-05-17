package insert_empty_cell;

public class Solution {
    public int[] insertEmptyCell(int[] arr,
                                 String[] operations,
                                 int[][] numbers) {
        int[] res = new int[operations.length];
        BIT bit = new BIT(arr.length + 1);
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("insert")) {
                // bs to search the index
                int originalIndex = 0;
                for (int jump = arr.length; jump > 0; jump /= 2) {
                    while (originalIndex + jump < arr.length &&
                            originalIndex + jump + bit.query(originalIndex + jump) <= numbers[i][0]) {
                        originalIndex += jump;
                    }
                }

                // upper bound
                if (originalIndex + bit.query(originalIndex) != numbers[i][0])
                    originalIndex++;

                bit.update(originalIndex, numbers[i][1]);
                res[i] = -1;
            } else { // operations[i].equals("query")
                // bs to search the index
                int originalIndex = 0;
                for (int jump = arr.length; jump > 0; jump /= 2) {
                    while (originalIndex + jump < arr.length &&
                            originalIndex + jump + bit.query(originalIndex + jump) <= numbers[i][0]) {
                        originalIndex += jump;
                    }
                }

                if (originalIndex + bit.query(originalIndex) != numbers[i][0])
                    res[i] = -1;
                else
                    res[i] = arr[originalIndex];
            }
        }
        return res;
    }
}

class BIT {
    private final int[] arr;

    BIT(int n) {
        arr = new int[n + 1];
    }

    public void update(int i, int delta) {
        i++;
        while (i < arr.length) {
            arr[i] += delta;
            i += i & -i;
        }
    }

    public int query(int i) {
        i++;
        int total = 0;
        while (i > 0) {
            total += arr[i];
            i -= i & -i;
        }
        return total;
    }
}