package JAVA;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class computerEnglish {
    private static final ExecutorService ex = Executors.newFixedThreadPool(6);
    private static CountDownLatch countDownLatch;
    private static List<WordRoot> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException, FileNotFoundException, JsonProcessingException {
        int pages = 6;
        countDownLatch = new CountDownLatch(pages);
        for (int i = 1; i <= pages; i++) {
            String text = "https://membean.com/wrotds/archive?page=" + i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Document document = null;
                    try {
                        document = Jsoup.connect(text).get();
                        Elements elements = document.select("#wrotd-archive-container div.archived-wrotd");
                        System.out.println(elements.size());
                        for (Element element : elements) {
                            String title = element.select("h2").text();
                            String sketch = element.select("h3").text();
                            String summary = element.select(".summary").text();

                            String s = summary.replaceAll("<strong>", "").replaceAll("</strong>", "");
                            WordRoot wordRoot = new WordRoot(title, sketch, s);
                            list.add(wordRoot);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                    assert document != null;
                    System.out.println(document.title());
                }
            });
            ex.submit(thread);
        }
        countDownLatch.await();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(list);
//        System.out.println(s);
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("ce.json")), true);
        printWriter.println(s);
        printWriter.close();
        System.out.println(list.size());
        System.out.println("获取完毕！");
        ex.shutdown();
    }

    static class WordRoot {
        private String title;//lig
        private String sketch;
        private String summary;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSketch() {
            return sketch;
        }

        public void setSketch(String sketch) {
            this.sketch = sketch;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public WordRoot() {
        }

        public WordRoot(String title, String sketch, String summary) {
            this.title = title;
            this.sketch = sketch;
            this.summary = summary;
        }
    }

    @Test
    public void test1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,String> map = new HashMap<>();
        map.put("1","one");
        String s = objectMapper.writeValueAsString(map);
        System.out.println(s);
    }
}
