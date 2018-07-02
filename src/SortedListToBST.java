public class SortedListToBST {
    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode mid[] = findMid(head);
        TreeNode root = new TreeNode(mid[1].val);
        root.right = sortedListToBST(mid[1].next);
        mid[0].next = null;
        if(mid[1] != head) {
            root.left = sortedListToBST(head);
        }
        return root;
    }

    private static ListNode[] findMid(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            dummy = dummy.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode[] mid = {dummy, slow};
        return mid;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(3);
        a.next = new ListNode(5);
        a.next.next = new ListNode(8);
        TreeNode b = sortedListToBST(a);
        System.out.println(b.left.val);
    }
}
