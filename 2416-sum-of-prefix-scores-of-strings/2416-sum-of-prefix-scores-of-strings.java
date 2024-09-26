class TrieNode{
    TrieNode[] arr = new TrieNode[26];
    int count = 0;
    boolean flag = false;
    public boolean contains(char ch){
        return arr[ch - 'a'] != null;
    }
    public void push(char ch,TrieNode node){
        arr[ch - 'a'] = node;
    }
    public TrieNode getNext(char ch){
        return arr[ch - 'a'];
    }
    // public void set(){
    //     flag = true;
    // }
    // public void End(){
    //     return flag;
    // }
    public void increment(char ch){
        arr[ch - 'a'].count++;
    }
    public int getCount(char ch){
        return arr[ch - 'a'].count;
    }

}
class Trie{
    private TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.contains(ch)){
                node.push(ch,new TrieNode());
            }
            node.increment(ch);
            node = node.getNext(ch);
        }
    }

    public int search(String word){
        TrieNode node = root;
        int prefixCount = 0;
        for(char ch: word.toCharArray()){
            prefixCount += node.getCount(ch);
            node = node.getNext(ch);
        }
        return prefixCount;
    }
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }
        int n = words.length;
        int[] res = new int[n];
        for(int i = 0 ; i < n ; i++){
            res[i] = trie.search(words[i]);
        }
        return res;
    }
}