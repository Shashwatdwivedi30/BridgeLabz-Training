public class ProfitLoss {
    public static void main(String[] args) {
        int CP = 129;
        int SP = 191;
        int profit = SP - CP;
        float profitPercentage = ((float) profit /CP)*100f;
        System.out.println("The Cost Price is INR "+CP+" and Selling Price is INR "+SP+"\nThe Profit is INR "+profit+" and the Profit Percentage is "+profitPercentage);
    }
}
