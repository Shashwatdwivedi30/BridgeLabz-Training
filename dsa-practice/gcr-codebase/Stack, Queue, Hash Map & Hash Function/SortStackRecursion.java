import java.util.Stack;

public class SortStackRecursion {
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();         
        sortStack(stack);              
        insertSorted(stack, top);      
    }

    // Function to insert element in sorted order
    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        int top = stack.pop();
        insertSorted(stack, element);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Before Sorting: " + stack);
        sortStack(stack);
        System.out.println("After Sorting: " + stack);
    }
}