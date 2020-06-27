package codes.contest.biweekly28;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

public class B {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    static class SubrectangleQueries {
        private final int[][] matrix;
        public SubrectangleQueries(int[][] rectangle) {
            matrix = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    matrix[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return matrix[row][col];
        }
    }
}
