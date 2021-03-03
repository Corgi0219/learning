package leetcode.a1_100;//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution42 {
    /**
     * 暴力法
     * 首先找出所有元素中最高的那个，然后遍历数组，按照层数，1,2,3,4...这样一直找到最高层，只要当前元素比层数小
     * 就先向左遍历找是否有>=当前层数的，如果有，则再向右遍历，如果有>=当前层数的，总和+1，一直到最高层，然后返回sum
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height.length < 3) return 0;
        int maxHeight = getMax(height);
        int sum = 0;
        boolean left = false, right = false;
        for (int i = 1; i <= maxHeight; i++) {
            for (int k = 0; k < height.length; k++) {
                if (height[k] < i) {
                    for (int j = k - 1; j >= 0; j--) {
                        if (i <= height[j]) {
                            left = true;
                            break;
                        }
                    }
                    if (left) {
                        for (int j = k + 1; j < height.length; j++) {
                            if (i <= height[j]) {
                                right = true;
                                break;
                            }
                        }
                        if (right) {
                            sum += 1;
                        }
                        left = right = false;
                    }
                }
            }
        }
        return sum;
    }

    private static int getMax(int[] height) {
        int max = 0;
        for (int i : height) {
            if (i > max) max = i;
        }
        return max;
    }

    /**
     * 优化后的暴力法
     * 原理是循环每一列，找到这个列左边和右边最高的两个柱子，然后根据木桶理论我们要取小的那个
     * 然后用比较小的柱子减去当前的柱子，得到的就是当前柱子可以存的水量
     * 时间复杂度O(n^2)
     *
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        if (height.length < 3) return 0;
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = height[i], maxRight = height[i];
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(height[j], maxLeft);
            }
            for (int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(height[j], maxRight);
            }
            sum += Math.min(maxLeft, maxRight) - height[i];
        }
        return sum;
    }

    /**
     * 优化暴力法
     * 原理：
     * 首先使用两个数组来存储每个元素左侧和右侧的最大值数组，然后遍历整个数组，直接取出对应的左侧和右侧
     * 相对较小的那个值，减去当前元素加在sum上
     * 时间复杂度：O(n)
     *
     * @param height
     * @return
     */
    public static int trap3(int[] height) {
        if (height.length < 3) return 0;
        int sum = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
        }
        for (int i = 1; i < height.length; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }

    /**
     * 优化上面的方法
     * 原理；
     * 双指针，左侧指针设为1，右侧指针设为数组长度-2，然后遍历整个数组，每次取元素的左邻居和右指针的右邻居进行比较：
     * 如果左邻居小于右邻居，则比较左邻居和左侧最大值，如果大于左侧最大值，
     * 则更新左侧最大值，然后判断左侧最大值是否大于当前元素，如果大于，则取差值加在sum上，小于则忽略，
     * 然后左侧指针+1。
     * 如果左邻居大于右邻居，则比较右邻居和右侧最大值，如果大于右侧最大值，
     * 则更新右侧最大值，然后判断右侧最大值是否大于当前元素，如果大于，则取差值加在sum上，小于则忽略，
     * 然后右侧指针-1。
     * 这样只需要遍历一次数组即可，本质上还是找左右最大值，取较小者与当前元素做对比。
     *
     * @param height
     * @return
     */
    public static int trap4(int[] height) {
        if (height.length < 3) return 0;
        int sum = 0, maxLeft = 0, maxRight = 0, left = 1, right = height.length - 2;
        for (int i = 1; i < height.length; i++) {
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(maxLeft, height[left - 1]);
                if (maxLeft > height[left]) {
                    sum += maxLeft - height[left];
                }
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right + 1]);
                if (maxRight > height[right]) {
                    sum += maxRight - height[right];
                }
                right--;
            }
        }
        return sum;
    }

    /**
     * 栈
     * 原理我总结的不是很清晰，可能还得回头看
     * 总结：栈的内部维持的是一个递减的单调栈，栈顶元素是最小的，遍历数组，每次拿当前元
     * 素与栈顶元素比较，如果大于栈顶元素，记录下栈顶的高度并出栈，然后获取新的栈顶，这
     * 个栈顶肯定比刚刚的栈顶大，所以和当前元素可以形成凹槽，比较当前元素和新栈顶元素大
     * 小，取两者较小值减去刚刚记录的旧栈顶元素，这样我们可以计算出由新栈顶元素和旧
     * 栈顶元素的差值形成的条状凹槽存了多少水，累加到sum上，然后这样依次类推，直到遍历
     * 完成。
     *
     * @param height
     * @return
     */
    public static int trap5(int[] height) {
        if (height.length < 3) return 0;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int topHeight = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int min = Math.min(height[i], height[stack.peek()]);
                int dis = i - stack.peek() - 1;
                sum += dis * (min - topHeight);
            }
            stack.push(i);
        }
        return sum;
    }


    public static void main(String[] args) {
//        System.out.println(trap5(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap5(new int[]{4, 3, 2, 1, 1, 1, 1, 4}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
