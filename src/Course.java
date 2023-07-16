import java.util.List;
import java.util.ArrayList;

public class Course implements Runnable {
    public static List<Integer> thread1 = new ArrayList<>();
    public static List<Integer> thread2 = new ArrayList<>();
    public static List<Integer> thread3 = new ArrayList<>();
    public static List<Integer> thread4 = new ArrayList<>();
    public static List<Integer> evenNumbers = new ArrayList<>();
    public static List<Integer> oddNumbers = new ArrayList<>();

    List<Integer> numbers = new ArrayList<>();

    {
        for (int i = 0; i < 10000; i++) {
            numbers.add(i);
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (i < numbers.size() * 1 / 4) {
                thread1.add(i);
            } else if (i < numbers.size() * 1 / 2) {
                thread2.add(i);
            } else if (i < numbers.size() * 3 / 4) {
                thread3.add(i);
            } else {
                thread4.add(i);
            }
        }
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            for (Integer i : thread1) {
                add(i);
            }
        }
        if (Thread.currentThread().getName().equals("Thread-1")) {
            for (Integer i : thread2) {
                add(i);
            }
        }
        if (Thread.currentThread().getName().equals("Thread-2")) {
            for (Integer i : thread3) {
                add(i);
            }
        }
        if (Thread.currentThread().getName().equals("Thread-3")) {
            for (Integer i : thread4) {
                add(i);
            }
        }
    }

    public synchronized void add(int number) {
        if (number % 2 == 0) {
            System.out.println(Thread.currentThread().getName() + " : " + number);
            evenNumbers.add(number);
        } else {
            System.out.println(Thread.currentThread().getName() + " : " + number);
            oddNumbers.add(number);
        }
    }
}
