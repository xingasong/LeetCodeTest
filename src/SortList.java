public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return mergeTwoList(left, right);
    }

    private ListNode mergeTwoList(ListNode h1, ListNode h2){
        if(h1 == null) return h2;
        if(h2 == null) return h1;
        if(h1.val < h2.val){
            h1.next = mergeTwoList(h1.next, h2);
            return h1;
        }else{
            h2.next = mergeTwoList(h1, h2.next);
            return h2;
        }
    }

    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
