package leetcode.h800;

import java.util.*;

class Solution721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> email2Name = new HashMap<>(20);
        Map<String, Integer> email2Index = new HashMap<>(20);

        int emailIdx = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!email2Index.containsKey(email)) {
                    email2Index.put(email, emailIdx++);
                    email2Name.put(email, name);
                }
            }
        }

        UnionFind unionFind = new UnionFind(email2Index.size());
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            Integer firstIndex = email2Index.get(firstEmail);
            for (int i = 2; i < account.size(); i++) {
                String otherEmail = account.get(i);
                Integer otherIndex = email2Index.get(otherEmail);
                unionFind.union(firstIndex, otherIndex);
            }
        }

        Map<Integer, List<String>> indexEmails = new HashMap<>(20);
        for (String email : email2Index.keySet()) {
            Integer index = email2Index.get(email);
            int parentIndex = unionFind.find(index);
            List<String> emails = indexEmails.getOrDefault(parentIndex, new ArrayList<>());
            emails.add(email);
            indexEmails.put(parentIndex, emails);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> value : indexEmails.values()) {
            Collections.sort(value);
            String name = email2Name.get(value.get(0));
            List<String> list = new ArrayList<>();
            list.add(name);
            list.addAll(value);
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] arr1 = {"John", "johnsmith@mail.com", "john_newyork@mail.com"};
        String[] arr2 = {"John", "johnsmith@mail.com", "john00@mail.com"};
        String[] arr3 = {"Mary", "mary@mail.com"};
        String[] arr4 = {"John", "johnnybravo@mail.com"};
        new Solution721().accountsMerge(Arrays.asList(Arrays.asList(arr1), Arrays.asList(arr2), Arrays.asList(arr3), Arrays.asList(arr4)));
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index1)] = find(index2);
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}