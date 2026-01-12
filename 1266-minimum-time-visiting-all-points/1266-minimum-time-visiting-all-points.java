class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int timeRequired = 0;
        for(int i = 1 ; i < n ; i++){
            int sX = points[i-1][0];
            int sY = points[i-1][1];
            int dX = points[i][0];
            int dY = points[i][1];
            int nX = Math.abs(dX - sX);
            int nY = Math.abs(dY - sY);
            timeRequired += Math.max(nX,nY);
        }
        return timeRequired;
    }
}