class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] res = new int[n];
        for(int i = 0 ; i < n ; i++){
            String temp = timePoints.get(i);
            int hour = Integer.parseInt(temp.charAt(0)+""+temp.charAt(1));
            int minute = Integer.parseInt(temp.charAt(3)+""+temp.charAt(4));
            res[i] = (hour*60+minute)%1440;
        }
        Arrays.sort(res);
        System.out.println(Arrays.toString(res));
        int ans = res[n-1] - res[0];
        ans = Math.min(ans,1440 - res[n-1] + res[0]);
        for(int i = 1 ; i < n ; i++){
            ans = Math.min(ans,res[i] - res[i-1]);
            ans = Math.min(ans, 1440 - res[i] + res[i-1]);
        }
        return ans;
    }
}