class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int n = allowed.length();
        HashSet<Character> hs = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            hs.add(allowed.charAt(i));
        }
        n = words.length;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            int len = words[i].length();
            int j = 0;
            for(j = 0 ; j < len ; j++){
                if(!hs.contains(words[i].charAt(j))) {
                    break;
                }
            }
            if(j == len){
                count++;
            }

        }
        return count;
    }
}