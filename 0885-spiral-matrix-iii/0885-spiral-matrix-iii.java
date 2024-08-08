class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int n = rows*cols;
        int[][] ans = new int[n][2];
        int count = 0;
        int rs = 0 , re = rows, cs = 0 , ce = cols;
        boolean[][] vis = new boolean[rows][cols];
        int rc = rStart , cc = cStart;
        int iter = 1;
        while(count < n)
        {
            int temp = iter;
            //Right 
            while(temp-- > 0){
                if(rc >= 0 && cc >= 0 && rc < re && cc < ce)
                {
                    ans[count][0] = rc;
                    ans[count][1] = cc;
                    count++;
                }
                cc++;
            }

            //down
            temp = iter;
            while(temp-- > 0){
                if(rc >= 0 && cc >= 0 && rc < re && cc < ce)
                {
                    ans[count][0] = rc;
                    ans[count][1] = cc;
                    count++;
                }
                rc++;
            }

            //left
            iter++;
            temp = iter;
            while(temp-- > 0){
                if(rc >= 0 && cc >= 0 && rc < re && cc < ce)
                {
                    ans[count][0] = rc;
                    ans[count][1] = cc;
                    count++;
                }
                cc--;
            }

            //up
            temp = iter;
            while(temp -- > 0)
            {
                if(rc >= 0 && cc >= 0 && rc < re && cc < ce)
                {
                    ans[count][0] = rc;
                    ans[count][1] = cc;
                    count++;
                }
                rc--;
            }
            iter++;
        }
        return ans;
    }
}