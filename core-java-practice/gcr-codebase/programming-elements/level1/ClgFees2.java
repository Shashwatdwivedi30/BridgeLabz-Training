import java.util.*;
public class ClgFees2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int fee = input.nextInt();
        float discountPercentage = input.nextFloat();
        float discount = fee * (discountPercentage/100);
        float fees_to_pay = fee - discount;
        System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+fees_to_pay);
    }
}
