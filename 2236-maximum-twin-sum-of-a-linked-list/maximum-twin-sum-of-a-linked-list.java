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
    public int pairSum(ListNode head) {
        int maxSum=0;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode middle=slow.next;
        slow.next=null;
        ListNode secondHead=reverseList(middle);
        while(head!=null){
            maxSum=Math.max(maxSum,head.val+secondHead.val);
            head=head.next;
            secondHead=secondHead.next;
        }
        return maxSum;
        

        
    }
    public ListNode reverseList(ListNode head){
        ListNode cur=head;
        ListNode prev=null;
        while(cur!=null){
            ListNode newNode=cur.next;
            cur.next=prev;
            prev=cur;
            cur=newNode;
        }
        return prev;
    }
}