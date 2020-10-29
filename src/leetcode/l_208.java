package leetcode;

public class l_208 {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }


    static class Trie {
        private TrieNode root;

        private class TrieNode {
            private boolean isEnd;
            private TrieNode[] trieNodes;

            public TrieNode() {
                this.isEnd = false;
                this.trieNodes = new TrieNode[26];//最多不过26个英文字母
            }
        }

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] chars = word.toCharArray();
            TrieNode cur = root;
            for (char c : chars) {
                int index = c - 'a';
                if (cur.trieNodes[index] == null) {
                    //说明该字符尚未存在于本层对应的树中
                    cur.trieNodes[index] = new TrieNode();
                }
                cur = cur.trieNodes[index];
            }
            //遍历完这个单词后,说明这个单词结束了
            cur.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode cur = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int index = c - 'a';
                if (cur.trieNodes[index] == null) {
                    return false;
                }
                cur = cur.trieNodes[index];
            }
            return cur.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            TrieNode cur = root;
            for (char c : chars) {
                int index = c - 'a';
                if (cur.trieNodes[index] == null) {
                    return false;
                }
                cur = cur.trieNodes[index];
            }
            return true;
        }
    }


}
