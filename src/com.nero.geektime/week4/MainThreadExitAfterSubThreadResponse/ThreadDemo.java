package com.nero.geektime.week4.MainThreadExitAfterSubThreadResponse;

public class ThreadDemo {
    private static int sum = 0;

    public void run() {
        try {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    int start = 0;
                    while (start < 3) {
                        sum++;
                    }
                    //System.out.println("sub thread: sum is " + sum);
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        //System.out.println("Thread is interrupted.");
                    }
                }
            };

            this.notify();
            Thread thread = new Thread(r);
            thread.join();

        } catch (InterruptedException e) {
            //System.out.println("Thread is interrupted.");
        } finally {
            //System.out.println("main thread: sum is " + sum);
        }
    }

    public static void main(String[] args) {
        ThreadDemo d = new ThreadDemo();
        d.run();
    }
}
