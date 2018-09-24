import java.util.Scanner;

public class Leet144 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode h = new ListNode(in.nextInt());
        ListNode p = h;
        while (in.hasNextInt()) {
            ListNode cur = new ListNode(in.nextInt());
            p.next = cur;
            p = p.next;
        }
        ListNode j=sortList(h);
        while (j != null) {
            System.out.println("node = " + j.val);
            j = j.next;
        }
    }

    private static ListNode sortList(ListNode h) {
        if (h == null || h.next == null) {
            return h;
        }
        ListNode prev = null, slow = h, fast = h;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;//中间截断

        // step 2. sort each half
        ListNode l1 = sortList(h);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);

    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode l=null;
        if(l1!=null&&l2!=null){
            if (l1.val < l2.val) {
                l=l1;
                l.next=merge(l2,l1.next);
            } else {
                l=l2;
                l.next=merge(l1,l2.next);
            }
        } else if (l1!=null){
            l=l1;
        } else if(l2!=null){
            l=l2;
        }
        return l;
    }


}
