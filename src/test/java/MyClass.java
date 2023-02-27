public class MyClass {
    public static void main(String args[]) {
      String example = "abcbedrardea";
      String example1 = "abba";
      System.out.println(largestPalindromeSubstring(example1));
    }
    
    public static String largestPalindromeSubstring(String givenString){
        String largestPalindrome = "";
        for(int i=0; i<givenString.length() ;i++){ //5
            String temp = returnRequiredSubstring(givenString,i,i);
            if(temp.length()>largestPalindrome.length()){
                 largestPalindrome = temp;
            }
            
            String temp2 = returnRequiredSubstring(givenString,i,i+1);
            if(temp2.length()>largestPalindrome.length()){
                 largestPalindrome = temp2;
            }
        }
        
        return largestPalindrome;
    }
    
    //function to keep track of left and right index of given string 
    public static String returnRequiredSubstring(String givenString, int left, int right){
        while(left>=0 && right < givenString.length() && givenString.charAt(left) == givenString.charAt(right)){
            left--;
            right++;
        } //expanding my substring if expansion of it is palindrome
        
        return givenString.substring(left+1,right);
    }

    //a -- aba --- cabac
}