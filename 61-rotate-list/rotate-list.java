/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int length=1;
        ListNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
            length++;
        }
        temp.next=head;             //make it circular
        k=k%length;
        int lenTotail=length-k;      //find the length of breakpoint
        ListNode newTail=head;
        for(int i=0;i<lenTotail-1;i++){
            newTail=newTail.next;
        }
        ListNode newHead=newTail.next;   //set new head
        newTail.next=null;               //set tail
        return newHead;
    }
}