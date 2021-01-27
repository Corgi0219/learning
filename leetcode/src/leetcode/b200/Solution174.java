package leetcode.b200;//
//
// 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿
//过地下城并通过对抗恶魔来拯救公主。 
//
// 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。 
//
// 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么
//包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。 
//
// 为了尽快到达公主，骑士决定每次只向右或向下移动一步。 
//
// 
//
// 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。 
//
// 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。 
//
// 
// 
// -2 (K) 
// -3 
// 3 
// 
// 
// -5 
// -10 
// 1 
// 
// 
// 10 
// 30 
// -5 (P) 
// 
// 
//
//
// 
//
// 说明: 
//
// 
// 
// 骑士的健康点数没有上限。 
// 
// 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。 
// Related Topics 二分查找 动态规划 
// 👍 274 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution174 {
    /**
     * 暴力回溯 提交后超时
     * 思路：每到一个格子，都有两种选择，要么向右，要么向下，这样自然而然就会形成一棵递归树，我们只需要考虑每个格子需要耗费的最小血量。
     * 每个格子的最小耗血量应该是右方格子和下方格子最小耗血量中的较小值，注意，这里的每个格子的最小耗血量不单单指的是本格耗血量，而是在
     * 不断向下递归后，自底向上计算出来的累计最小耗血量，退出递归的条件是到达公主所在地，也就是最后一个格子
     * 递归公式 ：当前格子的最小耗血量 = min(右方格子最小耗血量,下方格子最小耗血量) - 当前格子的耗血量
     * 上面的公式可能会得出负值，因为可能之前的耗血量还没有当前的格子加血多，这样的话当前格子的最小耗血量即为0
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int row = dungeon.length, col = dungeon[0].length;
        return helper(0, 0, row, col, dungeon) + 1;
    }

    private int helper(int rowIdx, int colIdx, int row, int col, int[][] dungeon) {
        if (rowIdx >= row || colIdx >= col) {
            return Integer.MAX_VALUE;
        }
        if (rowIdx == row - 1 && colIdx == col - 1) {
            return dungeon[rowIdx][colIdx] < 0 ? -dungeon[rowIdx][colIdx] : 0;
        }
        int rowVal = helper(rowIdx + 1, colIdx, row, col, dungeon);
        int colVal = helper(rowIdx, colIdx + 1, row, col, dungeon);
        int need = Math.min(rowVal, colVal) - dungeon[rowIdx][colIdx];
        return Math.max(need, 0);
    }

    public static void main(String[] args) {
        int[][] ints = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int hp = new Solution174().calculateMinimumHP(ints);
        System.out.println(hp);
    }
}

class Solution174_1 {
    /**
     * 暴力回溯 提交后超时
     * 思路：每到一个格子，都有两种选择，要么向右，要么向下，这样自然而然就会形成一棵递归树，我们只需要考虑每个格子需要耗费的最小血量。
     * 每个格子的最小耗血量应该是右方格子和下方格子最小耗血量中的较小值，注意，这里的每个格子的最小耗血量不单单指的是本格耗血量，而是在
     * 不断向下递归后，自底向上计算出来的累计最小耗血量，退出递归的条件是到达公主所在地，也就是最后一个格子
     * 递归公式 ：当前格子的最小耗血量 = min(右方格子最小耗血量,下方格子最小耗血量) - 当前格子的耗血量
     * 上面的公式可能会得出负值，因为可能之前的耗血量还没有当前的格子加血多，这样的话当前格子的最小耗血量即为0
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int[][] mem = new int[dungeon.length][dungeon[0].length];
        for (int[] ints : mem) Arrays.fill(ints, -1);
        return helper(0, 0, mem, dungeon) + 1;
    }

    private int helper(int rowIdx, int colIdx, int[][] mem, int[][] dungeon) {
        if (rowIdx >= mem.length || colIdx >= mem[0].length) {
            return Integer.MAX_VALUE;
        }
        if (mem[rowIdx][colIdx] != -1) {
            return mem[rowIdx][colIdx];
        }
        if (rowIdx == mem.length - 1 && colIdx == mem[0].length - 1) {
            return dungeon[rowIdx][colIdx] < 0 ? -dungeon[rowIdx][colIdx] : 0;
        }
        int rowVal = helper(rowIdx + 1, colIdx, mem, dungeon);
        int colVal = helper(rowIdx, colIdx + 1, mem, dungeon);
        int need = Math.min(rowVal, colVal) - dungeon[rowIdx][colIdx];
        mem[rowIdx][colIdx] = Math.max(need, 0);
        return mem[rowIdx][colIdx];
    }

    public static void main(String[] args) {
        int[][] ints = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int hp = new Solution174_1().calculateMinimumHP(ints);
        System.out.println(hp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
