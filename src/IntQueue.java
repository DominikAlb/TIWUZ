public class IntQueue implements Queue<Integer> {

    private int size;
    private int[] arr;
    private int front;
    private int rear;
    private int count;

    IntQueue(int size) {
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
        return 0;
    }

    @Override
    public int dequeue() {
        return 0;
    }

    @Override
    public Integer peek() {
        return null;
    }

    @Override
    public boolean isfull() {
        return false;
    }

    @Override
    public boolean isempty() {
        return false;
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
