import java.util.Stack;

public class Demo {
    public static void main(String[] args){
        System.out.println(ifPalindrome("malayalam"));
        System.out.println(ifPalindrome("aaaa"));
        System.out.println(ifPalindrome("abcdef"));
        //Given a string as input , we need to find out if the string is palindrome or not

        /* Method - isStringBalanceAndOrdered
        Balanced Input : {[[()[]]]}
        Unbalanced Input : [{]}()
        */
        System.out.println(isStringBalanceAndOrdered("{[[()[]]]}"));
        System.out.println(isStringBalanceAndOrdered("[{]}()"));
        System.out.println(isStringBalanceAndOrdered("{[[()[]]]}{}"));
    }

    public static boolean isStringBalanceAndOrdered(String str){
            Stack<Character> example = new Stack<>();
            for(char c : str.toCharArray()){
                switch (c) {
                    case '{':
                    case '[': //{[[()[]]]}
                    case '(':
                        example.push(c);
                        break;
                    case '}':
                        if(example.isEmpty() || example.pop()!='{')
                            return false;
                        break;
                    case ']':
                        if(example.isEmpty() || example.pop()!='[')
                            return false;
                        break;
                    case ')':
                        if(example.isEmpty() || example.pop()!='(')
                            return false;
                        break;
                    default:
                        break;
                }
            }
        return example.isEmpty();
    }

    public static String ifPalindrome(String input){
        String temp = "";
            for(int i = input.length()-1; i>=0;i--){
                temp = temp + input.charAt(i);
            }
        if (input.equalsIgnoreCase(temp))
            return "Given String "+input+" is Palindrome";
        else
            return "Given String "+input+" is not Palindrome";
    }
}
