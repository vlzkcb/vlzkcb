import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        Stack<Character> sta = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            //만약 스택이 비어있고 닫는것이 나온다면?
            if (sta.size() == 0 && isClosed(temp)) return false;
            else if (isClosed(s.charAt(i))){
                if (sta.peek() == map.get(temp))
                    sta.pop();
                else return false;
            }else if (!isClosed(temp)) sta.push(temp);
        }
        if (sta.size() == 0)return true;
        return false;
    }
    static boolean isClosed(char c){
        return (c == ']' || c == '}' || c == ')');
    }
}