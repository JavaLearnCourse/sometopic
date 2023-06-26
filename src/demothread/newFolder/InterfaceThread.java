package demothread;

public class InterfaceThread extends Thread {

    private InterfaceExample interfaceExample;
    private static int i;
    public InterfaceThread(InterfaceExample interfaceExample) {
        this.interfaceExample = interfaceExample;
    }

    @Override
    public void run() {
        while (!interfaceExample.stop()) {
            increment();
        }
    }

    private void increment() {
        i++;
    }
    public int getI() {
        return i;
    }
}
