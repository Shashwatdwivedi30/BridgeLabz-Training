import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        HashMap<String, Integer> voteMap = new HashMap<>();

        LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();

        castVote("Alice", voteMap, voteOrder);
        castVote("Bob", voteMap, voteOrder);
        castVote("Alice", voteMap, voteOrder);
        castVote("Charlie", voteMap, voteOrder);

        System.out.println("Vote Map (HashMap): " + voteMap);
        System.out.println("Vote Order (LinkedHashMap): " + voteOrder);

        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteMap);
        System.out.println("Sorted Results (TreeMap): " + sortedResults);
    }

    static void castVote(String candidate, HashMap<String, Integer> voteMap, LinkedHashMap<String, Integer> voteOrder) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteMap.get(candidate));
    }
}