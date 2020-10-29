package com.interview.app.ImplementationOfMultipleThreadsInJava;

class PrintDemo {

    public void printCount() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Counter   ---   "  + i );
            }
        }
        catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
    }
}

class ThreadDemo extends Thread {

    private Thread t;
    private String threadName;
    PrintDemo  PD;

    ThreadDemo( String name,  PrintDemo pd) {
        threadName = name;
        PD = pd;
    }

    @Override
    public void run() {
        //Synchronization
        synchronized(PD) {
            PD.printCount();
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    @Override
    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

public class App {

    public static void main(String[] args) {

        PrintDemo PD = new PrintDemo();

        ThreadDemo T1 = new ThreadDemo( "Thread - 1 ", PD );
        ThreadDemo T2 = new ThreadDemo( "Thread - 2 ", PD );
        ThreadDemo T3 = new ThreadDemo( "Thread - 3 ", PD );
        ThreadDemo T4 = new ThreadDemo( "Thread - 4", PD );

        T1.start();
        T2.start();
        T3.start();
        T4.start();

        // wait for threads to end
        try {
            T1.join();
            T2.join(1000);
            T3.join();
            T4.join(1000);
        }
        catch( Exception e) {
            System.out.println("Interrupted");
        }
    }

}
