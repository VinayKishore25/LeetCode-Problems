class Solution {
    public int tribonacci(int n) {
        int first = 0 , second = 1, third = 1,fourth;
        for(int i = 1 ; i <= n ; i++)
        {
            fourth = first + second + third;
            first = second;
            second = third;
            third = fourth;
        }
        return first;
    }
}