class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        int n1 = arr1.length;
        int n2 = arr2.length;
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < n1 ; i++){
            hm.put(arr1[i],hm.getOrDefault(arr1[i],0)+1);
        }
        for(int i = 0 ; i < n2 ; i++){
            hm.put(arr2[i],hm.getOrDefault(arr2[i],0)+1);
        }
        String res = "";
        int j = 0;
        for(String each : hm.keySet()){
            if(hm.get(each) == 1){
                res += each + " ";
            }
        }
        if(res.equals("")) return new String[0];
        return res.split(" ");
    }
}