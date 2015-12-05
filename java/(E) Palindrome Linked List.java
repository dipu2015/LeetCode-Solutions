/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode pre = slow;
        slow = slow.next;

        ListNode tail = reverseList(slow);
        
        ListNode p1 = head;
        ListNode p2 = tail;
        boolean isPal = true;
        while(p2 != null) {
            if (p1.val != p2.val) {
                isPal = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        
        reverseList(tail);

        return isPal;
    }
    
    private ListNode reverseList(ListNode p) {
        ListNode p1 = p;
        ListNode p2 = p.next;
        while(p2 != null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        p.next = null;
        return p1;
    }
}

