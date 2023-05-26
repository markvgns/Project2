import java.util.ArrayList;

public class main<E> {

  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(5);
    numbers.add(4);
    numbers.add(6);
    numbers.add(8);
    numbers.add(9);
    Queue<Integer> BoundedQueue = new Queue<>(numbers.size());
    for (int i = 0; i < numbers.size(); i++) {

      BoundedQueue.enQueue(numbers.get(i));
    }
    int k = 0;
    int i = 0;
    while (true) {

      if (i == 1) {
        BoundedQueue.totheback(BoundedQueue.deQueue());
        i++;
        continue;

      } else {
        k = BoundedQueue.deQueue();
        System.out.println(k);
        i++;

      }
    }

  }
}
