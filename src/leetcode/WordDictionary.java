package leetcode;

public class WordDictionary {

    private TrieNode root;

    private static class TrieNode {
        private TrieNode[] trieNodes;
        private boolean isEnd;

        public TrieNode() {
            this.trieNodes = new TrieNode[26];
            this.isEnd = false;
        }
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (char c : chars) {
            int index = c - 97;
            if (cur.trieNodes[index] == null) {
                cur.trieNodes[index] = new TrieNode();
            }
            cur = cur.trieNodes[index];

        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return search(word,0, root);
    }

    public boolean search(String word,int start, TrieNode root) {
        TrieNode cur = root;
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode ignored : cur.trieNodes) {
                    if (ignored != null && search(word,i+1, ignored)) {
                        return true;
                    }
                }
                return false;
            } else {
                int index =c - 97;
                if (cur.trieNodes[index] == null) {
                    return false;
                }
                cur = cur.trieNodes[index];
            }
        }
        return cur.isEnd;
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");

//        System.out.println(wordDictionary.search("a"));
//        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");

//        System.out.println(wordDictionary.search(".at"));
//        System.out.println(wordDictionary.search("an."));
//        System.out.println(wordDictionary.search("a.d."));
//        System.out.println(wordDictionary.search("b."));
//        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));

    }

}
