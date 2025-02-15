package hashing;

import java.util.HashMap;
import java.util.Map;

class TotalNums {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1};
        int m = 0;

        System.out.println(countSubarrays(nums, m));
    }

    private static int countSubarrays(int[] nums, int m) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        int count = 0, prefixSum = 0;

        for (int num : nums) {
            prefixSum += num; // 현재까지의 합


            count += prefixSumCount.getOrDefault(prefixSum - m, 0);


            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
