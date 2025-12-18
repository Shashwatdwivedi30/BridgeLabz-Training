import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float number1 = input.nextFloat();
        float number2 = input.nextFloat();
        float sum = number1 + number2;
        float difference = number1 - number2;
        float multiplication = number1 * number2;
        float division = number1 / number2;
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+number1+" and "+number2+" is "+sum+" , "+difference+" , "+multiplication+" and "+division);
    }
}
