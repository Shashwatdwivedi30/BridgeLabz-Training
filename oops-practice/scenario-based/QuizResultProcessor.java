import java.util.*;

class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

public class QuizResultProcessor {
    public static int calculateScore(String[] correctAnswers, String[] userAnswers)
            throws InvalidQuizSubmissionException {

        if (correctAnswers.length != userAnswers.length) {
            throw new InvalidQuizSubmissionException(
                    "Number of answers does not match the quiz questions");
        }

        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }

    public static String getGrade(int score, int totalQuestions) {
        double percentage = (score * 100.0) / totalQuestions;

        if (percentage >= 90) return "A";
        else if (percentage >= 75) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 40) return "D";
        else return "F";
    }

    public static void main(String[] args) {

        String[] correctAnswers = {"A", "C", "B", "D", "A"};

        // List to store scores of multiple users
        List<Integer> allScores = new ArrayList<>();

        // Sample user submissions
        String[][] userSubmissions = {
                {"A", "C", "B", "D", "A"},   // user 1
                {"A", "B", "B", "D", "C"},   // user 2
                {"A", "C", "B"}              // invalid submission
        };

        for (int i = 0; i < userSubmissions.length; i++) {
            try {
                int score = calculateScore(correctAnswers, userSubmissions[i]);
                allScores.add(score);

                String grade = getGrade(score, correctAnswers.length);
                System.out.println("User " + (i + 1) +
                        " Score: " + score +
                        ", Grade: " + grade);

            } catch (InvalidQuizSubmissionException e) {
                System.out.println("User " + (i + 1) +
                        " Error: " + e.getMessage());
            }
        }

        System.out.println("All user scores: " + allScores);
    }
}