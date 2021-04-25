package nlp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SSA {
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
        Map<String, List<Element>> elementMap = preConstruct(rules);
        System.out.println(1);
        for (int i = 0; i < words.length; i++) {
            for (int i1 = 0; i1 < words.length; i1++) {
                if(elementMap.get(words[i1]).contains(words[i])){

                }
            }
        }
    }

    private static Map<String, List<Element>> preConstruct(String[] rules) {
        Map<String, List<Element>> map = new HashMap<>();
        for (String rule : rules) {
            String[] kv = rule.split("->");
            String val = kv[0];
            String[] vp = kv[1].split(" {2}");
            String key = vp[0];
            Double prob = Double.valueOf(vp[1]);
            map.computeIfAbsent(key, l -> new ArrayList<>()).add(new Element(val, prob));
        }
        return map;
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
