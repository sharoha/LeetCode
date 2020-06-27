package codes.contest.weekly194;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;
import library.util.PairUtil.IntIntPair;

import java.util.*;

public class BWeekly194 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.i();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.next();
        }
        out.printLine(getFolderNames(a));
    }

    // basically cheated after the contest, looked at the solution after the contest...
    // It really was a frustrating day, didn't sleep at all last night with all the bad mouthing and all
    // Not sure whether i would have solved this problem in fresh mind, but at least it is possible that
    // because of bed mood nothing new came to the mind
    // The problem is not difficult, only that it is very tricky.... only after looking at the solution
    // i am able to conclude this. So, let's try to solve problem c and see where i stand today... although
    // i am totally frustrated and don't want to do anything today, maybe i will just watch anime a lot today
    // or do something else... though at least solve C and then will spend whole time doing something non productive
    // ..........:(
    // maybe i want to play a game today
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] answer = new String[names.length];
        for (int j = 0; j < names.length; j++) {
            if (!map.containsKey(names[j])) { // if new string seen, at it with frequency 1
                answer[j] = names[j];
                map.put(names[j], 1);
            } else {
                int count = map.get(names[j]); // get the count of the string already present
                String temp = getAns(names[j], count); // make a temp string
                while (map.containsKey(temp)) { // why this is not n^2
                    count++;
                    temp = getAns(names[j], count);
                }
                map.put(temp, 1);
                map.put(names[j], count);
                answer[j] = temp;
            }
        }
        return answer;
    }

    private String getAns(String u, Integer integer) {
        return u + "(" + integer + ")";
    }
}
