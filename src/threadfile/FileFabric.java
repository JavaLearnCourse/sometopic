package threadfile;

public class FileFabric {

    private Incrementer in;
    private Decrementer de;

    private static final int MAX = 20;

    public FileFabric(Incrementer in, Decrementer de) {
        this.in = in;
        this.de = de;
    }

    public void startThread(){
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAX; i++){
                    in.doTask();

                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAX; i++){
                    de.doTask();

                }
            }
        };

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       System.out.println( "I = " + de.readCurrentFile());
    }


}
