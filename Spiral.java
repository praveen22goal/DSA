/*Spiral Order Matrix II*/
public class Spiral {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Initialize A x A matrix with zeros
        for (int i = 0; i < A; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < A; j++) {
                row.add(0);
            }
            result.add(row);
        }

        int top = 0;
        int bottom = A - 1;
        int left = 0;
        int right = A - 1;

        int num = 1;

        while (top <= bottom && left <= right) {

            // 1. Move Left to Right
            for (int j = left; j <= right; j++) {
                result.get(top).set(j, num++);
            }
            top++;

            // 2. Move Top to Bottom
            for (int i = top; i <= bottom; i++) {
                result.get(i).set(right, num++);
            }
            right--;

            // 3. Move Right to Left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.get(bottom).set(j, num++);
                }
                bottom--;
            }

            // 4. Move Bottom to Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.get(i).set(left, num++);
                }
                left++;
            }
        }

        return result;
    }
}
