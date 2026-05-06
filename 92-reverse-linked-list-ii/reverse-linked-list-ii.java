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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right) return head;

        ListNode cur=head;
        ListNode beforeLeft=null;
        for(int i=1;i<left;i++){
            beforeLeft=cur;        // this is the node just before the left node
            cur=cur.next;
        }

        ListNode leftNode=cur;   // this is the left node or head of the reversable part
        
        for(int i=left;i<right;i++){
            cur=cur.next;
        }
        ListNode rightNode=cur;
        ListNode nextToRightNode=rightNode.next;
        rightNode.next=null;
        ListNode newHead=reverseList(leftNode);
        if(beforeLeft==null) head=newHead;
        else{
            beforeLeft.next=newHead;
        }
        leftNode.next=nextToRightNode;
        return head;

        
    }
    public ListNode reverseList(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
}