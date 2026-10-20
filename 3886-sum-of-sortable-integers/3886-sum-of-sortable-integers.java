import java.util.*;

class Solution {

    public boolean isRotatedSortedArray(int[] nums, int start, int end) {
        int decreasing = 0;

        for (int i = start; i < end - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                decreasing++;
            }
        }

        // Circular boundary
        if (nums[end - 1] > nums[start]) {
            decreasing++;
        }

        return decreasing <= 1;
    }

    public HashSet<Integer> getAllDivisors(int n) {
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                hs.add(i);
                hs.add(n / i);
            }
        }

        return hs;
    }

    public boolean haveAllElements(
            int[] sortedArray,
            int[] nums,
            int start,
            int k,
            int[] freq) {

        // Add elements from the sorted block
        for (int i = start; i < start + k; i++) {
            freq[sortedArray[i]]++;
        }

        // Subtract elements from the original block
        for (int i = start; i < start + k; i++) {
            freq[nums[i]]--;
        }

        boolean same = true;

        // Check only values appearing in the two blocks
        for (int i = start; i < start + k; i++) {
            if (freq[sortedArray[i]] != 0 ||
                freq[nums[i]] != 0) {
                same = false;
                break;
            }
        }

        // Reset the frequency array for the next block
        for (int i = start; i < start + k; i++) {
            freq[sortedArray[i]] = 0;
            freq[nums[i]] = 0;
        }

        return same;
    }

    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] sortedArray = nums.clone();
        Arrays.sort(sortedArray);

        int[] freq = new int[100001];

        HashSet<Integer> divisors = getAllDivisors(n);

        long result = 0;

        for (int k : divisors) {
            boolean isSortable = true;

            for (int start = 0; start < n; start += k) {

                if (!isRotatedSortedArray(nums, start, start + k)) {
                    isSortable = false;
                    break;
                }

                if (!haveAllElements(
                        sortedArray, nums, start, k, freq)) {
                    isSortable = false;
                    break;
                }
            }

            if (isSortable) {
                result += k;
            }
        }

        return (int) result;
    }
}