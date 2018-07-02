public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = dummy;
        for(int i=0; i<k; i++){
            tmp = tmp.next;
            if(tmp == null) return head;
        }
        ListNode newHead = tmp.next;
        tmp.next = null;
        ListNode prev = null;
        while(head !=null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        dummy.next.next = reverseKGroup(newHead, k);
        return prev;
    }
}
