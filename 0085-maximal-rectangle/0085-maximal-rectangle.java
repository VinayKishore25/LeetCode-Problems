class Solution {
   public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                left[i] = 0;
            }
            else{
                left[i] = st.peek() + 1;
            }
            st.push(i);
        }
        st = new Stack<>();
        for(int i = n - 1 ; i >= 0 ; i--)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                right[i] = n-1;
            }
            else{
                right[i] = st.peek() - 1;
            }
            st.push(i);
        }
        int max = 0;
        for(int i = 0 ; i < n ; i++)
        {
            max = Math.max(max,heights[i]*(right[i] - left[i] + 1));
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] columnSum = new int[m];
        int[][] grid = new int[n][m];
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0; j < m ; j++)
            {
                if(matrix[i][j] == '1')
                {
                    columnSum[j]++;
                    grid[i][j] = columnSum[j];
                }
                else
                {
                    columnSum[j] = 0;
                    grid[i][j] = 0;
                }
            }
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++)
        {
            int res = largestRectangleArea(grid[i]);
            ans = Math.max(res,ans);
        }
        return ans;
    }
}