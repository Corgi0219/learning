package leetcode;//给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
//
// 示例 1: 
//
// 输入: "aacecaaa"
//输出: "aaacecaaa"
// 
//
// 示例 2: 
//
// 输入: "abcd"
//输出: "dcbabcd" 
// Related Topics 字符串 
// 👍 212 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution214 {
    public static void main(String[] args) {
        System.out.println(new Solution214().shortestPalindrome("abbacd"));
    }

    public String shortestPalindrome(String s) {
        if (isPalindrome(s)) return s;
        String pre = "";
        for (int length = s.length() - 1; length >= 0; length--) {
            boolean ok = isPalindrome(s.substring(0, length));
            if (ok) {
                pre = new StringBuffer(s.substring(length)).reverse().toString();
                break;
            }
        }
        return pre + s;
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}

class Solution214_1 {
    public static void main(String[] args) {
        System.out.println(new Solution214_1().shortestPalindrome("abbacd"));
    }

    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (j >= 0) {
            if (s.charAt(i) == s.charAt(j)) i++;
            j--;
        }
        if (i == s.length()) return s;
        String suffix = s.substring(i);
        String pre = new StringBuilder(suffix).reverse().toString();
        return pre + shortestPalindrome(s.substring(0, i)) + suffix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
