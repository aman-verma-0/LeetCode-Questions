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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        int prevIdx=-100000;
        int minDist=Integer.MAX_VALUE;
        if(len<=2) return new int[]{-1,-1};
        ListNode cur=head.next;
        List<Integer> list=new ArrayList<>();
        int prev=head.val;
        int i=0;
        while(i<len-2){
            int curVal=cur.val;
            if(curVal<prev && curVal<cur.next.val){
                minDist=Math.min(minDist,i-prevIdx);
                prevIdx=i;
                list.add(i);
                
            }
            if(curVal>prev && curVal>cur.next.val) {
                minDist=Math.min(minDist,i-prevIdx);
                list.add(i);
                prevIdx=i;
            }
            prev=curVal;
            cur=cur.next;
            i++;

        }
        if(list.size()<=1) return new int[]{-1,-1};
        int maxDist=list.get(list.size()-1)-list.get(0);
        return new int[]{minDist,maxDist};
        
    }
}