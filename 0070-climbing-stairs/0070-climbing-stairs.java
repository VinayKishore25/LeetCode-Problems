class Solution {
    public int climbStairs(int n) {
        int first = 1;
        int second = 1;
        int third;
        while(n-->0)
        {
            third = first+second;
            first = second;
            second = third;
        }
        return first;
    }
}