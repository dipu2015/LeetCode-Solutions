/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode last = null;
        boolean carry = false;
        while(l1!=null || l2!=null) {
            int value = carry ? 1:0;
            if (l1 != null)
                value += l1.val;
            if (l2 != null)
                value += l2.val;

            if (value >= 10) {
                value = value - 10;
                carry = true;
            }
            else
                carry = false;

            ListNode node = new ListNode(value);
            if (head == null)
                head = node;
            else
                last.next = node;
            last = node;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry) {
            ListNode node = new ListNode(1);
            last.next = node;
        }
        
        return head;
    }
}
