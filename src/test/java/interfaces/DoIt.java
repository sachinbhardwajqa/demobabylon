package interfaces;

public interface DoIt {
   void doSomething(int i, double x);
   int doSomethingElse(String s);

   /*
   * We can also define static methods to existing interfaces
   *
   * default boolean didItWork(int i, double x, String s) { Method body }
   *
   * Default methods enable us to add new functionality to the interfaces of our libraries
   * and ensure binary compatibility with code written for older versions of those interfaces
   *
   * So basically classes that implement interfaces enhanced with new default of static methods do not have to modify or re-compile to accommodate the additional methods
   *
   * And other way is we can create new interface which extend the existing interface
   * */
}