package com.demo.concurrency.chapter2;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/15 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class SimpleCalculatorStrategy implements CalculatorStrategy {

    private final static double SALARY_RATE = 0.1;
    private final static double BONUS_RATE = 0.15;

    @Override
    public double calculate(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }

    /***************************************
     * @author:Alex Wang
     * @Date:2017/2/15 QQ:532500648
     * QQ交流群:286081824
     ***************************************/
    public static class BankVersion2 {

        private final static int MAX = 50;

        public static void main(String[] args) {

    //        final TicketWindowRunnable ticketWindow = new TicketWindowRunnable();

            final Runnable ticketWindow = () -> {
                int index = 1;
                while (index <= MAX) {
                    System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            Thread windowThread1 = new Thread(ticketWindow, "一号窗口");
            Thread windowThread2 = new Thread(ticketWindow, "二号窗口");
            Thread windowThread3 = new Thread(ticketWindow, "三号窗口");
            windowThread1.start();
            windowThread2.start();
            windowThread3.start();
        }
    }
}
