import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
            int res = 0;
	        //자기랑 오른쪽꺼 비교해서 자기가 크면 오른쪽 idx랑 비교한다.
	        
	        //비교 후 역시 자기가 크면 자기 idx로 놓고 작다면 오른쪽 dp의 idx값을 넣는다.
	        int dp[] = new int [prices.length];
	        dp[prices.length - 1] = prices.length - 1;
	        for (int i = prices.length - 2; i > -1; i--){
	            boolean flag = false;
	            if (prices[i] < prices[i + 1]){
	                dp[i] = dp[i + 1];
	                res = Math.max(res, prices[dp[i + 1]] - prices[i]);
	            }else{
	                //자신 보다 높은 가격을 찾아가는데 만약 length - 1에 닿으면 flag를 true로 바꿔준다.
	                int tempIdx = i + 1;
	                int prevIdx = -1;
	                while (!flag && prices[i] >= prices[tempIdx]){
	                    if (tempIdx == prevIdx) flag = true;
	                    prevIdx = tempIdx;
	                    tempIdx = dp[tempIdx];
	                }
	                if (flag && prices[i] > prices[tempIdx]){
	                    dp[i] = i;
	                }else if (flag && prices[i] <= prices[tempIdx]){
	                    dp[i] = tempIdx;
	                }else if (!flag){
	                    dp[i] = tempIdx;
	                }
	                res = Math.max(res, prices[dp[i]] - prices[i]);
	            }
	        }
	        return res;
    }
}