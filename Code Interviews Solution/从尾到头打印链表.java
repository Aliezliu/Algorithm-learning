/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.*;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> al = new ArrayList<>();
        /*1.Use a Stack
        Stack<Integer> st = new Stack<>();
        while(listNode != null) {
            st.push(listNode.val);
            listNode = listNode.next;
        }
        while(!st.empty()) {
            al.add(st.pop());
        }
        return al;*/
        //2.Use tail recursion
        if(listNode == null)
            return al;
        if(listNode.next != null) 
            al.addAll(this.printListFromTailToHead(listNode.next));
        al.add(listNode.val);
        return al;
        
    }
}