package huawei;

import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class huaiwei_triem {
    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
//        threadPoolExecutor.submit()
        Trie trie = new Trie();
        String[] strs = new String[]{"l", "la", "lb", "lc", "ld", "le"};
        for (int i = 0; i < strs.length; i++) {
            trie.insert(strs[i]);
        }
        travsel(new ArrayList<>(), trie.root, 2, 0);

        InputStreamReader inputStreamReader = new InputStreamReader(new BufferedInputStream(System.in));
        float x = 0.0f;
//        System.out.println((x==0f));
    }

    /**
     * »ØËÝ
     *
     * @param es
     * @param root
     * @param depth
     * @param curDepth
     */
    private static void travsel(ArrayList<Character> es, Trie.TrieNode root, int depth, int curDepth) {
        if (root == null) {
            return;
        }
        if (depth == curDepth) {
            System.out.println(Arrays.toString(es.toArray()));
//            return;
        }
        for (int i = 0; i < root.trieNodes.length; i++) {
            if (root.trieNodes[i] != null) {
                es.add((char) (i + 'a'));
                travsel(es, root.trieNodes[i], depth, curDepth + 1);
                es.remove(es.size() - 1);
            }
        }
    }

    private static class Trie {
        private TrieNode root;

        private class TrieNode {
            boolean isEnd;
            private TrieNode[] trieNodes;

            public TrieNode() {
                this.isEnd = false;
                this.trieNodes = new TrieNode[26];
            }
        }

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (cur.trieNodes[index] == null) {
                    cur.trieNodes[index] = new TrieNode();
                }
                cur = cur.trieNodes[index];
            }
            cur.isEnd = true;
        }
    }
}
