/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
		if(head == null || k <= 0)
            return null;
        ListNode tmp = head;
        int len = 0;
        while(tmp != null) {
            tmp = tmp.next;
            len++;
        }
        if ( k > len)
            return null;
        int index = 0;
        int pivot = len - k;
        tmp = head;
        while(index != pivot) {
            tmp = tmp.next;
            index++;
        }
        return tmp;
    }
}