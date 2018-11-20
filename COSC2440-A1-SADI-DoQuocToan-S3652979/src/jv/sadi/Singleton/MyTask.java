package jv.sadi.Singleton;

public class MyTask implements Runnable {
    private static MyTask instance = new MyTask();

    public static MyTask getInstance() {
        return instance;
    }

    @Override
    public void run() {
        System.out.println("Welcome to the program!");
    }

}
