package sudokuvalidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

  private static final Path SUDOKU_INPUT_PATH = Paths.get("sudoku_input.txt");

  private InputReader() {
    throw new IllegalStateException("Utility class");
  }

  public static Integer[][] readGridInputFile() throws IOException {
    var bytes = Files.readAllBytes(SUDOKU_INPUT_PATH);
    return processGridInput(new String(bytes));
  }

  /*
    reads a Sudoku grid in the following format:
      0 1 2 3 4 5 6 7 8
      0 1 2 3 4 5 6 7 8
      0 1 2 3 4 5 6 7 8
      0 1 2 3 4 5 6 7 8
      0 1 2 3 4 5 6 7 8
      0 1 2 3 4 5 6 7 8
      0 1 2 3 4 5 6 7 8
      0 1 2 3 4 5 6 7 8
   */
  static Integer[][] processGridInput(String input) throws IllegalArgumentException {
    final List<Integer[]> grid = new ArrayList<>();
    final String[] lines = input.split("\n");
    final IllegalArgumentException invalidInputEx = new IllegalArgumentException("Invalid grid input");

    if (lines.length < 9) {
      throw invalidInputEx;
    }

    var currentLine = 0;

    for (var lineString : lines) {
      final List<Integer> line = new ArrayList<>();
      final String[] chars = lineString.split(" ");

      if (chars.length != 9) {
        throw invalidInputEx;
      }

      for (var c : chars) {
        try {
          line.add(Integer.parseInt(c.replace("\r", "")));
        } catch (Exception e) {
          throw invalidInputEx;
        }
      }

      grid.add(line.toArray(new Integer[]{}));

      if(++currentLine == 9) {
        break;
      }
    }

    return grid.toArray(new Integer[][]{});
  }
}
