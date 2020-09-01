package leetcode;

public class l_116_ {
    public static void main(String[] args) {
        l_116.Node node = l_116.Node.create();

    }

    public static l_116.Node connect(l_116.Node root) {
        connect(root,null);
        return root;
    }

    private static void connect(l_116.Node node, l_116.Node next) {
        if(node==null){return;}
        node.next=next;
        connect(node.left,node.right);
        connect(node.right,node.next!=null?node.next.left:null);
    }
}
