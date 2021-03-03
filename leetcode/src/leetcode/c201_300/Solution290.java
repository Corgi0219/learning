package leetcode.c201_300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] strings = s.split(" ");
        if (chars.length != strings.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            String absent = map.putIfAbsent(chars[i], strings[i]);
            if (absent != null && !absent.equals(strings[i])) {
                return false;
            }
        }

        return new HashSet<>(map.values()).size() == map.size();
    }
}