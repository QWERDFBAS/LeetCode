import org.junit.Test;

import java.util.List;

public class LC328 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    @Test
    public void test() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        System.out.println(list);
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode odd = head.next;
        ListNode even = head;
        ListNode begin = odd;
        while(odd.next != null && even.next != null) {
            even.next = odd.next;
            even = odd.next;
            odd.next = even.next;
            odd = even.next;
        }
        even.next = begin;
        return head;
    }
}
