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
        // st.clear();
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
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        int max = 0;
        for(int i = 0 ; i < n ; i++)
        {
            max = Math.max(max,heights[i]*(right[i] - left[i] + 1));
        }
        return max;
    }
}