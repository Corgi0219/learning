package leetcode.g601_700;

class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        int[][] letters = new int[26][2];
        for (char task : tasks) {
            letters[task - 'A'][0] = 1;
            letters[task - 'A'][1]++;
        }

        int time = 1, maxNum, minTime;
        char maxNumChar = 'A', minTimeChar = 'A';
        boolean quit, skip;
        while (true) {
            quit = skip = true;
            minTime = Integer.MAX_VALUE;
            maxNum = Integer.MIN_VALUE;
            for (int i = 0; i < letters.length; i++) {
                int[] letter = letters[i];
                if (letter[1] > 0) {
                    quit = false;
                    if (letter[0] < minTime) {
                        minTimeChar = (char) ('A' + i);
                        minTime = letter[0];
                    }
                    if (letter[0] <= time && letter[1] > maxNum) {
                        maxNumChar = (char) ('A' + i);
                        maxNum = letter[1];
                        skip = false;
                    }
                }
            }
            if (quit) {
                time--;
                break;
            }

            if (skip && minTime != Integer.MAX_VALUE) {
                time = minTime;
                letters[minTimeChar - 'A'][0] = time + n + 1;
                letters[minTimeChar - 'A'][1]--;
                time++;
            }
            if (!skip) {
                letters[maxNumChar - 'A'][0] = time + n + 1;
                letters[maxNumChar - 'A'][1]--;
                time++;
            }
        }
        return time;
    }

    public static void main(String[] args) {
//        int i = new Solution621().leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2);
        int i = new Solution621().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0);
        return;
    }
}