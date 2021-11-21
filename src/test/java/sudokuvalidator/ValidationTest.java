package sudokuvalidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class ValidationTest {

  @Test
  public void shouldPassValidation() {
    assertThat(Validation.validateGroup(new Integer[]{2, 5, 6, 3, 9, 8, 1, 4, 7})).isTrue();
  }

  @Test
  public void shouldFailValidation() {
    assertThat(Validation.validateGroup(new Integer[]{2, 5, 6, 9, 9, 8, 1, 4, 7})).isFalse();
  }

  @Test
  public void shouldThrowIllegalArgument() {
    assertThatThrownBy(() -> {
      Validation.validateGroup(new Integer[]{2, 5, 6, 3, 9, 8, 1, 4, 7, 7});
    }).isInstanceOf(IllegalArgumentException.class);
  }
}
