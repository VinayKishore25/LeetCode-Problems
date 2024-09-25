class Solution {
    public String minWindow(String s, String t) {
       int[] tcarr = new int[52];
       for (char c: t.toCharArray()) {
           tcarr[index(c)]++;
       }
       int[] scarr = new int[52];
       String res = "";
       int m = s.length();
       int j = 0;
       for (int i = 0; i < m; i++) {
           char c = s.charAt(i);
           scarr[index(c)]++;
           while (j < m && allCharsIn(tcarr, scarr)) {
               if (res.length() == 0 || res.length() > i + 1 - j) {
                   res = s.substring(j, i+1);
               }
               scarr[index(s.charAt(j))]--;
               j++;
           }
       }
       return res;
    }

    private int index(char c) {
        if (c - 'a' < 0) {
            return c - 'A';
        }
        return 'Z' - 'A' + 1 + c - 'a';
    }

    private boolean allCharsIn(int[] tcarr, int[] scarr) {
        for (int i = 0; i < tcarr.length; i++) {
            if (tcarr[i] > scarr[i]) {
                return false;
            }
        }
        return true;
    }
}