class Solution {
    public int removeElement(int[] nums, int val) {
        int l = nums.length;
        int[] a = new int[l];
        Arrays.fill(a,0);
        int j = 0;
        for(int i = 0 ; i < l ; i++)
        {
            if(nums[i] != val)
            {
                a[j++] = nums[i]; 
            }
        }
        for(int i = 0 ; i < j ; i++)
        nums[i] = a[i];
        return j;
    }
}