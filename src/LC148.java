import java.util.List;

public class LC148 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if(head == null) {
            return head;
        }
        if(head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while(fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if(fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode res = merge(list1, list2);
        return res;
    }

    public ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, l1 = h1, l2 = h2;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }
        if(l1 != null) {
            temp.next = l1;
        }
        if(l2 != null) {
            temp.next = l2;
        }
        return dummyHead.next;
    }
}
