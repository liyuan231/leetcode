package nowcoder;

public class cyc_41_1 {
    Node root = new Node(-1);
    int N = 0;

    private static class Node {
        Node next;
        Double val;

        public Node(double val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        cyc_41_1 cyc_41_1 = new cyc_41_1();
//        for (int i = 0; i < 100; i++) {
//            cyc_41_1.Insert((int) (Math.random() * 100));
        cyc_41_1.Insert(1);
        cyc_41_1.Insert(2);
        cyc_41_1.Insert(3);
        cyc_41_1.Insert(4);
        System.out.println(cyc_41_1.GetMedian());
//        }
    }


    public void Insert(Integer num) {
        N++;
        Node p = root;
        while (p.next != null && p.next.val < num) {
//            int val = tmp.val;
            p = p.next;
        }
        Node tmp = new Node(num);
        tmp.next = p.next;
        p.next = tmp;
    }

    public Double GetMedian() {
        Node p = root.next;
        for (int i = 0; i < N / 2 - 1; i++) {
            p = p.next;
        }
        return N % 2 == 0 ? (p.val + p.next.val) / 2 : (p.next==null?p.val:p.next.val);
    }


}
