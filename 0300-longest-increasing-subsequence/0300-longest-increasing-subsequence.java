class Solution {
    public static int lowerBound(ArrayList<Integer> al, int key)
    {
        int ind = Collections.binarySearch(al,key);
        // System.out.println(ind);
        if(ind < 0)
        return Math.abs(ind) - 1;
        while(ind > 0)
        {
            if(al.get(ind - 1) == key)
            ind--;
            else
            return ind;
        }
        return ind;
    }
    public int lengthOfLIS(int[] nums) {
        // Arrays.sort(nums);
        ArrayList<Integer> al = new ArrayList<>();
        al.add(nums[0]);
        // int index = Arrays.binarysearch(nums[i],key)
        for(int i = 1; i < nums.length ; i++)
        {
            int low = lowerBound(al,nums[i]);
            if(low - 0 >= al.size())
            al.add(nums[i]);
            else
            al.set(low,nums[i]);
        }
        return al.size();
    }
}