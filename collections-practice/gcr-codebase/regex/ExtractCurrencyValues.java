import java.util.regex.*;

public class ExtractCurrencyValues {
    public static void main(String[] args) {

        String text = "The price is $45.99, and the discount is 10.50.";
        String regex = "\\$?\\d+\\.\\d{2}";

        Matcher m = Pattern.compile(regex).matcher(text);

        while (m.find()) {
            System.out.print(m.group() + ", ");
        }
    }
}