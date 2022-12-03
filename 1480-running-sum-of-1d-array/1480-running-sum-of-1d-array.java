class Solution {
    public int[] runningSum(int[] nums) {
        int dp[] = new int[nums.length];
        int idx = 0;
        dp[0] = nums[0];
        for (int num : nums){
            if (idx == 0) {
                idx++;
                continue;
            }
            dp[idx] = dp[idx - 1] + num;
            idx++;
        }
        return dp;
    }
}