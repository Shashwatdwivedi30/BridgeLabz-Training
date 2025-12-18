public class PensDistribution {
    public static void main(String[] args) {
        int pens = 14;
        int students = 3;
        int remaining_pens = pens % students;
        int pens_dist = (pens-remaining_pens)/students;
        System.out.println("The Pen Per Student is "+pens_dist+" and the remaining pen not distributed is "+remaining_pens);
    }
}
