package org.dsa.linkedList;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp = head;
        ListNode tail=null;
        while(temp != null){
            if(temp.next==null){
                tail=temp;
            }
            temp=temp.next;
            len++;
        }
        k = k%len;
        if(k==0){
            return head;
        }
        temp=head;
        int cnt=len-k;
        while(cnt!=1){
            temp=temp.next;
            cnt--;
        }
        tail.next=head;
        head=temp.next;
        temp.next=null;
        return head;

    }
}
