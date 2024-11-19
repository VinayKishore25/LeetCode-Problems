class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int l = 0, r;
        long lastSum = 0;

        for (r = 0; r < k; r++) {
            hm.put(arr[r], hm.getOrDefault(arr[r], 0) + 1);
            lastSum += arr[r];
        }

        long sum = 0;
        while (r <= arr.length) {
            if (hm.size() == k) { // Check if window is distinct
                sum = Math.max(lastSum, sum);
            }

            if (l < arr.length) {
                hm.put(arr[l], hm.get(arr[l]) - 1);
                if (hm.get(arr[l]) == 0) {
                    hm.remove(arr[l]);
                }
                lastSum -= arr[l];
                l++;
            }

            if (r < arr.length) {
                hm.put(arr[r], hm.getOrDefault(arr[r], 0) + 1);
                lastSum += arr[r];
            }
            r++;
        }

        return sum;
    }
}