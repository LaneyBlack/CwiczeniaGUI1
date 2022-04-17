package com.bits.squad.c5;

import static com.bits.squad.test.Colors.getTextColor;

public class C5 {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println(getTextColor("Yellow") + "----------------------------------Example----------------------------------" + getTextColor("Reset"));
//        {
//            MyThread myThread = new MyThread();
//            myThread.start();
//            System.out.println("Main Start");
////            Thread.sleep(500);
//            for (int i = 0; i < 1000000; i++) {
//                String a = "a";
//                String b = "b";
//                String c = a + b;
//            }
//            System.out.println("Main end");
//            myThread.join();
//            System.out.println("Program end");
//        }
//        System.out.println(getTextColor("Cyan") + "----------------------------------Ex1----------------------------------" + getTextColor("Reset"));
//        {
//            ThreadEx1 threadEx1F = new ThreadEx1("First");
//            ThreadEx1 threadEx1S = new ThreadEx1("Second");
//            threadEx1F.start();
//            threadEx1S.start();
//        }
//        System.out.println(getTextColor("Cyan") + "----------------------------------Ex2----------------------------------" + getTextColor("Reset"));
//        {
//            Letters letters = new Letters("ABCD", 4);
//            for (Thread t : letters.getThreads()) {
//                System.out.println(t.getName());
//                t.start();
//            }
//            Thread.sleep(500);
//            for (Thread t : letters.getThreads())
//                t.interrupt();
//            System.out.println("\n Program end");
//            for (ThreadEx2 t : letters.getThreads())
//                System.out.println(t.getName() + " " + t.getCounter());
//        }
        System.out.println(getTextColor("Cyan") + "----------------------------------Ex3----------------------------------" + getTextColor("Reset"));
        {
            StringTask task = new StringTask("A", 100000);
            System.out.println("Task " + task.getState());
            task.start();
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        task.abort();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
            /*<-tu zapisać kod  przerywający działanie tasku po sekundzie       i uruchomic go w odrębnym wątku  */
            while (!task.isDone()) {
                Thread.sleep(500);
                switch (task.getState()) {
                    case RUNNING:
                        System.out.print("R.");
                        break;
                    case ABORTED:
                        System.out.println(" ... aborted.");
                        break;
                    case READY:
                        System.out.println(" ... ready.");
                        break;
                    default:
                        System.out.println("uknown-state");
                }
            }
            System.out.println("Task " + task.getState());
            System.out.println(task.getResult().length());
        }
    }
}
