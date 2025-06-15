import java.util.*;

public class SpecialTriplets {
    public int countSpecialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        int n = nums.length;
        Map<Integer, Integer> rightCount = new HashMap<>();
        Map<Integer, Integer> leftCount = new HashMap<>();

        // Count frequency of all numbers initially in right map
        for (int num : nums) {
            rightCount.put(num, rightCount.getOrDefault(num, 0) + 1);
        }

        long result = 0;

        // Iterate through each element as j
        for (int j = 0; j < n; j++) {
            int numJ = nums[j];
            int target = numJ * 2;

            // Reduce the current number from rightCount as it is now 'j'
            rightCount.put(numJ, rightCount.get(numJ) - 1);
            if (rightCount.get(numJ) == 0) {
                rightCount.remove(numJ);
            }

            int countLeft = leftCount.getOrDefault(target, 0);
            int countRight = rightCount.getOrDefault(target, 0);

            result = (result + ((long) countLeft * countRight) % MOD) % MOD;

            // Add current number to leftCount for future iterations
            leftCount.put(numJ, leftCount.getOrDefault(numJ, 0) + 1);
        }

        return (int) result;
    }

}
