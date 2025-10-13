class Solution {
    public boolean isAnagram(String a,String b){
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        String s1 = new String(ch1);
        String s2 = new String(ch2);
        return s1.equals(s2);
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        res.add(words[0]);
        int j = 0;
        for(int i = 1 ; i < n ; i++){
            if(!isAnagram(words[i],res.get(j))){
                res.add(words[i]);
                j++;
            }
        }
        return res;
    }
}