import java.util.regex.*;

public class FindRepeatingWords {
    public static void main(String[] args) {

        String text = "This is is a repeated repeated word test.";
        String regex = "\\b(\\w+)\\b\\s+\\1\\b";

        Matcher m = Pattern.compile(regex).matcher(text);

        while (m.find()) {
            System.out.print(m.group(1) + ", ");
        }
    }
}