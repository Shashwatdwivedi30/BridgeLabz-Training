import java.io.*;

public class BufferedStreamPerformance {

    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {

        String sourceFile = "largefile.dat";
        String unbufferedFile = "copy_unbuffered.dat";
        String bufferedFile = "copy_buffered.dat";

        copyUnbuffered(sourceFile, unbufferedFile);
        copyBuffered(sourceFile, bufferedFile);
    }

    static void copyUnbuffered(String src, String dest) {
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Unbuffered copy error: " + e.getMessage());
            return;
        }

        long endTime = System.nanoTime();
        System.out.println("Unbuffered Copy Time: "
                + (endTime - startTime) / 1_000_000 + " ms");
    }

    static void copyBuffered(String src, String dest) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis =
                     new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos =
                     new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Buffered copy error: " + e.getMessage());
            return;
        }

        long endTime = System.nanoTime();
        System.out.println("Buffered Copy Time: "
                + (endTime - startTime) / 1_000_000 + " ms");
    }
}