import java.util.*;
class Solution {
    public int romanToInt(String s) {
        Map <Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum = 0;
        int i,end;
         for (i = 0, end = s.length() - 1; i < end; i++){
             char cur = s.charAt(i);
             char next = s.charAt(i + 1);
             if (map.get(cur) - map.get(next) >= 0){
                 sum += map.get(cur);
             }else{
                 sum += (map.get(next) - map.get(cur));
                 i++;
             }
        }
        if (i == s.length() - 1)
            sum += map.get(s.charAt(i));
        return sum;
    }
}