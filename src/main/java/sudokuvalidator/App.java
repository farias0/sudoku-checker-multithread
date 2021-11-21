package sudokuvalidator;

import java.io.IOException;

public class App {

  public static void main(String[] args)  {

    Grid grid;

    try {
       grid = new Grid(InputReader.readGridInputFile());
    } catch (IOException ex) {
      System.out.println("Error reading the grid file. Make sure there's a \"sudoku_input.txt\" file alongside this executable.");
      System.exit(1);
      return; // just so intellij shut up about uninitialized variables
    }

    System.out.println(Validator.validateGroup(grid.getSubGridValues(0, 0)));
    System.out.println(Validator.validateGroup(grid.getColumnValues(0)));
    System.out.println(Validator.validateGroup(grid.getRowValues(0)));

    System.exit(0);
  }
}
