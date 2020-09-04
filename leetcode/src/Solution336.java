//给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。 
//
// 示例 1: 
//
// 输入: ["abcd","dcba","lls","s","sssll"]
//输出: [[0,1],[1,0],[3,2],[2,4]] 
//解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
// 
//
// 示例 2: 
//
// 输入: ["bat","tab","cat"]
//输出: [[0,1],[1,0]] 
//解释: 可拼接成的回文串为 ["battab","tabbat"] 
// Related Topics 字典树 哈希表 字符串 
// 👍 93 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int k = 0; k < words.length; k++) {
                if (i == k) continue;
                if (isPalindrome(words[i], words[k])) {
                    list.add(Arrays.asList(i, k));
                }
            }
        }
        return list;
    }

    private boolean isPalindrome(String str1, String str2) {
        StringBuilder s = new StringBuilder(str1 + str2);
        return s.toString().equals(s.reverse().toString());
    }

    public static void main(String[] args) {
        new Solution336().palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
    }
}

class Solution {
    class Node {
        int[] ch = new int[26];
        int flag;

        public Node() {
            flag = -1;
        }
    }

    List<Node> tree = new ArrayList<>();

    public List<List<Integer>> palindromePairs(String[] words) {
        tree.add(new Node());
        int n = words.length;
        for (int i = 0; i < n; i++) {
            insert(words[i], i);
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = words[i].length();
            for (int j = 0; j <= m; j++) {
                if (isPalindrome(words[i], j, m - 1)) {
                    int leftId = findWord(words[i], 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
                    int rightId = findWord(words[i], j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    public void insert(String s, int id) {
        int len = s.length(), add = 0;
        for (int i = 0; i < len; i++) {
            int x = s.charAt(i) - 'a';
            if (tree.get(add).ch[x] == 0) {
                tree.add(new Node());
                tree.get(add).ch[x] = tree.size() - 1;
            }
            add = tree.get(add).ch[x];
        }
        tree.get(add).flag = id;
    }

    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    public int findWord(String s, int left, int right) {
        int add = 0;
        for (int i = right; i >= left; i--) {
            int x = s.charAt(i) - 'a';
            if (tree.get(add).ch[x] == 0) {
                return -1;
            }
            add = tree.get(add).ch[x];
        }
        return tree.get(add).flag;
    }

    public static void main(String[] args) {
//        new Solution696().countBinarySubstrings(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
