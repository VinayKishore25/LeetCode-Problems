class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[10];
        fact[1] = 1;
        fact[0] = 1;
        for(int i = 2 ; i < 10 ; i++){
            fact[i] = fact[i - 1] * i;
        }
        // if(k == fact[n]){
        //     String res = "";
        //     for(int i = 4 ; i > 0 ; i--){
        //         res += i;
        //     }
        //     return res;
        // }
        boolean[] taken = new boolean[n+1];
        return solve(n,n,k,fact,taken);
    
    } 
    public String solve(int i, int n, int k, int[] fact, boolean[] taken){
        if(i == 1){
            for(int p = 1 ; p <= n ; p++){
                if(!taken[p]){
                    return p + ""; 
                }
            }
        }
        int currentValue = (k - 1) / fact[i - 1] + 1;
        int nextK = k % fact[i - 1] == 0 ? fact[i - 1] : k % fact[i - 1];
        int temp = 0;
        for(int p = 1 ; p <= n ; p++){
            if(!taken[p]){
                currentValue--;
            }
            if(currentValue == 0){
                temp = p;
                break;
            }
        }
        taken[temp] = true;
        String res = temp + "";
        res += solve(i - 1, n, nextK, fact, taken);
        return res;
    }
}