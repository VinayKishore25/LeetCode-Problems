class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int count = 0;
        for(int i = 0 ; i < n ; i++)
        {
            if(st.isEmpty() || s.charAt(i) == 'b' || st.peek() == 'a' || !(st.peek() == 'b' && s.charAt(i) == 'a') )
            {
                st.push(s.charAt(i));
            }
            else
            {
                while(!st.isEmpty() && i < n && s.charAt(i) == 'a' && st.peek() == 'b')
                {
                    // System.out.println(st);
                    st.pop();
                    count++;
                    if(i+1 < n && s.charAt(i+1) == 'a') i++;
                    else break;
                }
            }
        }
        return count;
    }
}