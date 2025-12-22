public class NullPointerExceptionDemo {
    
    public static void generateException() {
        String text = null;
        System.out.println(text.length()); // This will throw NullPointerException
    }
    
    // Method to demonstrate NullPointerException handling
    public static void demonstrateException() {
        String text = null;
        try {
            System.out.println("Length of text: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Exception caught: " + e.getMessage());
            System.out.println("Error: Cannot call method on null reference");
        }
    }
    
    public static void main(String[] args) {
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
        demonstrateException();
    }
}