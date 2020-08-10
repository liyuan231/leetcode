package JVM;

import java.io.*;

public class StringTest2 {
    public static void main(String[] args) throws IOException {
       BufferedReader bufferedReader = new BufferedReader(new FileReader("words.txt"));
       String line;
       long start = System.currentTimeMillis();
       while ((line=bufferedReader.readLine())!=null){
           System.out.println(line+":"+line.intern());
       }
       long end = System.currentTimeMillis();
        System.out.println("花费的时间为："+(end-start));
//        StringBuilder
    }
}
