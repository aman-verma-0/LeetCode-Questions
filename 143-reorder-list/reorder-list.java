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
    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null) return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode headOfHalfT=slow.next;
        slow.next=null;
        ListNode newHead=reverse(headOfHalfT);
        ListNode first=head;
        ListNode second=newHead;
        while(second!=null){
            ListNode front1=first.next;
            ListNode front2=second.next;
            first.next=second;
            second.next=front1;
            first=front1;
            second=front2;

        }
        
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode cur=head;
        ListNode prev=null;
        while(cur!=null){
            ListNode front=cur.next;
            cur.next=prev;
            prev=cur;
            cur=front;
        }
        return prev;
    }
}