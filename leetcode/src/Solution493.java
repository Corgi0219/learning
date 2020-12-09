class Solution493 {

    public int reversePairs(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private int dfs(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = (left + right) / 2;
        int leftRes = dfs(nums, left, mid);
        int rightRes = dfs(nums, mid + 1, right);

        return leftRes + rightRes + sort(nums, left, mid, right);
    }

    private int sort(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int k = mid + 1;
        int tempIdx = 0;
        int res = 0;

        while (i <= mid && k <= right) {
            if (nums[i] > (long) nums[k] * 2) {
                res += mid + 1 - i;
                k++;
            } else {
                i++;
            }
        }

        i = left;
        k = mid + 1;

        while (i <= mid && k <= right) {
            if (nums[i] < nums[k]) {
                temp[tempIdx++] = nums[i++];
            } else {
                temp[tempIdx++] = nums[k++];
            }
        }

        while (i <= mid) {
            temp[tempIdx++] = nums[i++];
        }

        while (k <= right) {
            temp[tempIdx++] = nums[k++];
        }

        for (int j = 0; j < tempIdx; j++) {
            nums[left + j] = temp[j];
        }
        return res;
    }

    public static void main(String[] args) {
        int i = new Solution493().reversePairs(new int[]{1, 3, 2, 3, 1});
        return;
    }
}