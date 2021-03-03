package leetcode.e401_500;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap heap = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            heap.insert(nums[i]);
        }
        double[] res = new double[nums.length - k + 1];
        res[0] = heap.getMedia();
        for (int i = k; i < nums.length; i++) {
            heap.insert(nums[i]);
            heap.remove(nums[i - k]);
            res[i - k + 1] = heap.getMedia();
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution480().medianSlidingWindow(new int[]{-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648},3);
    }
}

class DualHeap {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    private Map<Integer, Integer> delayMap;
    private int k, minSize, maxSize;

    public DualHeap(int k) {
        // maxHeap = new PriorityQueue<>(Comparator.comparingInt(i -> i));
        // minHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
        this.minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        this.maxHeap = new PriorityQueue<>(Integer::compareTo);
        delayMap = new HashMap<>();
        this.k = k;
        this.minSize = this.maxSize = 0;
    }

    public double getMedia() {
        return (this.k & 1) == 1 ? this.minHeap.peek() : (((double) minHeap.peek() + maxHeap.peek()) / 2);
    }

    public void insert(int num) {
        if (minHeap.isEmpty() || num <= minHeap.peek()) {
            minHeap.offer(num);
            minSize++;
        } else {
            maxHeap.offer(num);
            maxSize++;
        }
        makeBalance();
    }

    public void remove(int num) {
        delayMap.put(num, delayMap.getOrDefault(num, 0) + 1);
        if (num <= minHeap.peek()) {
            minSize--;
            if (num == minHeap.peek()) {
                realRemove(minHeap);
            }
        } else {
            maxSize--;
            if (num == maxHeap.peek()) {
                realRemove(maxHeap);
            }
        }
        makeBalance();
    }

    private void realRemove(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            Integer num = heap.peek();
            if (delayMap.containsKey(num)) {
                delayMap.put(num, delayMap.get(num) - 1);
                if (delayMap.get(num) == 0) {
                    delayMap.remove(num);
                }
                heap.poll();
            } else {
                break;
            }
        }
    }

    private void makeBalance() {
        if (minSize > maxSize + 1) {
            maxHeap.offer(minHeap.poll());
            maxSize++;
            minSize--;
            realRemove(minHeap);
        } else if (maxSize > minSize) {
            minHeap.offer(maxHeap.poll());
            maxSize--;
            minSize++;
            realRemove(maxHeap);
        }
    }
}