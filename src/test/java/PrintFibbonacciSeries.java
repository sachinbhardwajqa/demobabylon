public class PrintFibbonacciSeries {
    public static void main(String args[]) {
        //Current no should be sum of previous two numbers
      int a = 0, b = 1;
      int count = 20;
      System.out.println("Fibbonacci series : ");
      System.out.println(a);
      System.out.println(b);
      printFibbonacciSeries(count, a, b);
    }
    
    public static void printFibbonacciSeries(int n, int a, int b){
        if(n<2)
            return;
        for(int i=3; i<n+1;i++){
            int temp = a + b;
            System.out.println(temp);
            a = b;
            b = temp;
        }
    }
}