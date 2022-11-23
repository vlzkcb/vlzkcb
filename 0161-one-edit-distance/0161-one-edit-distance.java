class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.compareTo(t) == 0) return false;
        int sLen = s.length();
        int tLen = t.length();
        boolean flag = false;
        if (sLen == tLen){
            for (int i = 0; i < sLen; i++){
                if (!flag && s.charAt(i) != t.charAt(i)){
                    flag = true;
                }else if(flag && s.charAt(i) != t.charAt(i)){
                    return false;
                }
            }
        }else if (sLen == tLen + 1){
            for (int i = 0, end = -1; i < tLen; i++){
                end++;
                if (!flag && s.charAt(end) != t.charAt(i)){
                    flag = true;
                    i--;
                }else if(flag && s.charAt(end) != t.charAt(i)){
                    return false;
                }
            }
        }else if (sLen == tLen - 1){
            for (int i = 0, end = -1; i < sLen; i++){
                end++;
                if (!flag && s.charAt(i) != t.charAt(end)){
                    flag = true;
                    i--;
                }else if(flag && s.charAt(i) != t.charAt(end)){
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }
}