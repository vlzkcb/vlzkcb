import java.util.*;
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, end = s.length(); i < end; i++){
            if (map.containsKey(sArr[i])) sb.append(map.get(sArr[i]));
            else {
                if (map.containsValue(tArr[i])) return false;
                map.put(sArr[i],tArr[i]);
                sb.append(tArr[i]);
            }
        }
        if (sb.toString().compareTo(t) == 0) return true;
        return false;
    }
}