public class ThreadTwo  extends Thread {

    public ThreadTwo(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("ThreadTwo - START "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            //Get database connection, delete unused data from DB
            doDBProcessing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadTwo - END "+Thread.currentThread().getName());
    }

    private void doDBProcessing() throws InterruptedException {
        Thread.sleep(5000);
    }


    // Run this
    public static void main(String[] args){
        System.out.println("Constructing ThreadTwos");
        Thread t1 = new ThreadTwo("t1");
        Thread t2 = new ThreadTwo("t2");
        Thread t3 = new ThreadTwo("t3");
        Thread t4 = new ThreadTwo("t4");
        System.out.println("Starting ThreadTwos");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("ThreadTwos have been started");

    }
}
