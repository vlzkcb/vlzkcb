import java.util.*;
class Vector2D {
    List<Integer> arr;
    int size;
    int idx;
    int []ar;
    Iterator<Integer> iter;
    public Vector2D(int[][] vec) {
        idx = 0;
        ar = new int [1000001];
        for (int[] oneDArr : vec){
            for(int el : oneDArr){
               ar[idx++] = el; 
            }
        }
        size = idx;
        idx = 0;
    }
    
    public int next() {
        if(hasNext()){
            return (ar[idx++]);
        }
        return 501;
    }
    
    public boolean hasNext() {
        return idx < size;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */