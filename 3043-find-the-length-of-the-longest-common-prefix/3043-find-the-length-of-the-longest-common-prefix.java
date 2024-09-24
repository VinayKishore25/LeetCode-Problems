class Solution {
    public int getLength(int num){
        int count = 0;
        while(num > 0){
            count++;
            num /= 10;
        }
        return count;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet<>();
        int n = arr1.length;
        for(int i = 0 ; i < n ; i++){
            int temp = arr1[i];
            while(temp > 0){
                hs.add(temp);
                temp /= 10;
            }
        }
        n = arr2.length;
        int len = 0;
        for(int i = 0 ; i < n ; i++){
            int temp = arr2[i];
            while(temp > 0){
                if(hs.contains(temp)){
                    len = Math.max(len,getLength(temp));
                    break;
                }
                temp /= 10;
            }
        }
        return len;
    }
}