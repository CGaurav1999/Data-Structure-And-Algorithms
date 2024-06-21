package org.dsa.linkedList;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // if(head==null || head.next==null){
        //     return head;
        // }
        // ListNode newHead = reverseList(head.next);
        // head.next.next=head;
        // head.next=null;
        // return newHead;
        ListNode curr = head;
        ListNode prev = null;
        ListNode nxt;

        while(curr != null){
            nxt = curr.next;

            curr.next = prev;
            prev = curr;
            curr=nxt;
        }
        return prev;
    }
}
