package org.dsa.linkedList;

public class CIntersectionPoint {
    public int length(ListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = length(headA);
        int len2 = length(headB);
        int diff = 0;
        if(len1>len2){
            ListNode temp = headA;
            headA = headB;
            headB = temp;
            diff = len1-len2;
        }else{
            diff = len2-len1;
        }
        while(diff != 0){
            headB = headB.next;
            diff--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headB;
    }
}
