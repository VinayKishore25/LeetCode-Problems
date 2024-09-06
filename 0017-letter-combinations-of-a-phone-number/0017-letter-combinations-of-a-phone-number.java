class Solution {
    public void solve(HashMap<Character,String> hm,int i,StringBuilder sb,List<String> al,String digits,int n){
        // if(i == n -1){
            
        //     return;
        // }
        if(i >= n)
        {
            al.add(sb.toString());
            return;
        }
        String s = hm.get(digits.charAt(i));
        int len = s.length();
        for(int j = 0 ; j < len; j++){
            sb.append(s.charAt(j));
            solve(hm,i+1,sb,al,digits,n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> hm = new HashMap<>();
        int n = digits.length();
        if(n == 0) return new ArrayList<String>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        List<String> al = new ArrayList<>();
        int len = hm.get(digits.charAt(0)).length();
        for(int i = 0 ; i < len; i++){
            StringBuilder sb = new StringBuilder();
            String s = hm.get(digits.charAt(0));
            sb.append(s.charAt(i));
            solve(hm,1,sb,al,digits,n);
            sb.deleteCharAt(sb.length() - 1);
        }
        return al;
    }
}