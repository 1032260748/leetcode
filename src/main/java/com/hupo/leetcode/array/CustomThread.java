package com.hupo.leetcode.array;

public class CustomThread extends Thread {

    public static void main(String[] args) {
        CustomThread customThread1 = new CustomThread();
        CustomThread customThread2 = new CustomThread();
        customThread1.start();
        customThread2.start();
    }

    public static volatile int i = 1;

    public static Object lock = new Object();

    @Override
    public void run() {
        while (i < 100) {
            synchronized (lock) {
                if (i < 100) {
                    System.out.println(i);
                    i++;
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (Exception ex) {

                    }
                }
            }
        }
    }
}
