class Solution {
    public int divide(int dividend, int divisor) {
        long vs = 1,ds=1;
        long d = dividend,q = divisor;
        if(d < 0)
        {
            vs = -1;
            d*=-1;

        }
        if(q < 0)
        {
            ds = -1;
            q*=-1;
        }
        if(dividend==Integer.MIN_VALUE)
        {
            vs=-1;
            if(ds==-1 && q==1)
            return Integer.MAX_VALUE;
        }
        return (int)(vs*ds*(d/q));
    }
}