package org.dsa.linkedList;

public class CheckPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        int len = 0;
        ListNode temp=head;
        while(temp != null){
            len++;
            temp=temp.next;
        }

        if(len%2 != 0){
            slow=slow.next;
        }
        ListNode prev = null;
        ListNode curr = slow;
        ListNode nxt;
        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        slow.next=null;

        while(prev != null){
            if(head.val != prev.val){
                return false;
            }
            prev=prev.next;
            head=head.next;
        }
        return true;
    }
}
