/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        RandomListNode newHead = new RandomListNode(head.label);

        Queue<RandomListNode> queue = new LinkedList<RandomListNode>();
        queue.add(head);
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        map.put(head, newHead);

        while(queue.size() > 0) {
            RandomListNode node = queue.remove();
            RandomListNode node2 = map.get(node);
            if (node.next != null) {
                if (!map.containsKey(node.next)) {
                    RandomListNode cn = new RandomListNode(node.next.label);
                    map.put(node.next, cn);
                    node2.next = cn;
                    queue.add(node.next);
                }
                else
                    node2.next = map.get(node.next);
            }
            if (node.random != null) {
                if (!map.containsKey(node.random)) {
                    RandomListNode cn = new RandomListNode(node.random.label);
                    map.put(node.random, cn);
                    node2.random = cn;
                    queue.add(node.random);
                }
                else
                    node2.random = map.get(node.random);
            }
        }
        return newHead;
    }
}
