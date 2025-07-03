class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        List<Integer> al = new ArrayList<>();
        for(int key : hm.keySet()){
            if(hm.get(key) >= k){
                al.add(key);
            }
        }
        return al.stream().mapToInt(Integer::intValue).toArray();
    }
}