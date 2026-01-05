class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int minValue = Integer.MAX_VALUE;
        int n = matrix.length;
        int negCount = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] < 0){
                    matrix[i][j] *= -1;
                    negCount++;
                }
                sum += matrix[i][j];
                minValue = Math.min(minValue,matrix[i][j]);
            }
        }
        if(negCount%2 == 0){
            return sum;
        }
        return sum - 2 * minValue;
    }
}