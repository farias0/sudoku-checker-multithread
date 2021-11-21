package sudokuvalidator;

import java.io.IOException;
import java.util.Arrays;

public class App {

  public static void main(String[] args) throws IOException {

    try {
      var input = InputReader.readGridInputFile();
      System.out.println(Arrays.deepToString(input));
      System.exit(0);
    } catch (IOException ex) {
      System.out.println("Error reading the grid file. Make sure there's a \"sudoku_input.txt\" file alongside this executable.");
      System.exit(1);
    }
  }
}
