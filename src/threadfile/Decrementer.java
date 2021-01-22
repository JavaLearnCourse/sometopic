package threadfile;

import java.io.File;

public class Decrementer extends  Worker {

    public Decrementer(File f) {
        super(f);
    }

    @Override
    public void doTask() {
        decrementer();
    }
}
