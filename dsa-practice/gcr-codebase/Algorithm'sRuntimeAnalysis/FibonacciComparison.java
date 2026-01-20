public class FibonacciComparison {
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;

        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 30; 

        long startRec = System.currentTimeMillis();
        int recResult = fibonacciRecursive(n);
        long endRec = System.currentTimeMillis();

        long startItr = System.currentTimeMillis();
        int itrResult = fibonacciIterative(n);
        long endItr = System.currentTimeMillis();

        System.out.println("Fibonacci Number: " + n);
        System.out.println("Recursive Result: " + recResult);
        System.out.println("Iterative Result: " + itrResult);

        System.out.println("Recursive Time: " + (endRec - startRec) + " ms");
        System.out.println("Iterative Time: " + (endItr - startItr) + " ms");
    }
}