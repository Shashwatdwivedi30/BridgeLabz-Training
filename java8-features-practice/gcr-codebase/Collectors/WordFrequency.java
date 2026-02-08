import java.util.*;
import java.util.stream.*;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "java stream collectors java map stream";

        List<String> words = Arrays.asList(text.split(" "));
        Map<String, Long> freq = words.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println(freq);
    }
}