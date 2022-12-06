class Vector2D {
    List<Integer> arr;
    int size;
    int idx;
    public Vector2D(int[][] vec) {
        arr = new LinkedList<>();
        for (int[] oneDArr : vec){
            for(int el : oneDArr){
               arr.add(el); 
            }
        }
        size = arr.size();
        idx = 0;
    }
    
    public int next() {
        if(hasNext()){
            idx++;
            return (arr.get(idx - 1));
        }else{
            return (-1000);
        }
        
    }
    
    public boolean hasNext() {
        return (idx < size);
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */