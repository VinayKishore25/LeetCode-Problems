class Solution {
    public boolean isMagic(int[][] grid,int row, int col)
    {
        HashSet<Integer> hs = new HashSet<>(); 
        if(hs.contains(grid[row][col]) || grid[row][col] > 9 || grid[row][col] <= 0){
            return false;
        }
        else{
            hs.add(grid[row][col]);
        }
        if(hs.contains(grid[row][col+1]) || grid[row][col+1] > 9 ||grid[row][col+1] <= 0){
            return false;
        }
        else{
            hs.add(grid[row][col+1]);
        }
        if(hs.contains(grid[row][col+2]) || grid[row][col+2] > 9 || grid[row][col+2] <= 0){
            return false;
        }
        else{
            hs.add(grid[row][col+2]);
        }

        if(hs.contains(grid[row+1][col])|| grid[row+1][col] > 9 || grid[row+1][col] <= 0){
            return false;
        }
        else{
            hs.add(grid[row+1][col]);
        }
        if(hs.contains(grid[row+1][col+1]) || grid[row+1][col+1] > 9 || grid[row+1][col+1] <= 0){
            return false;
        }
        else{
            hs.add(grid[row+1][col+1]);
        }
        if(hs.contains(grid[row+1][col+2]) || grid[row+1][col+2] > 9 || grid[row+1][col+2] <= 0){
            return false;
        }
        else{
            hs.add(grid[row+1][col+2]);
        }

        if(hs.contains(grid[row+2][col]) || grid[row+2][col] > 9 || grid[row+2][col] <= 0){
            return false;
        }
        else{
            hs.add(grid[row+2][col]);
        }
        if(hs.contains(grid[row+2][col+1]) || grid[row+2][col+1] > 9 || grid[row+2][col+1] <= 0){
            return false;
        }
        else{
            hs.add(grid[row+2][col+1]);
        }
        if(hs.contains(grid[row+2][col+2]) || grid[row+2][col+2] > 9 || grid[row+2][col+1] <= 0){
            return false;
        }
        else{
            hs.add(grid[row+2][col+2]);
        }
        int res1 = grid[row][col] + grid[row][col+1] + grid[row][col+2];
        int res2 = grid[row+1][col] + grid[row+1][col+1] + grid[row+1][col+2];
        int res3 = grid[row+2][col] + grid[row+2][col+1] + grid[row+2][col+2];
        int res4 = grid[row][col] + grid[row+1][col] + grid[row+2][col];
        int res5 = grid[row][col+1] + grid[row+1][col+1] + grid[row+2][col+1];
        int res6 = grid[row][col+2] + grid[row+1][col+2] + grid[row+2][col+2];
        int res7 = grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2];
        int res8 = grid[row+2][col] + grid[row+1][col+1] + grid[row][col+2];
        if(res1 == res2 && res2 == res3 && res3 == res4 && res4 == res5 && res5 == res6 && res6 == res7 && res7 == res8){
            return true;
        }
        return false;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0 ; i < n - 2; i++)
        {
            for(int j = 0 ; j < m - 2 ; j++)
            {
                if(isMagic(grid,i,j)){
                    ans+=1;
                }
            }
        }
        return ans;
    }
}