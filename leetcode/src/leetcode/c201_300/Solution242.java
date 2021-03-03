package leetcode.c201_300;

import java.util.Arrays;
import java.util.HashMap;
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表

class Solution242 {
    /**
     * 暴力法
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        if (chars.length != chars1.length) return false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars1[i]) return false;
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>(s.length() + 2);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) map.put(chars[i], map.get(chars[i]) + 1);
            else map.put(chars[i], 1);

        }
        char[] chars1 = t.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (!map.containsKey(chars1[i])) return false;
            Integer value = map.get(chars1[i]);
            if (value == 1) map.remove(chars1[i]);
            else if (value > 1) map.put(chars1[i], value - 1);
        }
        return map.size() == 0;
    }

    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }
        for (int i : chars) if (i != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram3("bnagram", "nagaram"));
    }
}