import java.util.*;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count occurrences of each remainder
        for (int num : nums) {
            int rem = ((num % value) + value) % value;
            freq.put(rem, freq.getOrDefault(rem, 0) + 1);
        }

        int mex = 0;
        while (true) {
            int rem = mex % value;
            if (!freq.containsKey(rem) || freq.get(rem) == 0) {
                return mex;
            }
            freq.put(rem, freq.get(rem) - 1);
            mex++;
        }
    }
}
