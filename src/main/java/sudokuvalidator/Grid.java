package sudokuvalidator;

/*
  From TOP LEFT, from 0 to 8
 */

public class Grid {

  private final Integer[][] values;

  public Grid(Integer[][] values) {
    validateGridSize(values);
    this.values = values;
  }

  public Integer[] getSubGridValues(Integer x, Integer y) {
    if (x < 0 || x > 2 || y < 0 || y > 2) {
      throw new IllegalArgumentException("Invalid subgrid indexes");
    }

    x *= 3;
    y *= 3;

    return new Integer[]{this.values[x][y], this.values[x][y+1], this.values[x][y+2],
        this.values[x+1][y], this.values[x+1][y+1], this.values[x+1][y+2],
        this.values[x+2][y], this.values[x+2][y+1], this.values[x+2][y+2]};
  }

  public Integer[] getColumnValues(Integer i) {
    if (i < 0 || i > 8) {
      throw new IllegalArgumentException("Invalid column index");
    }

    return new Integer[]{this.values[0][i], this.values[1][i], this.values[2][i],
        this.values[3][i], this.values[4][i], this.values[5][i],
        this.values[6][i], this.values[7][i], this.values[8][i]};
  }

  public Integer[] getRowValues(Integer i) {
    if (i < 0 || i > 8) {
      throw new IllegalArgumentException("Invalid row index");
    }

    return new Integer[]{this.values[i][0], this.values[i][1], this.values[i][2],
        this.values[i][3], this.values[i][4], this.values[i][5],
        this.values[i][6], this.values[i][7], this.values[i][8]};
  }

  private static void validateGridSize(Integer[][] values) {
    var ex = new IllegalArgumentException("Invalid grid values");

    if (values.length != 9) {
      throw ex;
    }

    for (var column : values) {
      if (column.length != 9) {
        throw ex;
      }
    }
  }
}
