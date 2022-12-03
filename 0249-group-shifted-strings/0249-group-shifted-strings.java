import java.util.*;
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>>map = new HashMap<>();
        for (String str : strings){
            StringBuilder sb = new StringBuilder();
            char base = str.charAt(0);
            for (int i = 0, end = str.length(); i < end; i++){
                int tp = str.charAt(i) - base >= 0 ? str.charAt(i) - base : 26 + str.charAt(i) - base;
                sb.append(tp);
                sb.append(',');
            }
            String key = sb.toString();
            if (map.containsKey(key)) map.get(key).add(str);
            else {
                map.put(key, new LinkedList<>());
                map.get(key).add(str);
            }
        }
        List<List<String>> res = new LinkedList<>();
        // List<String> temp = new LinkedList<>();
        for (Map.Entry<String, List<String>> set :map.entrySet()){
            res.add(set.getValue());
        }
        return res;
    }
}