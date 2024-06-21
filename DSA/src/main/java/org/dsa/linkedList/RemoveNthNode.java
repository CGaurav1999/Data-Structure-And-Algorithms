package org.dsa.linkedList;

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp=temp.next;
        }
        if(len<n){
            return head;
        }
        if(len==n){
            return head.next;
        }

        temp = head;
        int cnt = len-n;

        while(cnt != 1){
            temp = temp.next;
            cnt--;
        }
        if(temp.next != null)
            temp.next = temp.next.next;

        return head;
    }
}
