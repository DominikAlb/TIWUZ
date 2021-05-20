import java.util.Arrays;
import java.util.EmptyStackException;

public class IntQueue implements Queue<Integer> {

    private int size;
    private int[] arr;
    private int front;
    private int rear;
    private int count;

    IntQueue(int size) {
        if (size < 0) throw new NegativeArraySizeException();
        this.size = size;
        arr = new int[size];
        front = count = 0;
        rear = -1;
    }

    IntQueue(IntQueue queue, int size) {
        arr = new int[size];
        this.size = size;
        front = count = 0;
        rear = -1;
        Arrays.stream(queue.getArr()).limit(size).forEach(this::enqueue);
    }

    @Override
    public int enqueue(Integer item) {
        if (isfull()) {
            throw new IndexOutOfBoundsException();
        } else if (item == null) {
            throw new NullPointerException();
        }
        setRear(1);
        arr[rear] = item;
        setCount(1);
        return 1;
    }

    @Override
    public int dequeue() {
        if (isempty()) {
            throw new NegativeArraySizeException();
        }
        setFront(1);
        setCount(-1);
        return arr[count];
    }

    @Override
    public Integer peek() {
        if (isempty()) {
            throw new EmptyStackException();
        }
        return arr[front];
    }

    @Override
    public boolean isfull() {
        return getCount() == getSize();
    }

    @Override
    public boolean isempty() {
        return getCount() == 0;
    }

    private int[] getArr() {
        return arr;
    }

    private int getSize() {
        return size;
    }

    private int getFront() {
        return front;
    }

    private int getRear() {
        return rear;
    }

    private int getCount() {
        return count;
    }

    private void setCount(int count) {
        this.count = this.count + count;
    }

    private void setFront(int front) {
        this.front = (this.front + front) % getSize();
    }

    private void setRear(int rear) {
        this.rear = (this.rear + rear) % getSize();
    }
}
