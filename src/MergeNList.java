public class MergeNList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==2){
            return mergeTwoLists(lists[0], lists[1]);
        }
        int lo = 0, hi = lists.length-1;
        ListNode[] lists1 = new ListNode[(lists.length+1)/2];
        while(lo<hi){
            lists1[lo] = mergeTwoLists(lists[lo], lists[hi]);
            lo++;
            hi--;
        }
        if(lo==hi) lists1[lists1.length-1] = lists[lo];
        return mergeKLists(lists1);
}

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


}
