class Solution {
    static boolean isSubsequence(String s, String t, int tIdx, int sIdx){
        if (sIdx == s.length() ){
            return true;
        }else if (tIdx == t.length()){
            // System.out.println(sIdx);
            if (sIdx != s.length()) {
                return false;
            }
            if (t.charAt(tIdx - 1) == s.charAt(sIdx - 1))return true;
            return false;
        }
        for (int i = tIdx, end = t.length(); i < end; i++){
            if (s.charAt(sIdx) == t.charAt(i)) {
                // System.out.println(i);
                return(isSubsequence(s,t, i + 1, ++sIdx));
            }
        }
        return false;
    }
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        return(isSubsequence(s,t,0,0));
    }
}