class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long minimumBoth = Math.min(need1, need2);
        long totalSum = Math.min(minimumBoth * costBoth, minimumBoth * (cost1 + cost2));

        long remainingNeed1 = need1 - minimumBoth;
        long remainingNeed2 = need2 - minimumBoth;

        if(remainingNeed1 > 0){
            totalSum += Math.min(remainingNeed1 * cost1, remainingNeed1 * costBoth);
        }
        if(remainingNeed2 > 0){
            totalSum += Math.min(remainingNeed2 * cost2, remainingNeed2 * costBoth);
        }

        return totalSum;
    }
}