import java.util.*;

public class ExamProctor {

    static Stack<Integer> navigationStack = new Stack<>();
    static HashMap<Integer, String> answers = new HashMap<>();

    static void visitQuestion(int questionId) {
        navigationStack.push(questionId);
        System.out.println("Visited Question: " + questionId);
    }

    static void submitAnswer(int questionId, String answer) {
        answers.put(questionId, answer);
        System.out.println("Answer saved for Q" + questionId);
    }

    static int calculateScore(HashMap<Integer, String> correctAnswers) {
        int score = 0;

        for (int qId : answers.keySet()) {
            if (answers.get(qId).equals(correctAnswers.get(qId))) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {

        visitQuestion(1);
        visitQuestion(2);
        visitQuestion(3);

        submitAnswer(1, "A");
        submitAnswer(2, "B");
        submitAnswer(3, "C");

        HashMap<Integer, String> correctAnswers = new HashMap<>();
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "C");
        correctAnswers.put(3, "C");

        int score = calculateScore(correctAnswers);
        System.out.println("Final Score: " + score);
    }
}