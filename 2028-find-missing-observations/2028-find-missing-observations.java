class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] res = new int[n];
        if(mean > 6) return new int[0];
        int m = rolls.length;
        int rollSum = 0;
        for(int i = 0; i < m ; i++){
            rollSum += rolls[i];
        }
        int totalSum = mean * (n + m);
        int remSum = totalSum - rollSum;
        if(remSum > n * 6 || remSum <= 0) return new int[0];
        else{
            for(int i = 0 ; i < n ; i++){
                res[i] = remSum/(n-i);
                if(res[i] == 0) return new int[0];
                remSum -= res[i];
            }
        }
        return res;
    }
}