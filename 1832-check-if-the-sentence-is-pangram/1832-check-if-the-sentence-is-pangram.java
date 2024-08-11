class Solution {
    public boolean checkIfPangram(String sentence) {
        int n = sentence.length();
        HashSet<Character> hs = new HashSet<>();
        for(int i = 0 ; i < n ; i++)
        {
            hs.add(sentence.charAt(i));
        }
        for(int i = 0 ; i < 26 ; i++)
        {
            if(!hs.contains((char)('a'+i))){
                // System.out.println('a'+i);
                return false;
            }
        }
        return true;
    }
}