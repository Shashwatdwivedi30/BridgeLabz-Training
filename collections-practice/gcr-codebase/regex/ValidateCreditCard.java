public class ValidateCreditCard {
    public static void main(String[] args) {

        String card = "4111111111111111";

        String visa = "^4[0-9]{15}$";
        String master = "^5[0-9]{15}$";

        if (card.matches(visa))
            System.out.println("Valid Visa Card");
        else if (card.matches(master))
            System.out.println("Valid MasterCard");
        else
            System.out.println("Invalid Card");
    }
}