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

    IntQueue(IntQueue queue) {
        arr = queue.getArr();
        size = queue.getSize();
        front = queue.getFront();
        rear = queue.getRear();
        count = queue.getCount();
    }

    IntQueue(IntQueue queue, int size) {
        arr = queue.getArr();
        this.size = size;
        front = queue.getFront();
        rear = queue.getRear();
        count = queue.getCount();
    }

    @Override
    public int enqueue(Integer item) {
        if (isfull()) {
            throw new IndexOutOfBoundsException();
        }
        rear = (rear + 1) % size;
        arr[rear] = item;
        count++;
        return 1;
    }

    @Override
    public int dequeue() {
        if (isempty()) {
            throw new NegativeArraySizeException();
        }
        front = (front + 1) % size;
        count--;
        return 1;
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
}
