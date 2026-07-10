class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int mid = (n + m)/2;
        int i = 0 , j = 0 , count = 0;
        int currentValue = -1;
        int previousValue = -1;
        while(i < n && j < m && count <= mid){
            if(nums1[i] < nums2[j]){
                previousValue = currentValue;
                currentValue = nums1[i];
                count++;
                i++;
            }
            else{
                previousValue = currentValue;
                currentValue = nums2[j];
                count++;
                j++;
            }
        }
        while(count <= mid && i < n){
            previousValue = currentValue;
            currentValue = nums1[i];
            count++;
            i++;
        }
        while(count <= mid && j < m){
            previousValue = currentValue;
            currentValue = nums2[j];
            count++;
            j++;
        }
        if((n+m) % 2 != 0) return currentValue/1.0;
        else return (currentValue + previousValue)/2.0;
    }
}