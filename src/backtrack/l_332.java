package backtrack;

import java.util.*;

public class l_332 {
    public static void main(String[] args) {
        String[][] strs = new String[][]{
                {"JFK", "SFO"},
                {"JFK", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "JFK"},
                {"ATL","SFO"}
        };
        List<List<String>> list = new ArrayList<>();
        for (String[] str : strs) {
            ArrayList<String> tmp = new ArrayList<>(2);
            list.add(tmp);
            tmp.addAll(Arrays.asList(str));
        }
        List<String> itinerary = findItinerary(list);
        System.out.println(Arrays.toString(itinerary.toArray()));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }
        List<String> res = new LinkedList<>();
        dfs(res, map, "JFK");
        return res;
    }

    private static void dfs(List<String> res, HashMap<String, PriorityQueue<String>> map, String cur) {
        PriorityQueue<String> nexts = map.getOrDefault(cur, new PriorityQueue<>());
        while (!nexts.isEmpty()) {
            dfs(res, map, nexts.poll());
        }
        res.add(0, cur);
    }
}
