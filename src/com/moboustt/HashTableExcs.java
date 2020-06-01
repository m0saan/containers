package com.moboustt;

import java.util.*;

public class HashTableExcs {
    public int mostFrequent(int[] input) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        int mostFrequent = 0;
        for (int key : input)
            dict.put(key, dict.getOrDefault(key, 0) + 1);
        for (int item : input) {
            if (dict.get(item) > mostFrequent)
                mostFrequent = item;
        }
        return mostFrequent;
    }

    public int countPairsWithDiff(int[] nums, int k) {
        if (k < 0 || nums.length == 0) return 0;
        int count = 0;
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int i : nums)
            dict.put(i, dict.getOrDefault(i, 0) + 1);
        for (int key : dict.keySet()) {
            if (k == 0) {
                if (dict.get(key) >= 2)
                    count++;
            } else {
                if (dict.containsKey(key + k))
                    count++;
            }
        }
        return count;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            var comp = target - nums[i];
            if (dict.containsKey(comp))
                return new int[] {dict.get(comp), i};
            dict.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int romanToInt(String s) {
        Map<Character, Integer> romanNumerals = Map.of(
                'I',1,
                'V', 5,
                'X', 10,
                'L',50,
                'C',100,
                'D',500,
                'M',1000
        );
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1 ; i++) {
            var current = romanNumerals.get(chars[i]);
            if (current < romanNumerals.get(chars[i + 1])) res -= current;
            else res += current;
        }
        return res;
    }
}

/*
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < nums.length ; j++) {
                var diff = Math.abs(nums[i] - nums[j]);
                if (i != j && diff == k
                        && dict.getOrDefault(nums[i], -1000) != nums[j]
                        && dict.getOrDefault(nums[j], -1000) != nums[i]) {
                    if (dict.containsKey(nums[i]))
                        dict.put(nums[j], nums[i]);
                    else dict.put(nums[i], nums[j]);
                }
            }
        }
        return dict.size();
    }
 */