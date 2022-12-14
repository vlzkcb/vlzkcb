class Solution {
    static List<Character> lst;
    static Set<String> st;
    static boolean[] V;
    static String ss;
    static int [] count;
    public List<String> generatePalindromes(String s) {
        int si = 0;
        count = new int[26];
        int oddNum = 0;
        int oddPos = -1;
        ss = s;
        lst = new LinkedList<>();
        st = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            // if (count[s.charAt(i) - 'a'] == 1) si++;
        }
        for (int i = 0; i < 26; i++){
            if (count[i] % 2 == 1) {
                oddNum++;
                oddPos = i;
            }
        }
        if (s.length() % 2 == 0 && oddNum != 0) return new LinkedList<>();
        if (s.length() % 2 == 1 && oddNum != 1) return new LinkedList<>();
        for (int i = 0; i < 26; i++){
            if (count[i] > 1){
                for (int j = 0; j < count[i] / 2 ; j++){
                    lst.add((char)(i + 'a'));
                }
            } 
        }
        V = new boolean[lst.size()];
        getString(0, new StringBuilder(), oddPos);
        return new LinkedList<>(st);
    }
    static void getString(int pos, StringBuilder sb, int idx){
        if (pos == lst.size()){
            for (int i = sb.length() - 1; i > -1; i--){
                sb.append(sb.toString().charAt(i));
            }
            if (ss.length() % 2 == 1) sb.insert(sb.length() / 2, (char)(idx+'a'));
            st.add(sb.toString());
            if (ss.length() % 2 == 1) sb.deleteCharAt(sb.length() / 2);
            sb.setLength(sb.length() / 2);
            return;
        }
        for (int i = 0; i < lst.size(); i++){
            if (V[i]) continue;
            V[i] = true;
            getString(pos + 1, sb.append(lst.get(i)), idx);
            V[i] = false;
            sb.setLength(sb.length() - 1);
        }
    }
}