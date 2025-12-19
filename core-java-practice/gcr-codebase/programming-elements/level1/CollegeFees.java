public class CollegeFees {
    public static void main(String[] args) {
        int fee = 125000;
        float discountPercentage = 10;
        float discount = fee * (discountPercentage/100);
        float fees_to_pay = fee - discount;
        System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+fees_to_pay);
    }
}
