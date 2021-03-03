package leetcode.a1_100;//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//
// 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。 
//
// 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法 
// 👍 345 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        StringBuilder ip = new StringBuilder();
        List<String> res = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            for (int k = 1; k < 4; k++) {
                for (int j = 1; j < 4; j++) {
                    for (int l = 1; l < 4; l++) {
                        if (i + k + j + l == s.length()) {
                            int a = Integer.parseInt(s.substring(0, i));
                            int b = Integer.parseInt(s.substring(i, i + k));
                            int c = Integer.parseInt(s.substring(i + k, i + k + j));
                            int d = Integer.parseInt(s.substring(i + k + j));
                            if (a <= 255 && b <= 255 && c <= 255 && d <= 255) {
                                ip.append(a).append(".")
                                        .append(b).append(".")
                                        .append(c).append(".")
                                        .append(d);
                                if (s.length() + 3 == ip.length()) res.add(ip.toString());
                                ip.delete(0, ip.length());
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution93().restoreIpAddresses("0000");
    }
}

class Solution93V1 {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return res;
        ArrayDeque<String> deque = new ArrayDeque<>();
        dfs(s, 0, 0, s.length(), deque, res);
        return res;
    }

    private void dfs(String s, int depth, int begin, int length, ArrayDeque<String> deque, ArrayList<String> res) {
        if (begin == length) {
            if (depth == 4) res.add(String.join(".", deque));
            return;
        }

        if (length - begin < 4 - depth || length - begin > 3 * (4 - depth)) return;

        for (int i = 1; i <= 3; i++) {
            if (begin + i > length) break;
            String s1 = s.substring(begin, begin + i);
            if (s1.length() > 1 && s1.startsWith("0")) continue;
            int number = Integer.parseInt(s1);
            if (number >= 0 && number <= 255) {
                deque.add(number + "");
                dfs(s, depth + 1, begin + i, length, deque, res);
                deque.pollLast();
            }
        }
    }

    public static void main(String[] args) {
        new Solution93V1().restoreIpAddresses("010010");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
