import java.util.*;
class Solution {
    static int getInteger(char c){
        if (c == 'I') return 1;
        else if (c == 'V') return 5;
        else if (c == 'X') return 10;
        else if (c == 'L') return 50;
        else if (c == 'C') return 100;
        else if (c == 'D') return 500;
        else return 1000;
        
    }
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
             if (getInteger(cur) - getInteger(next) >= 0){
                 sum += getInteger(cur);
             }else{
                 sum += (getInteger(next) - getInteger(cur));
                 i++;
             }
        }
        if (i == s.length() - 1)
            sum += getInteger(s.charAt(i));
        return sum;
    }
}