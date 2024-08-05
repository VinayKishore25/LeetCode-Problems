class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> hm = new HashMap<>();
        int n = arr.length;
        for(int i = 0 ; i < n ; i++)
        {
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        String ans = "";
        for(int i = 0 ; i < n ; i++)
        {
            if(hm.get(arr[i]) == 1)
            {
                k--;
                if(k == 0)
                {
                    ans = arr[i];
                    break;
                }
            }
        }
        return ans;
    }
}