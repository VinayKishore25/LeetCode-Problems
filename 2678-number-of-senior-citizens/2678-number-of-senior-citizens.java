class Solution {
    public int countSeniors(String[] details) 
    {
        int n = details.length;
        int count = 0;
        for(int i = 0 ; i < n ; i++)
        {
            int strLen = details[i].length();
            String curr = details[i];
            int value = (curr.charAt(11) - '0')*10 +curr.charAt(12) - '0';
            System.out.println(value);
            if(value > 60)
            {
                count++;
            }
        }
        return count;
    }
}