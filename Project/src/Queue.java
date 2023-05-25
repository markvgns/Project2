public class Queue<E> {

  private int head = 0;
  private int size = 0;

  private final Object queueArray[];

  public Queue(int maxSize) {

    this.queueArray = new Object[maxSize + 4];
  }

  public void enQueue(E e) {
    // Checking if queue is full before inserting new Item
    if (isQueueFull()) {
      throw new IllegalStateException("Queue is Full!!");
    }

    // We have to wrap the queue in case maxSize has reached

    queueArray[(head + size) % queueArray.length] = e;

    size++;
  }

  /**
   * Method to DeQueue or Remove an Item From Queue
   * 
   * @return return DeQueued or Removed Item from queue(head)
   */
  public E deQueue() {
    // Checking if queue is Empty before Removing new item
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

  public void totheback() {
    enQueue(peek());
    head++;

  }

  private boolean isQueueEmpty() {
    return size == 0;
  }

  private boolean isQueueFull() {
    return size == queueArray.length;
  }

}
