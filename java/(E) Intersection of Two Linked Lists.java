/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        
        // make the tail of ListA point to headB
        ListNode n = headA;
        while(n.next != null)
            n = n.next;
        n.next = headB;

        // check circle with two pointers
        ListNode n1 = headA;
        ListNode n2 = headA;
        boolean hasCircle = false;
        while(n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
            if (n1 == n2) {
                hasCircle = true;
                break;
            }
        }
        if (!hasCircle) {
            n.next = null;
            return null;
        }
        
        // find the intersection node
        n1 = headA;
        while(n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        // restore the original structure        
        n.next = null;

        return n2;
    }
}
