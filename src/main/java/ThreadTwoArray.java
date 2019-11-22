public class ThreadTwoArray extends Thread {

    public ThreadTwoArray(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("ThreadTwoArray - START "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            //Get database connection, delete unused data from DB
            doDBProcessing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadTwoArray - END "+Thread.currentThread().getName());
    }

    private void doDBProcessing() throws InterruptedException {
        Thread.sleep(5000);
    }


    // Run this
    public static void main(String[] args){
        runArrayOfSize(10);

        runArrayOfSize(20);

        // wait, what the hell is going on? eh?
    }

    private static void runArrayOfSize(int size) {
        System.out.println("Constructing Array of Size "+Integer.toString(size));
        Integer threadCount = size;
        Thread[] threadArray = new Thread[threadCount];


        for (int i = 0; i < threadCount; i++) {
            threadArray[i] = new ThreadTwoArray("T"+ Integer.toString(i));
        }
        System.out.println("Starting Thread Array");
        for (int i = 0; i < threadCount; i++) {
            threadArray[i].start();
        }
        System.out.println("Thread Array all have been started");
    }
}
