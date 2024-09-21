class Solution {
    public List<Integer> lexicalOrder(int n) {
        String[] res = new String[n];
        for(int i = 1 ; i <= n ; i++){
            res[i-1] = Integer.toString(i);
        }
        Arrays.sort(res);
        List<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            al.add(Integer.parseInt(res[i]));
        }
        return al;
    }
}