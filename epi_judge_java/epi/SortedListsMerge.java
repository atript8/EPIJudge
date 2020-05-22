package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SortedListsMerge {
  @EpiTest(testDataFile = "sorted_lists_merge.tsv")
  //@include
  public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> f,
                                                      ListNode<Integer> s) {

    if (f == null) {
      if (s == null) return null;
      else return s;
    } else {
      if (s == null) return f;
    }

    var head = f;
    ListNode<Integer> p = null;
    while (f != null && s != null) {
      if (f.data < s.data) {
        p = f;
        f = f.next;
      } else {
        ListNode next = s.next;
        if (p == null)
          head = s;
        else
          p.next = s;
        p = s;
        p.next = f;
        s = next;
      }

      if (f == null) {
        p.next = s;
        break;
      }

      if (s == null) {
        break;
      }
    }

    return head;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedListsMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
