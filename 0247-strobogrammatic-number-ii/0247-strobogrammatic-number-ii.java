import java.util.*;
class Solution {
    public List<String> findStrobogrammatic(int n) {
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(1,new ArrayList<>(Arrays.asList(new String []{"0","1","8"})));
        map.put(2,new ArrayList<>(Arrays.asList(new String []{"00","11","69","88","96"})));
        for (int i = 3; i <= n; i++){
            if (i % 2 == 0){
                List<String> base = map.get(i - 2);
                List<String> base_2 = map.get(2);
                List<String> res = new ArrayList<>();
                for (String str : base){
                    if (str.compareTo("00") == 0) continue;
                    StringBuilder sb = new StringBuilder(str);
                    for (String str_2 : base_2){
                        sb.insert(sb.length()/2, str_2.charAt(0));
                        sb.insert((sb.length()/2) + 1 ,str_2.charAt(1));
                        res.add(sb.toString());
                        sb.deleteCharAt(sb.length()/2);
                        sb.deleteCharAt(sb.length()/2);
                    }
                }
                map.put(i, res);
            }else{
                List<String> base = map.get(i - 1);
                List<String> base_1 = map.get(1);
                List<String> res = new ArrayList<>();
                int idx = 0;
                for (String str : base){
                    if (str.compareTo("00") == 0) continue;
                    StringBuilder sb = new StringBuilder(str);
                    for (String str_1 : base_1){
                        sb.insert(sb.length()/2, str_1.charAt(0));
                        res.add(sb.toString());
                        sb.deleteCharAt(sb.length()/2);
                    }
                }
                map.put(i, res);
            }
        }
        map.put(2,new ArrayList<>(Arrays.asList(new String []{"11","69","88","96"})));
        return map.get(n);
    }
}

//1 8 0
//11 69 88 96
//111 181 101 619 689 609 818 888 808 916 986 906
//1111 1691 1881 1961