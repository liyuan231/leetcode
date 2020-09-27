package JAVA;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StatisticOfMyScore {
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Document document = Jsoup.parse(new File("C:\\Users\\Administrator\\Desktop\\学生个人考试成绩.html"), "utf-8");
        Elements trs = document.select("#dataList tr");
        for (int i=1;i<trs.size();i++) {
            Elements tds = trs.get(i).select("td");
            String score = tds.get(5).text();
            String nature = tds.get(9).text();
            map.put(nature, map.getOrDefault(nature, 0) + Integer.parseInt(score));
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }
}
