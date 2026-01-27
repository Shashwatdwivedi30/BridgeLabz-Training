import java.io.*;
import java.util.Arrays;

public class ImageByteArrayDemo {

    public static void main(String[] args) {

        String originalImage = "original.jpg";  
        String newImage = "copy.jpg";            

        try {
            FileInputStream fis = new FileInputStream(originalImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];   
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            fis.close();

            byte[] imageBytes = baos.toByteArray();
            System.out.println("Image converted to byte array.");

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(newImage);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fos.close();
            System.out.println("New image file created: " + newImage);

            boolean identical = verifyFiles(originalImage, newImage);
            System.out.println("Files identical? " + identical);

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }

    private static boolean verifyFiles(String file1, String file2) throws IOException {
        byte[] f1 = readAllBytes(file1);
        byte[] f2 = readAllBytes(file2);
        return Arrays.equals(f1, f2);
    }

    private static byte[] readAllBytes(String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = fis.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }

        fis.close();
        return baos.toByteArray();
    }
}