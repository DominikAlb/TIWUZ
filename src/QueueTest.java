import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.util.EmptyStackException;
import java.util.Scanner;

public class QueueTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void enqueuePositiveTest() {
        System.out.println("Sprawdz funkcje enqueue - wynik pozytywny");
        int size = 4;
        Queue<Integer> queue = new IntQueue(size);
        Assert.assertEquals(queue.enqueue(1), 1);
        Assert.assertEquals(queue.enqueue(2), 1);
        Assert.assertEquals(queue.enqueue(1), 1);
        System.out.println("Test1: " + queue.toString());
    }

    @Test
    public void enqueueNegativeTextToIntegerTest() {
        System.out.println("Sprawdz funkcje enqueue - test negatywny");
        int size = 4;
        Queue<Integer> queue = new IntQueue(size);
        Assert.assertEquals(queue.enqueue(1), 1);
        Assert.assertEquals(queue.enqueue(2), 1);
        expectedException.expect(NullPointerException.class);
        queue.enqueue(Integer.getInteger("Text"));
        System.out.println("Test2: " + queue.toString());
    }

    @Test
    public void enqueuePositiveTextToIntegerTest() {
        System.out.println("Sprawdz funkcje enqueue - wynik poztywny po parsowaniu");
        int size = 4;
        Queue<Integer> queue = new IntQueue(size);
        Assert.assertEquals(queue.enqueue(1), 1);
        Assert.assertEquals(queue.enqueue(2), 1);
        Assert.assertEquals(queue.enqueue(Integer.parseInt("2")), 1);
        System.out.println("Test3: " + queue.toString());
    }

    @Test
    public void dequeuePositiveTest() {
        System.out.println("Sprawdz funkcje dequeue - wynik poztywny");
        int size = 5;
        Queue<Integer> queue = new IntQueue(size);
        queue.enqueue(1);
        queue.enqueue(500);
        queue.enqueue(1000);
        Assert.assertEquals(queue.dequeue(), 1000);
        Assert.assertEquals(queue.dequeue(), 500);
        Assert.assertEquals(queue.dequeue(), 1);
        System.out.println("Test4: " + queue.toString());
    }

    @Test
    public void dequeueNegativeTest() {
        System.out.println("Sprawdz funkcje dequeue - test negatywny");
        int size = 2;
        Queue<Integer> queue = new IntQueue(size);
        expectedException.expect(NegativeArraySizeException.class);
        queue.dequeue();
        System.out.println("Test5: " + queue.toString());
    }

    @Test
    public void peekPositiveTest() {
        System.out.println("Sprawdz funkcje peek - wynik pozytywny");
        int size = 3;
        Queue<Integer> queue = new IntQueue(size);
        queue.enqueue(5);
        Assert.assertEquals((int)queue.peek(), 5);
        queue.enqueue(12);
        Assert.assertEquals((int)queue.peek(), 5);
        queue.dequeue();
        Assert.assertEquals((int)queue.peek(), 12);
        System.out.println("Test6: " + queue.toString());
    }

    @Test
    public void peekNegativeTest() {
        System.out.println("Sprawdz funkcje peek - test negatywny");
        int size = 2;
        Queue<Integer> queue = new IntQueue(size);
        expectedException.expect(EmptyStackException.class);
        queue.peek();
        System.out.println("Test7: " + queue.toString());
    }

    @Test
    public void isFullTest() {
        System.out.println("Sprawdz funkcje isFull - wynik pozytywny");
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
        System.out.println("Test8: " + queue.toString());
    }

    @Test
    public void isEmptyTest() {
        System.out.println("Sprawdz funkcje isEmpty - wynik pozytywny");
        int size = 1;
        IntQueue queue = new IntQueue(size);
        Assert.assertTrue(queue.isempty());
        size = 2;
        queue = new IntQueue(size);
        queue.enqueue(99);
        Assert.assertFalse(queue.isempty());
        queue = new IntQueue(queue, 5);
        Assert.assertFalse(queue.isempty());
        System.out.println("Test9: " + queue.toString());
    }

    @Test
    public void constructorZeroSizeTest() {
        System.out.println("Sprawdz konstruktor - wynik pozytywny");
        int size = 0;
        Queue<Integer> queue = new IntQueue(size);
        expectedException.expect(IndexOutOfBoundsException.class);
        Assert.assertEquals(queue.enqueue(1), -1);
        System.out.println("Test10: " + queue.toString());
    }

    @Test
    public void constructorMinusSizeTest() {
        System.out.println("Sprawdz konstruktor - test negatywny");
        int size = -1;
        expectedException.expect(NegativeArraySizeException.class);
        Queue<Integer> queue = new IntQueue(size);
        queue.enqueue(1);
        System.out.println("Test11: " + queue.toString());
    }

    @Test
    public void constructorCopyQueueTest() {
        System.out.println("Sprawdz konstruktor z parametrami - wynik pozytywny");
        int size = 2;
        IntQueue queue = new IntQueue(size);
        queue.enqueue(1);
        queue.enqueue(2);
        IntQueue queue2 = new IntQueue(queue, 3);
        Assert.assertEquals( 2, queue2.dequeue());
        Assert.assertEquals(1, queue2.dequeue());
        System.out.println("Test12: " + queue.toString());
    }

    @Test
    public void constructorIncreaseSizeOfQueueTest() {
        System.out.println("Sprawdz konstruktor z parametrami 2 - wynik pozytywny");
        int size = 2;
        IntQueue queue = new IntQueue(size);
        queue.enqueue(1);
        queue.enqueue(2);
        Assert.assertTrue(queue.isfull());
        IntQueue queue2 = new IntQueue(queue, 5);
        queue2.enqueue(3);
        Assert.assertFalse(queue2.isfull());
        System.out.println("Test13: " + queue.toString());
    }

    @Test
    public void endToEndTest() {
        System.out.println("Sprawdz wszystkie funkcje kolejki");
        int size = 100;
        IntQueue queue = new IntQueue(size);
        Assert.assertTrue(queue.isempty());
        Assert.assertFalse(queue.isfull());
        queue = new IntQueue(queue, 101);
        Assert.assertFalse(queue.isempty());
        Assert.assertFalse(queue.isfull());
        Assert.assertEquals(queue.enqueue(100), 1);
        Assert.assertFalse(queue.isempty());
        Assert.assertTrue(queue.isfull());
        Assert.assertEquals(queue.dequeue(), 100);
        Assert.assertFalse(queue.isempty());
        Assert.assertFalse(queue.isfull());
        System.out.println("Test14: " + queue.toString());
    }

    @Test
    public void UITest() {
        System.out.println("Sprawdz funkcje w menu");
        String data = "1 3 2 4 2 0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        UserFunctions userFunctions = new UserFunctions(scanner);
        InterfaceFunctions interfaceFunctions = new FunctionTrigger(userFunctions);

        expectedException.expect(IllegalArgumentException.class);
        interfaceFunctions.runMenu();
        Assert.assertTrue(interfaceFunctions.toString().matches("^\\[[[0-9]+[,]]+[0-9]\\].*"));
        System.out.println("Test15: " + interfaceFunctions.toString());
    }

    @Test
    public void setSizeNegative() {
        System.out.println("Sprawdz podstawowy program - test negatywny");
        String data = "-5 test";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        UserFunctions userFunctions = new UserFunctions(scanner);
        InterfaceFunctions interfaceFunctions = new FunctionTrigger(userFunctions);

        expectedException.expect(IllegalArgumentException.class);
        interfaceFunctions.runBasicProgram();
        System.out.println("Test16: " + interfaceFunctions.toString());
    }

    @Test
    public void basicProgram() {
        System.out.println("Sprawdz podstawowy program - wynik pozytywny");
        String data = "3";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        UserFunctions userFunctions = new UserFunctions(scanner);
        InterfaceFunctions interfaceFunctions = new FunctionTrigger(userFunctions);

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        interfaceFunctions.runBasicProgram();
        Assert.assertTrue(interfaceFunctions.toString().matches("^\\[[-?[0-9]+[,\\s]]+\\].*"));
        System.out.println("Test17: " + interfaceFunctions.toString());
    }

    @Test
    public void extendedProgram() {
        System.out.println("Sprawdz rozszerzony program - wynik pozytywny");
        String data = "5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        UserFunctions userFunctions = new UserFunctions(scanner);
        InterfaceFunctions interfaceFunctions = new FunctionTrigger(userFunctions);

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        interfaceFunctions.runExtendedProgram();
        Assert.assertTrue(interfaceFunctions.toString().matches("^\\[[-?[0-9]+[,\\s]]+\\].*"));
        System.out.println("Test18: " + interfaceFunctions.toString());
    }
}