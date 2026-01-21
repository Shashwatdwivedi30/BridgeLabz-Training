import java.util.*;
public class StackUsingArrayList{
    static List<Integer> stack = new ArrayList<>();

    public void push(int data){
        stack.add(data);
        System.out.println(data+ " is added");
    }

    public int pop(){
        if(stack.isEmpty()){
            System.out.println("Stack has no elements to pop.");
            return -1;
        }
        return stack.remove(stack.size()-1);
    }

    public int peek(){
        if(stack.isEmpty()){
            System.out.println("Stack is empty.");
            return -1;
        }
        return stack.get(stack.size()-1);
    }

    public void display(){
        System.out.println("Stack is: ");
        System.out.println(stack);
    }

    public static void main(String[] args){
        StackUsingArrayList st = new StackUsingArrayList();
        st.push(10);
        st.push(20);
        st.push(30);
        st.display();
        System.out.println("Element is removed: "+st.pop());
        System.out.println("Peek element is: "+st.peek());
        st.display();
    }
}