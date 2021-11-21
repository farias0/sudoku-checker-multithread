package sudokuvalidator;

public class Thread extends java.lang.Thread {

  @Override
  public void run() {
    System.out.println("Thread " + Thread.class.getName() + " ran.");
  }
}
