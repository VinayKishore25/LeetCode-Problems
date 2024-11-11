class Solution {
    public List<Integer> getRow(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        return getRow(n, ans); 
    }

    public List<Integer> getRow(int n, List<Integer> row) {
        if (n == 0) return row;

        for (int i=row.size()-1; i>0; i--) {
            row.set(i, row.get(i) + row.get(i-1));
        }
        row.add(1);

        return getRow(n-1, row);
    }
}