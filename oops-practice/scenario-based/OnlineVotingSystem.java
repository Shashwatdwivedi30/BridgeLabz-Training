import java.util.*;

class Voter {
    int id;
    String name;
    boolean hasVoted = false;

    Voter(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Candidate {
    int id;
    String name;
    int votes = 0;

    Candidate(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void addVote() {
        votes++;
    }
}

class Vote {
    Voter voter;
    Candidate candidate;

    Vote(Voter voter, Candidate candidate) {
        this.voter = voter;
        this.candidate = candidate;
    }
}

class DuplicateVoteException extends Exception {
    DuplicateVoteException(String message) {
        super(message);
    }
}

interface ElectionService {
    void registerVoter(Voter voter);
    void addCandidate(Candidate candidate);
    void castVote(Voter voter, Candidate candidate) throws DuplicateVoteException;
    void declareResult();
}

class ElectionServiceImpl implements ElectionService {
    Map<Integer, Voter> voters = new HashMap<>();
    Map<Integer, Candidate> candidates = new HashMap<>();
    List<Vote> votes = new ArrayList<>();

    public void registerVoter(Voter voter) {
        voters.put(voter.id, voter);
    }

    public void addCandidate(Candidate candidate) {
        candidates.put(candidate.id, candidate);
    }

    public void castVote(Voter voter, Candidate candidate) throws DuplicateVoteException {
        if (voter.hasVoted) {
            throw new DuplicateVoteException("Voter has already voted");
        }
        voter.hasVoted = true;
        candidate.addVote();
        votes.add(new Vote(voter, candidate));
        System.out.println("Vote cast successfully");
    }

    public void declareResult() {
        for (Candidate c : candidates.values()) {
            System.out.println(c.name + " : " + c.votes + " votes");
        }
    }
}

public class OnlineVotingSystem {
    public static void main(String[] args) {
        ElectionService election = new ElectionServiceImpl();

        Voter v1 = new Voter(1, "John");
        Voter v2 = new Voter(2, "Alice");

        Candidate c1 = new Candidate(101, "Candidate A");
        Candidate c2 = new Candidate(102, "Candidate B");

        election.registerVoter(v1);
        election.registerVoter(v2);

        election.addCandidate(c1);
        election.addCandidate(c2);

        try {
            election.castVote(v1, c1);
            election.castVote(v2, c2);
        } catch (DuplicateVoteException e) {
            System.out.println(e.getMessage());
        }

        election.declareResult();
    }
}