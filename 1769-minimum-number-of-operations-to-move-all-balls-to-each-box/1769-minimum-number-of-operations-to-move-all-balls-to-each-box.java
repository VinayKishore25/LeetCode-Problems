class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 0;
        suffix[n-1] = 0;
        int oneCount = 0;
        if(boxes.charAt(0) == '1'){
            oneCount++;
        }
        for(int i = 1 ; i < n ; i++){
            prefix[i] = prefix[i-1] + oneCount;
            if(boxes.charAt(i) == '1'){
                oneCount++;
            }
        }
        // System.out.println(Arrays.toString(prefix));
        oneCount = 0;
        if(boxes.charAt(n-1) == '1'){
            oneCount++;
        }
        for(int i = n - 2 ; i >= 0 ; i--){
            suffix[i] = suffix[i + 1] + oneCount;
            if(boxes.charAt(i) == '1'){
                oneCount++;
            }
        }
        int[] answer = new int[n];
        for(int i = 0 ; i < n ; i++){
            answer[i] = prefix[i] + suffix[i];
        }
        return answer;
    }
}