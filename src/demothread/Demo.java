package demothread;

import java.util.*;

public class Demo {

    Queue<Task> tasks = new ArrayDeque<>();

    static final Object object = new Object();
    public static void main(String[] args) {
        try {
            new Company().startwork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


class Company {

    Deque<Task> tasks = new ArrayDeque<>();
    Boss b = new Boss(tasks);
    Worker w = new Worker(tasks);

    public void startwork() throws InterruptedException {
        System.out.println("DFFF");
        Thread t = new Thread(b);
        Thread t1= new Thread(w);
        t.start();
        t1.start();
        t.join();
        t1.join();
    }

}


class Boss implements  Runnable{

    private  Deque<Task>t ;

    public Boss(Deque<Task> t) {
        this.t = t;
    }

    public  Task createTask() {
        System.out.println("New task");
        return  new Task();
    }

    @Override
    public void run() {
        System.out.println("P");
        for (int i = 0;  i < 50; i++){
            if (i == 49){
                try {
                    Thread.sleep(5000);
                    i = 0;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (i > 25){
                try {
                    Thread.sleep(5 * i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (Demo.object) {
                t.addLast(createTask());
                Demo.object.notifyAll();
            }
        }
    }
}

class Worker implements  Runnable{

    private  Deque<Task>t ;

    int k = 1;
    public Worker( Deque<Task> t ) {
        this.t = t;
    }
    public void executeTask(){
        synchronized (Demo.object) {
            while (true) {
                if (t.isEmpty()) {
                    try {
                        System.out.println("Работник ждет");
                        Demo.object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Task task = t.removeFirst();
                    System.out.println(task + " executed by worker");
                }
            }
        }
    }


    @Override
    public void run() {
        System.out.println("&");
        executeTask();
    }
}

class Task {

    private String name;
    private static  int number = 1;

    public Task(){
        name = "Task " + number++;
    }


    @Override
    public String toString() {
        return name;
    }
}