public interface Queue<T> {
    int enqueue(T item);
    int dequeue();
    T peek();
    boolean isfull();
    boolean isempty();
}