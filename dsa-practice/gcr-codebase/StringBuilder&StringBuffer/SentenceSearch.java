public class SentenceSearch {
    public static String findSentence(String[] sentences, String word) {
        for (String s : sentences) {
            if (s.contains(word)) {
                return s;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "Java is fun",
            "I love programming",
            "Artificial Intelligence is the future"
        };

        String result = findSentence(sentences, "programming");
        System.out.println(result);
    }
}