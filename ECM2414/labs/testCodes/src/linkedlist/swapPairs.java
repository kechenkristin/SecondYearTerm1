package linkedlist;


class SwapPairs {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode sential = new ListNode(-999, head);

        int index = 0;
        ListNode pre = sential;
        ListNode ptr = sential.next;

        while (ptr != null) {
            if (index != 0 && index % 2 == 0) {
                pre.next = ptr.next;
                ptr.next = pre;
            }
            ptr = ptr.next;
            pre = ptr;
            index++;
        }

        return sential.next;
    }

    public static void main(String[] args) {
        ListNode test4 = new ListNode(4);
        ListNode test3 = new ListNode(3, test4);
        ListNode test2 = new ListNode(2, test3);
        ListNode test1 = new ListNode(1, test2);

        ListNode result = swapPairs(test1);
    }


}


