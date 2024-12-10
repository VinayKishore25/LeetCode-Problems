class Solution {
    public int helper(int a, int b,String ch)
    {
        int ans = 0;
        switch(ch)
        {
            case "+":
            ans = a+b;
            break;
            case "-":
            ans = b - a;
            break;
            case "*":
            ans = b*a;
            break;
            case "/":
            ans = b/a;
            break;
        }
        return ans;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> num = new Stack<>();
        for(int i = 0 ; i < tokens.length ; i++)
        {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*"))
            {
                int ans = helper(num.pop(),num.pop(),tokens[i]);
                num.push(ans);
            }
            else
            {
                num.push(Integer.parseInt(tokens[i]));
            }
        }
        return num.pop();
    }
}