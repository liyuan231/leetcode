package leetcode;

import java.util.Stack;

public class l_71 {
    public static void main(String[] args) {
        String path = "/../ss";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        Stack<String> stringStack = new Stack<>();
        String[] strings = path.split("/");
//        for (int i = 0; i < strings.length; i++) {
//            System.out.println(strings[i]);
//        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("..") && !stringStack.isEmpty()) {
                stringStack.pop();
            } else if (strings[i].equals(".")||strings[i].equals("")) {
            } else {
                stringStack.push(strings[i]);
            }
        }
//        if(stringStack.peek().equals("..")||stringStack.peek().equals(".")){stringStack.pop();}
//        if(stringStack.isEmpty()){return "/";}
        StringBuilder result = new StringBuilder();
        int index=0;
        for(index=0;index<stringStack.size();index++){
            String tmp = stringStack.get(index);
            if(!tmp.equals("..")){
                result.append("/"+tmp);
            }
        }
        String ans =result.toString();
        return ans.equals("")?"/":ans;
    }
}
