class Solution {
    int solve(int i,int j1,int j2,int[][] meetings,int[] ans,int[][][] dp)
    {
        if(i >= meetings.length)return 0;
        if(j1 < 0 || j1 >= meetings[0].length) return 0;
        if(j2 < 0 || j2 >= meetings[0].length) return 0;
        if(dp[i][j1][j2]!=-1)return dp[i][j1][j2];
        if(j1==j2)return 0;
        int a = meetings[i][j1] + meetings[i][j2] + solve(i+1,j1+1,j2+1,meetings,ans,dp);
        int b = meetings[i][j1] + meetings[i][j2] + solve(i+1,j1+1,j2-1,meetings,ans,dp);
        int c = meetings[i][j1] + meetings[i][j2] + solve(i+1,j1+1,j2,meetings,ans,dp);

        int d = meetings[i][j1] + meetings[i][j2] + solve(i+1,j1,j2+1,meetings,ans,dp);
        int e = meetings[i][j1] + meetings[i][j2] + solve(i+1,j1,j2-1,meetings,ans,dp);
        int f = meetings[i][j1] + meetings[i][j2] + solve(i+1,j1,j2,meetings,ans,dp);

        int g = meetings[i][j1] + meetings[i][j2] + solve(i+1,j1-1,j2+1,meetings,ans,dp);
        int h = meetings[i][j1] + meetings[i][j2] + solve(i+1,j1-1,j2-1,meetings,ans,dp);
        int z = meetings[i][j1] + meetings[i][j2] + solve(i+1,j1-1,j2,meetings,ans,dp);
        ans[0] = Math.max(a,Math.max(b,Math.max(c,Math.max(d,Math.max(e,Math.max(f,Math.max(g,Math.max(h,z))))))));
        return dp[i][j1][j2] = ans[0];
    }
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[71][71][71];
        for(int[][] dp1:dp)
        {
            for(int[] dp2:dp1)
            {
                Arrays.fill(dp2,-1);
            }
        }
        int[] ans = new int[1];
        ans[0] = 0;
        ans[0] = solve(0,0,grid[0].length - 1,grid,ans,dp);
        return ans[0];
    }
}