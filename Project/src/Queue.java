public class Queue<E> {

  private int head = 0;
  private int size = 0;

  private final Object queueArray[];

  public Queue(int maxSize) {

    this.queueArray = new Object[maxSize * 3];
  }

  public void enQueue(E e) {
    
    if (isQueueFull()) {
      throw new IllegalStateException("Queue is Full!!");
    }

   

    queueArray[(head + size) % queueArray.length] = e;

    size++;
  }

  
  
  public E deQueue() {
    
    if (isQueueEmpty()) {
      throw new IllegalStateException("Queue is Empty!!");
    }

    E e = peek();
    head = (head + 1) % queueArray.length;

    size--;
    return e;
  }

  public E peek() {
    return isQueueEmpty() ? null : (E) queueArray[head];
  }

  public void totheback(E e) {
    enQueue(e);

  }

  public boolean isQueueEmpty() {
    return size == 0;
  }

  public boolean isQueueFull() {
    return size == queueArray.length;
  }

}
