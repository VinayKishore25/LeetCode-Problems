class Solution {
    public String getSum(String s, int k){
        int sum = 0;
        for(int i = 0 ; i < Math.min(s.length(), k) ; i++){
            sum += (s.charAt(i) - '0');
        }
        return Integer.toString(sum);
    }
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > k){
            int n = sb.length();
            StringBuilder temp = new StringBuilder();
            for(int i = 0 ; i < n ; i += k){
                String group = sb.substring(i, Math.min(i + k, sb.length()));
                String result = getSum(group, k);
                temp.append(result);
            }
            sb = temp;
        }
        return sb.toString();
    }
}