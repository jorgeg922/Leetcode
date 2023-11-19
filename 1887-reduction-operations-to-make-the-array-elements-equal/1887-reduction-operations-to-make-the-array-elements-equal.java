import java.util.Arrays;

class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);

        int operations = 0;
        int currentMax = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < currentMax) {
                currentMax = nums[i];
                operations += nums.length - 1 - i;
            }
        }

        return operations;
    }
}
