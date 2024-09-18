class Node {
    private Node[] array = new Node[26];
    private boolean flag = false;

    public boolean contains(char ch) {
        return array[ch - 'a'] != null;
    }

    public void put(char ch, Node node) {
        array[ch - 'a'] = node;
    }

    public Node getNext(char ch) {
        return array[ch - 'a'];
    }

    public void setFlag() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}

class Solution {
    private Node root = new Node();
    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.contains(ch)) {
                node.put(ch, new Node());
            }
            node = node.getNext(ch);
        }
        node.setFlag();
    }
    public int search(String word, int j) {
        Node node = root;
        int len = 0;
        for (int i = j; i < word.length(); i++) {
            if (!node.contains(word.charAt(i))) {
                return len;
            }
            len++;
            node = node.getNext(word.charAt(i));
        }
        return len;
    }
    public int minValidStrings(String[] words, String target) {
        int n = target.length();

        for (String word : words) {
            insert(word);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            int j = i;
            int len = search(target, j);
            while (len-- > 0 && j < n) {
                dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
                j++;
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}
