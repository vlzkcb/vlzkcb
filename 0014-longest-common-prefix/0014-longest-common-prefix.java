import java.util.*;
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        boolean flag = false;
        char c = 0;
        while (true){
            if (strs[0].length() == 0) break;
            if (idx < strs[0].length())c = strs[0].charAt(idx);
            else break;
            for(int i = 1; i < strs.length; i++){
                if (idx < strs[i].length() && strs[i].charAt(idx) != c){
                    flag = true;
                }else if (idx == strs[i].length()){
                    flag = true;
                    break;
                }
            }
            if (flag) break;
            sb.append(c);
            idx++;
        }
        return sb.toString();
    }
}