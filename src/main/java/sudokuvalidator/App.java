package sudokuvalidator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

  private static final Path SUDOKU_INPUT_PATH = Paths.get("sudoku_input.txt");

  public static void main(String[] args) throws InterruptedException {

    Integer[][] inputData;

    try {
      System.out.println("Reading " + SUDOKU_INPUT_PATH.toAbsolutePath() + " ...");
      inputData = InputReader.readGridInputFile(SUDOKU_INPUT_PATH);
    } catch (IOException ex) {
      System.out.println("Error reading the grid file. Make sure there's a \"sudoku_input.txt\" file in the working directory.");
      System.exit(1);
      return; // just so intellij shut up about uninitialized variables
    }

    Grid grid = new Grid(inputData);
    List<Validator> validations = new ArrayList<>();

    for (var i = 0; i < 3; i++) {
      for (var j = 0; j < 3; j++) {
        validations.add(new Validator(grid.getSubGridValues(i, j)));
      }
    }

    for (var i = 0; i < 9; i++) {
      validations.add(new Validator(grid.getColumnValues(i)));
      validations.add(new Validator(grid.getRowValues(i)));
    }

    ExecutorService executor = Executors.newCachedThreadPool();
    List<Future<Boolean>> validationsResults = executor.invokeAll(validations); // this is a blocking call
    executor.shutdown();

    var failedTask = validationsResults.stream()
        .map(f -> {
          try {
            return f.get();
          } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            System.exit(1);
            return Optional.empty();
          }
        })
        .filter(r -> r.equals(false))
        .findAny();


    if (failedTask.isEmpty()) {
      System.out.println("Valid solution!");
    } else {
      System.out.println("Invalid solution.");
    }

    System.exit(0);
  }
}
