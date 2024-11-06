package org.dsa.linkedList;

public class ReverseKNodesInGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = null;
        int count = k;
        int len = 0;
        ListNode c = head;
        while(c != null){
            len++;
            c = c.next;
        }
        if(len<k){
            return head;
        }
        while(curr != null && count != 0){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            count--;
        }
        if(nxt != null){
            head.next = reverseKGroup(nxt,k);
        }
        return prev;
    }
}
