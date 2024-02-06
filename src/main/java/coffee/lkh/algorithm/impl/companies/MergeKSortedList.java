package coffee.lkh.algorithm.impl.companies;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.Map;
import java.util.PriorityQueue;

public class MergeKSortedList extends DetailedAlgorithmBase {

    private static final String LISTS = "lists";

    @Override
    public Map<String, Object> process(Map<String, Object> params) {
        if (!isParametersValid(params)) {
            throw new RuntimeException("Parameters are not valid!");
        }
        final ListNode[] lists = (ListNode[]) params.get(LISTS);
        params.put("result", mergeKLists(lists));
        return params;
    }

    @Override
    protected boolean isParametersValid(Map<String, Object> params) {
        return params.containsKey(LISTS) && params.get(LISTS) instanceof ListNode[];
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // PriorityQueue is used as a min heap where the node with the smallest value is at the top
        final PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add head nodes of all non-empty lists into the PriorityQueue
        for (ListNode node : lists) {
            if (node != null)
                queue.add(node);
        }

        // Dummy head node
        final ListNode head = new ListNode(0);
        // Pointer to the current node
        ListNode temp = head;

        // Continue till queue is empty
        while (!queue.isEmpty()) {
            // Get the node with smallest value
            temp.next = queue.poll();
            temp = temp.next;

            // Add next node of the list from which a node has been processed
            if (temp.next != null)
                queue.add(temp.next);
        }

        // Return the dummy head's next which is the start of the merged list
        return head.next;
    }

    public ListNode mergeLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0); // Dummy head
        ListNode tail = dummy; // Pointer to form the new list

        while (true) {
            int minNodeIndex = findMinNodeIndex(lists); // Find smallest node
            if (minNodeIndex == -1) {
                break;
            } // No more nodes to process

            // Add smallest node to new list and move its pointer forward
            tail.next = lists[minNodeIndex];
            tail = tail.next;
            lists[minNodeIndex] = lists[minNodeIndex].next;
        }

        return dummy.next; // Exclude the dummy head
    }

    private int findMinNodeIndex(ListNode[] lists) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;

        // Find index of list that has smallest node
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < minValue) {
                minIndex = i;
                minValue = lists[i].val;
            }
        }

        return minIndex;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        } // ListNode constructor

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        } // ListNode constructor with next node

        public int getVal() {
            return val;
        }

        public ListNode getNext() {
            return next;
        }
    }
}

