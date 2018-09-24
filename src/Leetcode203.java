import java.util.Scanner;

public class Leetcode203 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 2;
        ListNode h = new ListNode(in.nextInt());
        ListNode p = h;
        while (in.hasNextInt()) {
            ListNode cur = new ListNode(in.nextInt());
            p.next = cur;
            p = p.next;
        }
        ListNode ans = removeElement(h, a);
        while (ans != null) {
            System.out.println("node = " + ans.val);
            ans = ans.next;
        }
    }

    private static ListNode removeElement(ListNode h, int a) {
        ListNode pre = null, res = h, cur = h;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val == a) {
                if (cur == h) {
                    res = next;
                    while(res!=null&&res.val==a){
                        res=res.next;
                    }
                   if(res==null)  return null;
                }
                if (pre != null) {
                    pre.next = next;
                }
            } else {
                pre = cur;
            }
            cur = next;

        }
        return res;
    }
}
