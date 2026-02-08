public class NormalizeSpaces {
    public static void main(String[] args) {

        String text = "This   is   an   example    with    multiple    spaces.";

        text = text.replaceAll("\\s{2,}", " ");

        System.out.println(text);
    }
}