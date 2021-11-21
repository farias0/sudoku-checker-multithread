package sudokuvalidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.Test;

public class InputReaderTest {

  private static final String GRID_VALID_INPUT = "0 1 2 3 4 5 6 7 8\n"
                                                + "1 0 2 3 4 5 6 7 8\n"
                                                + "0 1 2 3 4 5 6 7 8\n"
                                                + "0 1 2 3 4 5 6 7 8\n"
                                                + "0 1 2 3 4 5 6 7 8\n"
                                                + "0 1 2 3 4 5 6 7 8\n"
                                                + "0 1 2 3 4 5 6 7 8\n"
                                                + "0 1 2 3 4 7 6 7 8\n"
                                                + "0 1 2 3 4 5 6 7 8";

  @Test
  public void shouldProcessAGridInput() {
    assertThat(InputReader.processGridInput(GRID_VALID_INPUT)).isEqualTo(new Integer[][]{
        new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 },
        new Integer[]{ 1, 0, 2, 3, 4, 5, 6, 7, 8 },
        new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 },
        new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 },
        new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 },
        new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 },
        new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 },
        new Integer[]{ 0, 1, 2, 3, 4, 7, 6, 7, 8 },
        new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 },
    });
  }

  @Test
  public void shouldProcessAGridInputWithExtraData() {
    var input = GRID_VALID_INPUT + "\n1 2 3 4 5 6 7 8 9\niaosdjioasdj\noiasjdioasdi\n";

    assertThat(InputReader.processGridInput(input)).isEqualTo(new Integer[][]{
        new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 },
        new Integer[]{ 1, 0, 2, 3, 4, 5, 6, 7, 8 },
        new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 },
        new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 },
        new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 },
        new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 },
        new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 },
        new Integer[]{ 0, 1, 2, 3, 4, 7, 6, 7, 8 },
        new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8 },
    });
  }

  private void testForIllegalArgument(String input) {
    assertThatThrownBy(() -> InputReader.processGridInput(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void shouldThrowIllegalArgumentForInvalidGridHeight() {
    var lines = Arrays.copyOfRange(GRID_VALID_INPUT.split("\n"), 0, 8);
    var input = String.join("\n", lines);

    testForIllegalArgument(input);
  }

  @Test
  public void shouldThrowIllegalArgumentForInvalidGridWidth() {
    var input = GRID_VALID_INPUT + " 9";

    testForIllegalArgument(input);
  }

  @Test
  public void shouldThrowIllegalArgumentForInvalidGridInputChar() {
    var input = GRID_VALID_INPUT.replace('0', 'a');

    testForIllegalArgument(input);
  }
}
