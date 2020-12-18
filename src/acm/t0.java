package acm;

import java.util.Scanner;

public class t0 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String src = "abcdERFGTYHTasdfQWERTYUIgggHHHHHHHHHq";
         src=input.nextLine();
        int end = src.length() - 1;
        int count = 0 ,i;
        for ( i = src.length() - 1; i >= 0; i--) {
            if (src.charAt(i) >= 'A' && src.charAt(i) <= 'Z') {
                count++;
            } else {
                if (count == 8) {
                    System.out.println(src.substring(i + 1, end));
                    count = 0;
                    break;
                }
                count = 0;
                end = i;
            }
        }
        if(count==8){
            System.out.println(src.substring(i+1, end+1));
        }
    }

}
