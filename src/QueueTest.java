import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class QueueTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void enqueuePositiveTest() {
        int size = 4;
        Queue<Integer> queue = new IntQueue(size);
        Assert.assertEquals(queue.enqueue(1), 1);
        Assert.assertEquals(queue.enqueue(2), 1);
        Assert.assertEquals(queue.enqueue(1), 1);
    }

    @Test
    public void enqueueNegativeTextToIntegerTest() {
        int size = 4;
        Queue<Integer> queue = new IntQueue(size);
        Assert.assertEquals(queue.enqueue(1), 1);
        Assert.assertEquals(queue.enqueue(2), 1);
        expectedException.expect(IllegalArgumentException.class);
        queue.enqueue(Integer.getInteger("Text"));
    }

    @Test
    public void enqueuePositiveTextToIntegerTest() {
        int size = 4;
        Queue<Integer> queue = new IntQueue(size);
        Assert.assertEquals(queue.enqueue(1), 1);
        Assert.assertEquals(queue.enqueue(2), 1);
        Assert.assertEquals(queue.enqueue(Integer.getInteger("2")), 1);
    }

    @Test
    public void dequeuePositiveTest() {
        int size = 5;
        Queue<Integer> queue = new IntQueue(size);
        queue.enqueue(1);
        queue.enqueue(500);
        queue.enqueue(1000);
        Assert.assertEquals(queue.dequeue(), 1);
        Assert.assertEquals(queue.dequeue(), 500);
        Assert.assertEquals(queue.dequeue(), 1000);
    }

    @Test
    public void dequeueNegativeTest() {
        int size = 2;
        Queue<Integer> queue = new IntQueue(size);
        expectedException.expect(NegativeArraySizeException.class);
        queue.dequeue();
    }

    @Test
    public void peekPositiveTest() {
        int size = 3;
        Queue<Integer> queue = new IntQueue(size);
        queue.enqueue(5);
        Assert.assertEquals((int)queue.peek(), 5);
        queue.enqueue(12);
        Assert.assertEquals((int)queue.peek(), 12);
    }

    @Test
    public void peekNegativeTest() {
        int size = 2;
        Queue<Integer> queue = new IntQueue(size);
        expectedException.expect(NegativeArraySizeException.class);
        queue.peek();
    }

    @Test
    public void isFullTest() {
        int size = 0;
        IntQueue queue = new IntQueue(size);
        Assert.assertTrue(queue.isfull());
        size = 2;
        queue = new IntQueue(size);
        queue.enqueue(99);
        Assert.assertFalse(queue.isfull());
        queue.enqueue(100);
        Assert.assertTrue(queue.isfull());
        queue = new IntQueue(queue, 5);
        Assert.assertFalse(queue.isfull());
        queue = new IntQueue(queue);
        Assert.assertTrue(queue.isfull());
    }

    @Test
    public void isEmptyTest() {
        int size = 0;
        IntQueue queue = new IntQueue(size);
        Assert.assertFalse(queue.isempty());
        size = 2;
        queue = new IntQueue(size);
        queue.enqueue(99);
        Assert.assertTrue(queue.isempty());
        queue = new IntQueue(queue, 5);
        Assert.assertTrue(queue.isempty());
        queue = new IntQueue(queue);
        Assert.assertTrue(queue.isempty());
    }

    @Test
    public void constructorZeroSizeTest() {
        int size = 0;
        Queue<Integer> queue = new IntQueue(size);
        expectedException.expect(IndexOutOfBoundsException.class);
        Assert.assertEquals(queue.enqueue(1), -1);
    }

    @Test
    public void constructorMinusSizeTest() {
        int size = -1;
        Queue<Integer> queue = new IntQueue(size);
        expectedException.expect(NegativeArraySizeException.class);
        queue.enqueue(1);
    }

    @Test
    public void constructorCopyQueueTest() {
        int size = 3;
        IntQueue queue = new IntQueue(size);
        queue.enqueue(1);
        queue.enqueue(2);
        IntQueue queue2 = new IntQueue(queue);
        Assert.assertEquals(queue2.dequeue(), 1);
        Assert.assertEquals(queue2.dequeue(), 2);
    }

    @Test
    public void constructorIncreaseSizeOfQueueTest() {
        int size = 2;
        IntQueue queue = new IntQueue(size);
        queue.enqueue(1);
        queue.enqueue(2);
        Assert.assertTrue(queue.isfull());
        IntQueue queue2 = new IntQueue(queue, 5);
        queue2.enqueue(3);
        Assert.assertFalse(queue2.isfull());
    }

    @Test
    public void endToEndTest() {
        int size = 100;
        IntQueue queue = new IntQueue(size);
        queue = new IntQueue(queue);
        queue = new IntQueue(queue, 1);
        Assert.assertTrue(queue.isempty());
        Assert.assertFalse(queue.isfull());
        Assert.assertEquals(queue.enqueue(100), 1);
        Assert.assertFalse(queue.isempty());
        Assert.assertTrue(queue.isfull());
        Assert.assertEquals(queue.dequeue(), 100);
        Assert.assertTrue(queue.isempty());
        Assert.assertFalse(queue.isfull());
    }

    @Test
    public void UITest() {
        //TODO Zadadnie 2
    }
}