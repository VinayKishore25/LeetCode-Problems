class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                newMatrix[i][j] = matrix[n - j - 1][n - i - 1];
            }
        }
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                matrix[i][j] = newMatrix[n - i - 1][j];
            }
        }
    }
}