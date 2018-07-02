public class RemoveNthFEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy.next;
        while(n > 0) {
            fast = fast.next;
            n--;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
