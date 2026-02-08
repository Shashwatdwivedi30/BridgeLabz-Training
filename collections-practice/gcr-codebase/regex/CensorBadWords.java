public class CensorBadWords {
    public static void main(String[] args) {

        String text = "This is a damn bad example with some stupid words.";
        String badWords = "\\b(damn|stupid)\\b";

        text = text.replaceAll(badWords, "****");

        System.out.println(text);
    }
}