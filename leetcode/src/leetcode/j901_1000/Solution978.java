package leetcode.j901_1000;

import java.util.Map;

class Solution978 {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        int flag = arr[0] > arr[1] ? 0 : arr[0] < arr[1] ? 1 : -1;
        int res = flag >= 0 ? 2 : 1, max = flag >= 0 ? 2 : 1;

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                if (flag == 0 || flag == -1) {
                    flag = 1;
                    res++;
                } else {
                    max = Math.max(res, max);
                    res = 2;
                }
            } else if (arr[i] > arr[i + 1]) {
                if (flag == 1 || flag == -1) {
                    flag = 0;
                    res++;
                } else {
                    max = Math.max(res, max);
                    res = 2;
                }
            } else {
                max = Math.max(res, max);
                if (i < arr.length - 2) {
                    i++;
                    flag = arr[i] > arr[i + 1] ? 0 : arr[i] < arr[i + 1] ? 1 : -1;
                    res = flag >= 0 ? 2 : 1;
                }
            }
        }
        return Math.max(max, res);
    }

    public int maxTurbulenceSize1(int[] arr) {
        int length = arr.length;
        int left = 0, right = 0, res = 0;
        while (right < length - 1) {
            if (right == left) {
                right++;
                if (arr[left] == arr[right]) {
                    left++;
                }
            } else {
                boolean condition1 = arr[right] > arr[right - 1] && arr[right] > arr[right + 1];
                boolean condition2 = arr[right] < arr[right - 1] && arr[right] < arr[right + 1];
                if (condition1 || condition2) {
                    right++;
                } else {
                    left = right;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
//        int size = new Solution978().maxTurbulenceSize(new int[]{9, 9, 9, 9, 1, 8});
//        int size = new Solution978().maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9});
//        int size = new Solution978().maxTurbulenceSize(new int[]{4,8,12,16});
//        int size = new Solution978().maxTurbulenceSize(new int[]{0, 1, 1, 0, 1, 0, 1, 1, 0, 0});
//        int size = new Solution978().maxTurbulenceSize(new int[]{422, 204, 396, 362, 440, 114, 350, 283, 449, 72, 397, 380, 277, 334, 433, 93, 343, 24, 374, 255, 244, 158, 482, 28, 358, 467, 223, 403, 264, 291, 350, 256, 47, 117, 476, 230, 93, 122, 140, 169});
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                if ((i & 1) == 1) {
                    System.out.println(i);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                if ((i & 1) == 0) {
                    System.out.println(i);
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}