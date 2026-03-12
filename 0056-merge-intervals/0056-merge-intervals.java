class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int last_start = intervals[0][0];
        int last_end = intervals[0][1];
        ArrayList<int[]> check = new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=last_end){
                last_end=Math.max(last_end,intervals[i][1]);
            }else{
                check.add(new int[]{last_start,last_end});
                last_start = intervals[i][0];
                last_end = intervals[i][1];
            }
        }
        check.add(new int[]{last_start, last_end});
        int [][] ans = new int [check.size()][2];
        for(int i=0;i<check.size();i++){
            ans[i]=check.get(i);
        }
        return ans;
    }
}