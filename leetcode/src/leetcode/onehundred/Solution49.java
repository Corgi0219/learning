package leetcode.onehundred;//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution49 {
    /**
     * 利用排序的字符串当key，然后把每个字符串排好序在字典中找，找得到+1，找不到直接新建数组
     * 时间复杂度：遍历数组O(n) 排序时间O(klogk),k是字符串的最大长度，n是字符串数组的长度，整个的时间
     * 复杂度为O(nklogk)
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>(strs.length + 2);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        int[] count = new int[26];
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(count, 0);
            char[] chars = strs[i].toCharArray();
            for (int k = 0; k < chars.length; k++) {
                count[chars[k] - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int k = 0; k < 26; k++) {
                builder.append("#").append(count[k]);
            }
            if (!map.containsKey(builder.toString())) map.put(builder.toString(), new ArrayList<>());
            map.get(builder.toString()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 牛b 数学带师
     * <p>
     * 算术基本定理，又称为正整数的唯一分解定理，即：每个大于1的自然数，要么本身就是质数，要么可以写为2个以上的质数的积，而且这些质因子按大小排列
     * 之后，写法仅有一种方式。利用这个，我们把每个字符串都映射到一个正数上。
     * 用一个数组存储质数 prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
     * 89, 97, 101, 103}。
     * 然后每个字符串的字符减去 ' a ' ，然后取到 prime 中对应的质数。把它们累乘。
     * 例如 abc ，就对应 'a' - 'a'， 'b' - 'a'， 'c' - 'a'，即 0, 1, 2，也就是对应素数 2 3 5，然后相乘 2 * 3 * 5 = 30，就把
     * "abc" 映射到了 30。
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams3(String[] strs) {
        HashMap<Integer, List<String>> hash = new HashMap<>();
        //每个字母对应一个质数
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        for (int i = 0; i < strs.length; i++) {
            int key = 1;
            //累乘得到 key
            for (int j = 0; j < strs[i].length(); j++) {
                key *= prime[strs[i].charAt(j) - 'a'];
            }
            if (hash.containsKey(key)) {
                hash.get(key).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                hash.put(key, temp);
            }

        }
        return new ArrayList<>(hash.values());
    }

    public static void main(String[] args) {
        groupAnagrams3(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
