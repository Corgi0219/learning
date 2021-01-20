package leetcode;

class Solution925 {
    public boolean isLongPressedName(String name, String typed) {
        char[] names = name.toCharArray();
        char[] typeds = typed.toCharArray();

        int i = 0, k = 0;
        while (k < typeds.length && i < names.length) {
            if (typeds[k] == names[i]) {
                k++;
                i++;
                while (i == names.length && k < typeds.length && typeds[k] == names[i - 1]) {
                    k++;
                }
            } else {
                if (i == 0 || typeds[k] != names[i - 1]) {
                    break;
                }
                k++;
            }
        }
        return i == names.length && k == typeds.length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution925().isLongPressedName("zlexya"
                , "aazlllllllllllllleexxxxxxxxxxxxxxxya"));
    }
}