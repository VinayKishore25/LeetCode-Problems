class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = nums1.length + nums2.length;
        int[] a = new int[i];
        for(int j = 0 ; j < nums1.length ; j++)
        {
            a[j] = nums1[j];
        }
        int k = 0;
        for(int j = nums1.length ; j < i ;j++)
        {
            a[j] = nums2[k];
            k++;
        }
        Arrays.sort(a);
        if(i%2 == 0)
        {
            double c = (double)(a[i/2]+a[i/2-1])/2;
            return c;
        }
        else
        return (double)a[i/2];
    }
}