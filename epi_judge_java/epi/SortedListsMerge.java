package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class SortedListsMerge {
    @EpiTest(testDataFile = "sorted_lists_merge.tsv")
    //@include
    public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> f,
                                                        ListNode<Integer> s) {

        ListNode<Integer> dummy = new ListNode<>(0, null);
        ListNode<Integer> current = dummy;

        while (f != null && s != null) {
            if (f.data < s.data) {
                current.next = f;
                f = f.next;
            } else {
                current.next = s;
                s = s.next;
            }
            current = current.next;
        }

        current.next = f == null ? s : f;

        return dummy.next;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SortedListsMerge.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
