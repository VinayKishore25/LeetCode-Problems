class Solution {
    public double separateSquares(int[][] squares) {
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        double totalArea = 0;
        int n = squares.length;
        double limit = Math.pow(10,-5);
        for(int i = 0 ; i < n ; i++){
            int y = squares[i][1];
            int side = squares[i][2];
            totalArea += (double)side * side;
            minY = Math.min(y,minY);
            maxY = Math.max(y + side,maxY);
        }
        double low = minY/1.0;
        double high = maxY/1.0;
        while(low < high){
            if(high - low < limit){
                break;
            }
            double mid = low + (high - low)/2;
            double topArea = getArea(squares,mid);
            double bottomArea = totalArea - topArea;
            if(topArea <= bottomArea){
                high = mid;
            }
            else{
                low = mid;
            }
        }
        return low;
    }
    public double getArea(int[][] squares, double line){
        double area = 0.0;

        for (int[] square : squares) {
            double y = square[1];
            double width = square[2];

            if (y >= line) {
                area += width*width;
            } else {
                if (y + width >= line) {
                    double actualHeight = y+width-line;
                    area += actualHeight*width;
                }
            }
        }

        return area;
    }
}