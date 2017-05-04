/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
		if(head == null || head.next == null)
            return head;
        ListNode p = null, q = head, r;
        while(q.next != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        q.next = p;
        return q;
    }
}