import java.util.*;

class Resume{
    private String name;
    private Set<String> skills;

    Resume(String name, Set<String> skills) throws InvalidResumeException{
        if (name == null || name.isEmpty() || skills == null || skills.isEmpty()) {
            throw new InvalidResumeException("Resume is missing name or skills");
        }

        this.name = name;
        this.skills = skills;
    }

    public String getName(){
        return name;
    }

    public Set<String> getSkills(){
        return skills;
    }
}

class InvalidResumeException extends Exception{
    public InvalidResumeException(String message){
        super(message);
    }
}

class ResumeSkillMatchComparator implements Comparator<Resume>{
    private Set<String> requiredSkills;

    public ResumeSkillMatchComparator(Set<String> requiredSkills){
        this.requiredSkills = requiredSkills;
    }

    @Override
    public int compare(Resume r1, Resume r2){
        long match1 = r1.getSkills().stream().filter(requiredSkills::contains).count();
        long match2 = r2.getSkills().stream().filter(requiredSkills::contains).count();
        return Long.compare(match2, match1);  //descending order
    }
}
public class ResumeShortlistingSystem {
    public static void main(String[] args) {
        try{
            List<Resume> resumes = new ArrayList<>();
            resumes.add(new Resume("Alice", Set.of("Java", "Spring", "SQL")));
            resumes.add(new Resume("Bob", Set.of("Python", "Machine Learning", "SQL")));
            resumes.add(new Resume("Charlie", Set.of("Java", "Docker", "AWS")));

            Set<String> requiredSkills = Set.of("Java", "SQL", "AWS");

            resumes.sort(new ResumeSkillMatchComparator(requiredSkills));

            System.out.println("Shortlisted Resumes: ");
            for(Resume r : resumes){
                long matches = r.getSkills().stream().filter(requiredSkills::contains).count();

                System.out.println(r.getName() + " - Matches: " +matches);
            }
        }
        catch(InvalidResumeException e){
            System.out.println("Error: " +e.getMessage());
        }
    }
}