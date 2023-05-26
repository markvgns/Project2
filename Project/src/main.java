import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class main<E> {

  public static void main(String[] args) {
    System.out.println("Going to sleep....");
    long timetosleep = 2L;
    TimeUnit time = TimeUnit.SECONDS;
    try {
      time.sleep(timetosleep);
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
  }
}
