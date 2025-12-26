public class OTPGenerator {

    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }

    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true; 
    }

    public static void main(String[] args) {
        int[] otpArray = new int[10];

        for (int i = 0; i < otpArray.length; i++) {
            otpArray[i] = generateOTP();
        }

        System.out.println("Generated OTPs:");
        for (int i = 0; i < otpArray.length; i++) {
            System.out.println(otpArray[i]);
        }

        if (areOTPsUnique(otpArray)) {
            System.out.println("\nAll OTPs are unique.");
        } else {
            System.out.println("\nDuplicate OTPs found.");
        }
    }
}