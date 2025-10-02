class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int sum = numBottles;
        int empty = numBottles;
        while(empty-numExchange >= 0)
        {
            empty = empty - numExchange + 1;
            sum+=1;
            numExchange++;
        }
        return sum;
    }
}