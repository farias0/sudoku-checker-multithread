package sudokuvalidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;

public class GridTest {

  private static final Grid grid = new Grid(new Integer[][]{
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 5, 6, 3, 9, 8, 1, 4, 7, 2 },
        new Integer[]{ 2, 5, 4, 3, 9, 8, 1, 6, 7 },
        new Integer[]{ 2, 5, 6, 8, 9, 3, 1, 4, 7 },
        new Integer[]{ 9, 5, 6, 3, 2, 8, 1, 4, 7 },
        new Integer[]{ 8, 5, 6, 3, 9, 2, 1, 4, 7 },
        new Integer[]{ 2, 1, 6, 3, 9, 8, 5, 4, 7 },
        new Integer[]{ 2, 5, 6, 7, 9, 8, 1, 4, 3 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
  });

  @Test
  public void shouldThrowIllegalArgumentForInvalidGridWidth() {
    assertThatThrownBy(() -> new Grid(new Integer[][]{
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
    })).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void shouldThrowIllegalArgumentForInvalidGridHeight() {
    assertThatThrownBy(() -> new Grid(new Integer[][]{
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
        new Integer[]{ 2, 5, 6, 3, 9, 8, 1, 4, 7 },
    })).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void shouldGetSubGridValues()  {
    assertThat(grid.getSubGridValues(0, 2)).isEqualTo(new Integer[]{
       1, 4, 7, 4, 7, 2, 1, 6, 7
    });
  }

  @Test
  public void shouldGetColumnValues()  {
    assertThat(grid.getColumnValues(4)).isEqualTo(new Integer[]{
        9, 8, 9, 9, 2, 9, 9, 9, 9
    });
  }

  @Test
  public void shouldGetRowValues()  {
    assertThat(grid.getRowValues(2)).isEqualTo(new Integer[]{
        2, 5, 4, 3, 9, 8, 1, 6, 7
    });
  }
}
