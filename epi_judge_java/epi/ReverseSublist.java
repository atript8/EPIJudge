package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ReverseSublist {
  @EpiTest(testDataFile = "reverse_sublist.tsv")

  public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start, int finish) {

    ListNode<Integer> dummy = new ListNode<>(0, L);
    ListNode<Integer> subListHead = dummy;

    int count = 1;
    while (count < start) {
      subListHead = subListHead.next;
      count++;
    }

    ListNode<Integer> current = subListHead.next;
    while (count < finish) {
      ListNode<Integer> t = current.next;

      current.next = t.next;
      t.next = subListHead.next;
      subListHead.next = t;

      count++;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseSublist.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
