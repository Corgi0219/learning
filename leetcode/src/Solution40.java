import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> re = new ArrayList<>();
        if (candidates.length == 0) {
            return re;
        }
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList<>(), re);
        return re;
    }

    public void dfs(int index, int[] candidates, int target, List<Integer> list, List<List<Integer>> re) {
        if (target == 0) {
            re.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int item = candidates[i];
            if (item <= target) {
                list.add(item);
                dfs(i + 1, candidates, target - item, list, re);
                list.remove(list.size() - 1);
                i++;
                while (i < candidates.length && item == candidates[i]) i++;
                i--;
            }
        }
    }
}