import java.util.*;

abstract class JobRole{
    abstract String getRoleName();
    abstract int requiredExperience();
}

class SoftwareEngineer extends JobRole{
    String getRoleName(){
        return "Software Engineer";
    }

    int requiredExperience(){
        return 2;
    }
}

class DataScientist extends JobRole{
    String getRoleName(){
        return "Data Scientist";
    }

    int requiredExperience(){
        return 3;
    }
}

class ProductManager extends JobRole{
    String getRoleName(){
        return "Data Scientist";
    }

    int requiredExperience(){
        return 5;
    }
}

//generic resume
class Resume<T extends JobRole>{
    private String candidateName;
    private int experience;
    private T jobRole;

    public Resume(String candidateName, int experience, T jobRole){
        this.candidateName = candidateName;
        this.experience = experience;
        this.jobRole = jobRole;
    }

    public String getCandidateName(){
        return candidateName;
    }

    public int getExperience(){
        return experience;
    }

    public T getJobRole(){
        return jobRole;
    }
}

class ResumeScreeningAI {
    public static <T extends JobRole> void screenResume(Resume<T> resume){
        System.out.println("Candidate: "+resume.getCandidateName());
        System.out.println("Role: "+resume.getJobRole().getRoleName());

        if(resume.getExperience() >= resume.getJobRole().requiredExperience()){
            System.out.println("Status:  Shortlisted\n");
        }

        else{
            System.out.println("Status: Rejected\n");
        }
    }

    public static void bulkScreen(List<Resume<? extends JobRole>> resumes){
        for(Resume<? extends JobRole> r : resumes){
            screenResume(r);
        }
    }
}


public class ResumeScreeningSystem{
    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>("Shashwat", 3, new SoftwareEngineer());

        Resume<DataScientist> r2 = new Resume<>("Vivek", 2, new DataScientist());

        Resume<ProductManager> r3 = new Resume<>("Prince", 6, new ProductManager());

        List<Resume<? extends JobRole>> resumeList = new ArrayList<>();
        resumeList.add(r1);
        resumeList.add(r2);
        resumeList.add(r3);

        ResumeScreeningAI.bulkScreen(resumeList);
    }
}