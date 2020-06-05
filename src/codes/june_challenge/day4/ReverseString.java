package codes.june_challenge.day4;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

public class ReverseString {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    public void reverseString(char[] str) {
        for (int i = 0, j = str.length - 1; i <= j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}
