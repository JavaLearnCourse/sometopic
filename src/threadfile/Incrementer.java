package threadfile;

import java.io.File;

public class Incrementer extends Worker {


    public Incrementer(File f) {
        super(f);
    }

    @Override
    public void doTask() {
        incrementer();
    }

}
