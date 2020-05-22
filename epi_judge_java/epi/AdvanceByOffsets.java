package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class AdvanceByOffsets {
  @EpiTest(testDataFile = "advance_by_offsets.tsv")
  public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
    int furthestReach = 0, lastIndex = maxAdvanceSteps.size()-1;
    for (int i = 0; i <= furthestReach && i <= lastIndex; i++) {
      furthestReach = Math.max(furthestReach, i+ maxAdvanceSteps.get(i));
    }

    return furthestReach >= lastIndex;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "AdvanceByOffsets.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
