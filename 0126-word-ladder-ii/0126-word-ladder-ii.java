
class Solution {
    HashMap<String,Integer> hm = new HashMap<>();
    public List<List<String>> findLadders(String startWord, String targetWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        for(String word : wordList){
            hs.add(word);
        }
        Queue<String> q = new LinkedList<>();
        q.offer(startWord);
        hm.put(startWord,1);
        hs.remove(startWord);
        while(!q.isEmpty()){
            String word = q.poll();
            int level = hm.get(word);
            StringBuilder sb = new StringBuilder(word);
            int n = word.length();
            for(int i = 0 ; i < n ; i++){
                char original = sb.charAt(i);
                for(int j = 0 ; j < 26 ; j++){
                    sb.setCharAt(i,(char)(j+'a'));
                    if(hs.contains(sb.toString())){
                        String temp = sb.toString();
                        q.add(temp);
                        hm.put(temp,level+1);
                        hs.remove(temp);
                    }
                    
                }
                sb.setCharAt(i,original);
            }
        }
        if(hm.containsKey(targetWord)){
            List<String> sequence = new ArrayList<>();
            sequence.add(targetWord);
            
            dfs(ans,sequence,startWord,targetWord);
        }
        return ans;
    }
    public void dfs(List<List<String>> ans,List<String> sequence,String startWord,String word){
        if(word.equals(startWord)){
            Collections.reverse(sequence);
            ans.add(new ArrayList<>(sequence));
            return;
        }
        int level = hm.get(word);
        // System.out.println(sequence + " " + level);
        StringBuilder sb = new StringBuilder(word);
        int n = word.length();
        for(int i = 0 ; i < n ; i++){
            char original = sb.charAt(i);
            for(int j = 0 ; j < 26 ; j++){
                sb.setCharAt(i,(char)(j+'a'));
                String temp = sb.toString();
                if(hm.containsKey(temp) && hm.get(temp) == level - 1){
                    List<String> newSeq = new ArrayList<>(sequence);
                    newSeq.add(temp);
                    dfs(ans,newSeq,startWord,temp);
                }
            }
            sb.setCharAt(i,original);
        }
    }
}