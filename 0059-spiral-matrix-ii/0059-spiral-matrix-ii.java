class Solution {
    public int[][] generateMatrix(int n) {
        int ans = 1;
        int[][] a = new int[n][n];
        int rs = 0 , re = n - 1 , cs = 0 , ce = n - 1;
        while(ans <= n * n)
        {
            for(int i = cs ; i <= ce ; i++)
            {
                a[rs][i] = ans++;
            }
            rs++;
            for(int i = rs ; i <= re ; i++)
            {
                a[i][ce] = ans++;
            }
            ce--;
            for(int i = ce ; i >= cs ; i--)
            {
                a[re][i] = ans++;
            }
            re--;
            for(int i = re ; i >= rs ; i--)
            {
                a[i][cs] = ans++;
            }
            cs++;
        }
        return a;
    }
}