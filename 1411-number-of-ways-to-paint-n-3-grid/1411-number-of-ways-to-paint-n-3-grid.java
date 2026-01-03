class Solution {
    public int numOfWays(int n) {
        int mod = 10000_00007;
        if( n == 1) {
            return 12;
        }
        long sameCorners = 6;
        long diffCorners = 6;
        long result = 0;
        for(int i = 2 ; i <= n ; i++){
            long res1 = (sameCorners * 5)%mod;
            long res2 = (diffCorners * 4)%mod;
            long temp = sameCorners;
            sameCorners = (sameCorners * 3 + diffCorners * 2)%mod;
            diffCorners = (temp * 2+ diffCorners * 2)%mod;
            result = (res1 + res2)%mod;
        }    
        return (int)result;
    }
    
}