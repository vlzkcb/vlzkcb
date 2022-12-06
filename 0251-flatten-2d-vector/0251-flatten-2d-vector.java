class Vector2D {
    
    int[][] v;
    int row, col;
    int N;
    
    public Vector2D(int[][] v) {
        this.v = v;
        row = 0;
        col = 0;
        N = v.length;
    }
    
    public int next() {
        int ret = 0;
        if (col < v[row].length) {
            ret = v[row][col];
        } else {
            col = 0;
            row = nextValidRow(row);
            ret = v[row][col];
        }
        
        if (col + 1 < v[row].length)
            col++;
        else {
            col = 0;
            row = nextValidRow(row);
        }
        return ret;
    }
    
    public boolean hasNext() {
        if (row >= N) return false;
        if (col < v[row].length) 
            return true;
       
        return (nextValidRow(row) < N);
    }
    
    private int nextValidRow(int r) {
        r++;
        while(r < N) {
            if (v[r].length > 0)
                return r;
            r++;
        }
        return r;
    }
}