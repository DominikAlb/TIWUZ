import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserFunctions implements InterfaceFunctions {

    private final Scanner scanner;
    private IntQueue queue;
    private static final String menu = "Mozliwe operacje do wykonania:\n1:Wyswietl opcje\n2:Uruchom testy\n3:Uruchom podstawowy program\n4:Uruchom rozszerzony program\n5:Zakoncz program\n";

    UserFunctions(){
        scanner = new Scanner(System.in);
        queue = new IntQueue(1);
    }

    UserFunctions(Scanner scanner){
        this.scanner = scanner;
        queue = new IntQueue(1);
    }

    @Override
    public void runMenu() {
        System.out.println("Witaj w kreatorze kolejki. \nWybierz opcje:");
        showOptions();
        while(true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                selectOption(choice);
            }
        }
    }

    @Override
    public void showOptions() {
        System.out.println(menu);
    }

    @Override
    public void selectOption(int choice) {
        Option option = Option.valueOfOperation(choice);
        if (option == null) {
            throw new IllegalArgumentException();
        }
        switch (option) {
            case SHOW_OPTIONS -> showOptions();
            case RUN_TESTS -> runTests();
            case RUN_BASIC_PROGRAM -> runBasicProgram();
            case RUN_EXTENDED_PROGRAM -> runExtendedProgram();
            case EXIT -> System.exit(0);
            default -> System.out.println("Brak operacji");
        }
    }

    @Override
    public void runTests() {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        junit.run(QueueTest.class);
    }

    @Override
    public void runBasicProgram() {

        System.out.println("Rozpoczynam podstawowy program");

        int size = setSizeOfQueue();
        queue = new IntQueue(size);


    }

    @Override
    public void runExtendedProgram() {

        System.out.println("Rozpoczynam rozszerzony program");
        int size = setSizeOfQueue();
        queue = new IntQueue(size);
    }

    private int setSizeOfQueue() throws IllegalArgumentException {
        int size = 0;

        System.out.println("Podaj wielkosc kolejki: ");
        while(true) {
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size <= 0) {
                    System.out.println("Podana wartosc musi byc wieksza od 0");
                } else {
                    break;
                }
            } else if(scanner.hasNext()) {
                System.out.println("Podana wartosc jest nieprawidlowa");
                throw new IllegalArgumentException();
            }
        }

        return size;
    }

    private void enqueue(int x) {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("dodaje: " + x + " do kolejki");
            queue.enqueue(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int dequeue() {
        int x = queue.dequeue();
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("usuwam: " + x + " z kolejki");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return x;
    }

    private void peek() {
        try {
            TimeUnit.SECONDS.sleep(1);
            int x = queue.peek();
            System.out.println("Aktualny element w kolejce (peek): " + x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean isfull() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Sprawdzam czy kolejka jest pelna: " + queue.isfull());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return queue.isfull();
    }

    private boolean isempty() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Sprawdzam czy kolejka jest pusta: " + queue.isempty());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return queue.isempty();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}