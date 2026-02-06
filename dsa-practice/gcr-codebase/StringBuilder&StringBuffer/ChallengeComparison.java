import java.io.*;
public class ChallengeComparison {
    public static void main(String[] args) {
        compareStringBuilderAndBuffer();
        compareFileReaders();
    }

    static void compareStringBuilderAndBuffer() {
        String text = "hello";

        // StringBuilder
        long start1 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) sb.append(text);
        long end1 = System.currentTimeMillis();

        // StringBuffer
        long start2 = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 1_000_000; i++) sbf.append(text);
        long end2 = System.currentTimeMillis();

        System.out.println("StringBuilder Time: " + (end1 - start1) + " ms");
        System.out.println("StringBuffer Time: " + (end2 - start2) + " ms");
    }

    static void compareFileReaders() {
        try {
            File file = new File("bigFile.txt");

            // FileReader
            long start1 = System.currentTimeMillis();
            FileReader fr = new FileReader(file);
            BufferedReader br1 = new BufferedReader(fr);
            int wordCount1 = 0;
            String line;
            while ((line = br1.readLine()) != null)
                wordCount1 += line.split("\\s+").length;
            br1.close();
            long end1 = System.currentTimeMillis();

            // InputStreamReader
            long start2 = System.currentTimeMillis();
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
            BufferedReader br2 = new BufferedReader(isr);
            int wordCount2 = 0;
            while ((line = br2.readLine()) != null)
                wordCount2 += line.split("\\s+").length;
            br2.close();
            long end2 = System.currentTimeMillis();

            System.out.println("FileReader Word Count: " + wordCount1 + ", Time: " + (end1 - start1) + " ms");
            System.out.println("InputStreamReader Word Count: " + wordCount2 + ", Time: " + (end2 - start2) + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}