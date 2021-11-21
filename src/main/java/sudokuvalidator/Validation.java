package sudokuvalidator;

import java.util.Arrays;

public class Validation {

  private Validation() {
    throw new IllegalStateException("Utility class");
  }

  public static boolean validateGroup(Integer[] group) {
    if (group.length != 9) {
      throw new IllegalArgumentException("Invalid group length");
    }

    Arrays.sort(group);
    return Arrays.equals(group, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
  }
}
