# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if k==1:
            return head
            
        if head is None:
            return None
            
        p1 = head
        p2 = head
        cnt = 0

        new_head = None
        last_end = None
        while not p2 is None:
            cnt +=1
            if cnt==k:
                temp = p2.next
                self.reverseSublist(p1,p2)
                p1.next = temp
                if not new_head:
                    new_head = p2
                if last_end:
                    last_end.next = p2
                last_end = p1
                
                p1 = temp
                p2 = temp
                cnt = 0
            else:
                p2 = p2.next
    
        return new_head if new_head else head
    
    def reverseSublist(self,head,tail):
        if tail == head:
            return head
        p1 = head
        p2 = head.next
        while True:
            temp = p2.next
            p2.next = p1
            
            p1 = p2
            if p2 is tail:
                break

            p2 = temp
