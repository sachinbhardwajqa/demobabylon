public class ReverseSentence {
    public static void main(String[] args) {
        /*
         * I am giving an interview to Sugarbox --> sugarbox to interview an giving am I
         * */
        String input = "I am giving an interview to Sugarbox";
        int left = 0;
        int right = input.length();
        char space = ' ';
        for(int i= input.length(); i>0;i--){
            if(space == input.charAt(i-1) || i==0){
                System.out.print(input.substring(i,right));
                if(right>0){
                    System.out.print(" ");
                    right = i-1;
                }
            }
        }
        if(input.charAt(right)==' '){
            System.out.print(input.substring(0,right));
        }
    }
}

