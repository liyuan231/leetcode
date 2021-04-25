package nlp;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计句子结构分析
 */
public class SentenceStructureAnalysis {

    public static void main(String[] args) {
        String s = "the boy saw the dog with a telescope";
        String[] rules = new String[]{
                "S->NP VP  1.0",
                "VP->Vi  0.3",
                "VP->Vt NP  0.4",
                "VP->VP PP  0.3",
                "NP->DT NN  0.8",
                "NP->NP PP  0.2",
                "PP->IN NP  1.0",
                "Vi->sleeps  1.0",
                "Vt->saw  1.0",
                "NN->boy  0.1",
                "NN->girl  0.1",
                "NN->telescope  0.3",
                "NN->dog  0.5",
                "DT->the  0.5",
                "DT->a  0.5",
                "IN->with  0.6",
                "IN->in  0.4"
        };
        s = "fish people fish tanks";
        rules = new String[]{
                "S->NP VP  0.9",
                "S->VP  0.1",
                "VP->V NP  0.5",
                "VP->V  0.1",
                "VP->V @VP_V  0.3",
                "VP->V PP  0.1",
                "@VP_V->NP PP  1.0",
                "NP->NP NP  0.1",
                "NP->NP PP  0.2",
                "NP->N  0.7",
                "PP->P NP  1.0",
                "N->people  0.5",
                "N->fish  0.2",
                "N->tanks  0.2",
                "N->rods  0.1",
                "V->people  0.1",
                "V->fish  0.6",
                "V->tanks  0.3",
                "P->with  1.0"
        };
//        s = "he met jenny with flowers";
//        rules = new String[]{
//                "S->NP VP  1.0",
//                "PP->P NP  1.0",
//                "VP->V NP  0.65",
//                "VP->VP PP  0.35",
//                "P->with  1.0",
//                "V->met  1.0",
//                "NP->NP PP  0.4",
//                "NP->he  0.2",
//                "NP->jenny  0.06",
//                "NP->flowers  0.16",
//                "NP->books  0.18"
//        };

        String[] words = s.split(" ");
        Element[][] elements = new Element[words.length][];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = new Element[elements.length];
        }
        Map<String, Element> elementMap = preConstruct(rules);
//        for (int i = 0; i < words.length; i++) {
//            elements[i][i] = elementMap.get(words[i]);
//        }
        //应该斜着遍历
        int limit = words.length;
        int row = 0, col = 0;
        int i = 0, j = 0;
        int color = 1;
        Info[][] m = new Info[words.length][words.length];
        while (limit != 0) {
//            System.out.print("(" + i + "," + j + ") ");
            if (i == j) {
                elements[i][j] = elementMap.get(words[i]);
            } else {
                solve(elementMap, i, j, elements, m, color, words);
            }
            i++;
            j++;
            if (i == limit) {
//                System.out.println();
                i = row;
                j = ++col;
                limit--;
                color++;
            }
        }
        for (int i1 = 0; i1 < m.length; i1++) {
            for (int i2 = 0; i2 < m[i1].length; i2++) {
                if (m[i1][i2] != null) {
                    System.out.printf("%-20s", m[i1][i2]);
                } else {
                    for (int k = 0; k < 10; k++) {
                        System.out.printf(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    private static void solve(Map<String, Element> elementMap, int i, int j, Element[][] elements, Info[][] m, int color, String[] words) {
        Element target = null;
        int ti1 = 0, ti2 = 0, tj1 = 0, tj2 = 0;
        for (int k = i; k <= j - 1; k++) {
            Element e1 = elements[i][k];
            for (int l = i + 1; l <= j; l++) {
                Element e2 = elements[l][j];
                if (e1 != null && e2 != null) {
                    String key = e1.val + " " + e2.val;
                    Element element = elementMap.get(key);
                    if (element != null) {
                        double pro = e1.prob * e2.prob * element.prob;
                        Element e = new Element(element.val, pro);
                        if (target == null || target.prob > e.prob) {
                            target = e;
                            ti1 = i;
                            ti2 = k;
                            tj1 = l;
                            tj2 = j;
                        }
                    }
                }
            }
        }

        if (target != null) {
            m[ti1][ti2] = new Info(i, j, "", elements[ti1][ti2].val);
            if (ti1 == ti2) {
                m[ti1][ti2].word = words[ti2];
            }
            m[tj1][tj2] = new Info(i, j, "", elements[tj1][tj2].val);
            if (tj1 == tj2) {
                m[tj1][tj2].word = words[tj2];
            }
            m[i][j] = new Info();
        }
        elements[i][j] = target;
    }

    private static Map<String, Element> preConstruct(String[] rules) {
        Map<String, Element> map = new HashMap<>();
        for (String rule : rules) {
            String[] kv = rule.split("->");
            String val = kv[0];
            String[] vp = kv[1].split(" {2}");
            String key = vp[0];
            Double prob = Double.valueOf(vp[1]);
            map.put(key, new Element(val, prob));
        }
        return map;
    }

    private static class Info {
        int nextX;
        int nextY;
        String word;
        String nature;

        public Info(int nextX, int nextY, String word, String nature) {
            this.nextX = nextX;
            this.nextY = nextY;
            this.word = word;
            this.nature = nature;
        }

        public Info(int nextX, int nextY, String nature) {
            this.nextX = nextX;
            this.nextY = nextY;
            this.nature = nature;
        }

        public Info() {
        }

        @Override
        public String toString() {
            return word + "[" + nature + "(" + nextX + "," + nextY + ")]";
        }
    }

    private static class Element {
        String val;
        Double prob;

        public Element(String val, Double prob) {
            this.val = val;
            this.prob = prob;
        }
    }
}
