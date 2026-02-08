import java.util.Random;

class FileDownloaderThread extends Thread {
    private String fileName;
    Random rand = new Random();

    public FileDownloaderThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i += 10) {
            System.out.println("[" + getName() + "] Downloading " + fileName + ": " + i + "%");
            try {
                Thread.sleep(rand.nextInt(300));
            } catch (Exception e) {}
        }
    }
}

class FileDownloaderRunnable implements Runnable {
    private String fileName;
    Random rand = new Random();

    public FileDownloaderRunnable(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        for (int i = 0; i <= 100; i += 10) {
            System.out.println("[" + t.getName() + "] Downloading " + fileName + ": " + i + "%");
            try {
                Thread.sleep(rand.nextInt(300));
            } catch (Exception e) {}
        }
    }
}

public class FileDownloader {
    public static void main(String[] args) throws Exception {

        System.out.println("=== Thread Class Approach ===");

        FileDownloaderThread f1 = new FileDownloaderThread("Document.pdf");
        FileDownloaderThread f2 = new FileDownloaderThread("Image.jpg");
        FileDownloaderThread f3 = new FileDownloaderThread("Video.mp4");

        f1.start();
        f2.start();
        f3.start();

        f1.join();
        f2.join();
        f3.join();

        System.out.println("=== Runnable Interface Approach ===");

        Thread r1 = new Thread(new FileDownloaderRunnable("Document.pdf"), "Runnable-1");
        Thread r2 = new Thread(new FileDownloaderRunnable("Image.jpg"), "Runnable-2");
        Thread r3 = new Thread(new FileDownloaderRunnable("Video.mp4"), "Runnable-3");

        r1.start(); r2.start(); r3.start();

        r1.join(); r2.join(); r3.join();

        System.out.println("All downloads complete!");
    }
}