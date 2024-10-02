class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] temp = new int[n];
        // Arrays.copy(arr,temp);
        for(int i = 0 ; i < n ; i++){
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        int rank = 1;
        for(int i = 0 ; i < n ; i++){
            if(!hm.containsKey(temp[i])){
                hm.put(temp[i],rank);
                rank++;
            }
        }
        for(int i = 0 ; i < n ; i++){
            res[i] = hm.get(arr[i]);
        }
        return res;
    }
}