import java.util.*;
public class StockSpan {
    public static int[] calculateSpan(int[] prices){
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();

        span[0] = 0;
        st.push(0);

        for(int i = 0; i < n; i++){
            // Pop prices smaller or equal to current
            while(!st.isEmpty() && prices[st.peek()] <= prices[i]){
                st.pop();
            }

            // If stack empty, price is greater than all previous
            span[i] = st.isEmpty() ? (i+1) : (i - st.peek());

            st.push(i);
        }
         return span;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int[] span = calculateSpan(prices);

        System.out.println("Stock Span:");
        for (int s : span) {
            System.out.print(s + " ");
        }

        sc.close();
    }
}
