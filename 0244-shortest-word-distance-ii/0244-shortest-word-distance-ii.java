import java.util.*;
class WordDistance {
    static Map<String, List<Integer>>map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        int idx = 0;
        for (String word : wordsDict){
            if (map.containsKey(word)) map.get(word).add(idx);
            else {
                List<Integer> lst = new ArrayList<>();
                lst.add(idx);
                map.put(word, lst);
            }
            idx++;
        }
    }
    
    public int shortest(String word1, String word2) {
        int minV = Integer.MAX_VALUE;
        List<Integer> w1Lst = map.get(word1);
        List<Integer> w2Lst = map.get(word2);
        int w1Size = w1Lst.size();
        int w2Size = w2Lst.size();
        for (int i = 0; i < w1Size; i++){
            for (int j = 0; j < w2Size; j++){
                if (Math.abs(w1Lst.get(i) - w2Lst.get(j)) < minV){
                    minV = Math.abs(w1Lst.get(i) - w2Lst.get(j)); 
                }
            }
        }
        return minV;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */