package homework4;

public class PrintABC {

    private volatile char currentLetter = 'A';
    private final Object monitor = new Object();

    public static void main(String[] args) {
        PrintABC waitNotifyApp = new PrintABC();
        new Thread(waitNotifyApp::printA).start();
        new Thread(waitNotifyApp::printB).start();
        new Thread(waitNotifyApp::printC).start();
    }

    public void printA() {
        synchronized (monitor) {
            for (int i = 0; i < 10; i++) {
                try {
                    while (currentLetter != 'A') {
                        monitor.wait();
                    }
                    System.out.println("A");
                    currentLetter = 'B';
                    monitor.notifyAll();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void printB() {
        synchronized (monitor) {
            for (int i = 0; i < 10; i++) {
                try {
                    while (currentLetter != 'B') {
                        monitor.wait();
                    }
                    System.out.println("B");
                    currentLetter = 'C';
                    monitor.notifyAll();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public void printC() {
        synchronized (monitor) {
            for (int i = 0; i < 10; i++) {
                try {
                    while (currentLetter != 'C') {
                        monitor.wait();
                    }
                    System.out.println("C");
                    currentLetter = 'A';
                    monitor.notifyAll();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

