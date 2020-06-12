package codes.june_challenge.day9

class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.count() > t.count()) return false;
        var i = 0
        for (c in t) {
            if (i < s.count() && s[i] == c) i++;
        }
        return i == t.count()
    }
}