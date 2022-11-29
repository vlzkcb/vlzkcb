import java.util.*;
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int []res = new int[2001];
        boolean []doubArr = new boolean [1001];
        for (int num : arr){
            res[num + 1000]++;           
        }
        for (int num: res){
            if (num == 0) continue;
            if (doubArr[num]) return false;
            else doubArr[num] = true;
        }
        return true;
    }
}