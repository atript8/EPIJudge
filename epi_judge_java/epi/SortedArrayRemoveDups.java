package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

import java.util.List;
public class SortedArrayRemoveDups {
  // Returns the number of valid entries after deletion.
  public static int deleteDuplicates(List<Integer> list) {
    if (list.size() == 0) return 0;

    int lastUnique = 0;
    //System.out.println(list);
    for (int i = 1; i < list.size(); i++) {
      if (!list.get(lastUnique).equals(list.get(i))) {
        lastUnique++;
        if (lastUnique != i)
          list.add(lastUnique, list.get(i));
      }
    }

    for (int i = lastUnique+1; i < list.size(); i++) {
      list.set(i, 0);
    }

    //System.out.println(list);
    return lastUnique + 1;
  }

  @EpiTest(testDataFile = "sorted_array_remove_dups.tsv")
  public static List<Integer> deleteDuplicatesWrapper(TimedExecutor executor,
                                                      List<Integer> A)
      throws Exception {
    int end = executor.run(() -> deleteDuplicates(A));
    return A.subList(0, end);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedArrayRemoveDups.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
