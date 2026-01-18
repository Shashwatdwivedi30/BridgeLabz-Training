public class SearchWordInSentences {
    public static void main(String[] args) {
        String[] sentences = {
                "Java is a powerful language",
                "I love data structures",
                "Linear search is simple",
                "Practice makes perfect"
        };

        String word = "search";

        String result = linearSearch(sentences, word);
        System.out.println(result);
    }

    public static String linearSearch(String[] sentences, String word) {

        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }
}