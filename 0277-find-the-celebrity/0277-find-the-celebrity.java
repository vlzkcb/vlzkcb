/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        boolean[] isCele = new boolean[n];
        Arrays.fill(isCele, true);
        
        for(int i = 0; i < n; i++){
            // if (!isCele[i]) continue;
            for(int j = 0; j < n; j++){
                if (i != j && knows(i,j)) isCele[i] = false;
                if (i != j && knows(j,i)) isCele[j] = false;
                if(isCele[j]){
                    if(!knows(i, j)) isCele[j] = false;
                }
            }
        }
        int idx = -1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (isCele[i]) {
                cnt++;
                idx = i;
            }
        }
        if (cnt != 1) return -1;
        return idx;
        // return -1;
    }
}