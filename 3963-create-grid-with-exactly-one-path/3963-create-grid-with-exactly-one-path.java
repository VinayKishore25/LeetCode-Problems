class Solution {
    public String[] createGrid(int m, int n) {
        String first = "";
        for(int i = 0 ; i < n ; i++){
            first += '.';
        }
        String[] res = new String[m];
        res[0] = first;
        for(int i = 1 ; i < m ; i++){
            String curr = "";
            for(int j = 0 ; j < n - 1 ; j++){
                curr += '#';
            }
            curr += '.';
            res[i] = curr;
        }
        return res;
    }
}