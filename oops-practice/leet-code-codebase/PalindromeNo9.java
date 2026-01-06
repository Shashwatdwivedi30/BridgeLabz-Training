//Problem number 09 : Palindrome Number 
public class PalindromeNo9 {
    public boolean isPalindrome(int x) {
        int no=0;
        int a=x;
        while(a!=0){
            int d=a%10;
            no=no*10+d;
            a=a/10;
        }
        if(x!=no || x<0)
            return false;
        else
           return true;
    }
}