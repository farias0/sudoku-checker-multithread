package sudokuvalidator;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class Validator implements Callable<Boolean> {

  private final Integer[] group;

  public Validator(Integer[] group) {
    this.group = group;
  }

  @Override
  public Boolean call() {
    return validateGroup(this.group);
  }

  static boolean validateGroup(Integer[] group) {
    if (group.length != 9) {
      throw new IllegalArgumentException("Invalid group length");
    }

    Arrays.sort(group);
    return Arrays.equals(group, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
  }
}
