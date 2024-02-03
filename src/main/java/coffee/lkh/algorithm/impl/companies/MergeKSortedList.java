package coffee.lkh.algorithm.impl.companies;

import coffee.lkh.algorithm.abstractions.DetailedAlgorithmBase;

import java.util.*;

public class MergeKSortedList extends DetailedAlgorithmBase {

    private static final String LISTS = "lists";

    @Override
    public Map<String, Object> process(Map<String, Object> params) {
        if(!isParametersValid(params)){
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
    public static class ListNode {
        int val;
        ListNode next;
        public int getVal() {
            return val;
        }

        public ListNode getNext() {
            return next;
        }
        public ListNode() {}
        public ListNode(int val) { this.val = val; } // ListNode constructor
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; } // ListNode constructor with next node
    }

    public ListNode mergeKLists(ListNode[] lists) {
        final ListNode head = new ListNode(0); // Initialize a placeholder ListNode to serve as the start of the returned list
        ListNode current = head; // Initialize current to point to head

        boolean isAllNull;

        do {
            isAllNull = true;

            //Loop over all the lists
            for(int i = 0; i<lists.length; i++ ) {
                //If this list still has a node
                if(lists[i]!=null) {
                    // Link the current node to the node from list[i]
                    current.next = lists[i];

                    // Move current to its next node
                    current = current.next;

                    // Move to the next node in the current list
                    lists[i] = lists[i].next;

                    // At least one list still has a node
                    isAllNull = false;
                }
            }

        } while(!isAllNull);

        return head.next; // The first node in the merged list
    }
}
