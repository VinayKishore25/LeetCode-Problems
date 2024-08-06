class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        Character[] arr = new Character[n];
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = word.charAt(i);
        }
        int[] freq = new int[26];
        for(char each : arr)
        {
            freq[each - 'a'] += 1; 
        }
        Arrays.sort(arr,(c,d) -> freq[d -'a'] - freq[c - 'a']);
        HashMap<Character,Integer> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>(); 
        int ans = 0;
        for(int i = 0 ; i < n ; i++)
        {
            if(hm.containsKey(arr[i]))
            {
                ans += hm.get(arr[i]);
            }
            else{
                hs.add(arr[i]);
                int len = hs.size();
                int temp = len%8 == 0 ? 0 : 1; 
                hm.put(arr[i],len/8+temp);
                ans += hm.get(arr[i]);
            }
        }
        // System.out.println(hm);
        // System.out.println(hs);
        return ans;
    }
}