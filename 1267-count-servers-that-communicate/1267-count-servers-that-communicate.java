class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowServers=new int[m]; 
        int[] colServers=new int[n];

        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){                   
                    rowServers[i]++;
                    colServers[j]++;                    
                }
            }
        }

        int result=0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){                   
                    if(rowServers[i] > 1 || colServers[j] > 1){
                        result++;
                    }                 
                }
            }
        }

        return result;
    }
}