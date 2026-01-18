import java.io.*;

public class CountOfWords {
    public static void main(String[] args) {
        String targetWord = "java";
        int count = 0;
        try{
            FileReader filereader = new FileReader("word.txt");
            BufferedReader bufferedReader = new BufferedReader(filereader);

            String line;

            while((line = bufferedReader.readLine()) != null){
                String[] words = line.toLowerCase().split("\\s+");

                for(String word : words){
                    if(word.equals(targetWord)){
                        count++;
                    }
                }
            }
            bufferedReader.close();
            filereader.close();

            System.out.println(targetWord+ " occurs " +count+ " times.");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
