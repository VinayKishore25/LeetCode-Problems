class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        for(int i = 0 ; i < n - 2; i++)
        {
            int first = rating[i];
            for(int j = i+1 ; j < n - 1 ; j++)
            {
                int second = rating[j];
                if(first < second)
                {
                    for(int k = j + 1 ; k < n ; k++)
                    {
                        int third = rating[k];
                        if(second < third) count++;
                    }  
                }
                else if(first > second)
                {
                    for(int k = j + 1 ; k < n ; k++)
                    {
                        int third = rating[k];
                        if(second > third) count++;
                    }  
                }
            }
        }
        return count;
    }
}