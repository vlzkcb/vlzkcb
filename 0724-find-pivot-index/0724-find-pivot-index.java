class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int dp[] = new int[nums.length];
        int idx = 0;
        for (int num : nums){
            sum += num;
            dp[idx++] = sum;
        }
        int i;
        for (i = 0; i < nums.length; i++){
            if ((dp[i] - nums[i]) * 2 == sum - nums[i]) return i;
        }
        return -1;
    }
}