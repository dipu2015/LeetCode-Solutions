/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
            
        ListNode start = head;
        ListNode end = head;
        ListNode newHead = null;
        ListNode lastEnd = null;
        
        while(true) {
            int step = 1;
            while(end != null && (step++) < k)
                end = end.next;

            if (end == null)
                break;
            ListNode nextStart = end.next;

            ListNode p1 = start;
            ListNode p2 = start.next;
            while(true) {
                ListNode temp = p2.next;
                p2.next = p1;
                if (p2 == end)
                    break;
                p1 = p2;
                p2 = temp;
            }
            
            if (newHead == null)
                newHead = end;
            
            if (lastEnd != null)
                lastEnd.next = end;
            lastEnd = start;
            
            start.next = nextStart;
            if (nextStart == null)
                break;
            
            start = nextStart;
            end = nextStart;
        }
        
        return (newHead != null) ? newHead : head;
    }
}
