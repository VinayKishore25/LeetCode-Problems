class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        LinkedHashSet<Integer> uniqueIntegers = new LinkedHashSet<>();
        boolean[] visited = new boolean[n];
        Arrays.sort(digits);
        solve(digits, visited, new StringBuilder(), uniqueIntegers, n);
        int[] ans = new int[uniqueIntegers.size()];
        int i = 0;
        for(int num : uniqueIntegers){
            ans[i++] = num;
        }
        // Arrays.sort(ans);
        return ans;
    }
    public void solve(int[] digits, boolean[] visited, StringBuilder sb, LinkedHashSet<Integer> uniqueIntegers, int n){
        if(sb.length() == 3){
            int num = Integer.parseInt(sb.toString());
            if(num % 2 == 0){
                uniqueIntegers.add(num);
            }
            return;
        }
        int previousDigit = -1;
        for(int i = 0 ; i < n ; i++){
            if(previousDigit == digits[i]){
                continue;
            }
            if(visited[i]){
                continue;
            }
            if(sb.length() == 0 && digits[i] == 0){
                continue;
            }
            sb.append(digits[i]);
            visited[i] = true;
            solve(digits,visited,sb,uniqueIntegers,n);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
            previousDigit = digits[i];
        }

    }
}