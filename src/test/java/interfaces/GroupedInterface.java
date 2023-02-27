package interfaces;

public interface GroupedInterface { //Interface1, Interface2, Interface3 Can extend multiple interfaces

    // constant declarations
    
    // base of natural logarithms
    double E = 2.718282;
 
    // method signatures
    void doSomething (int i, double x);
    int doSomethingElse(String s);
}
/*Interface Body
* Abstract methods - followed by semicolon but no braces
* Default methods - with default modifier
* static methods - with static keyword
* Can contain constant declarations also which are implicitly public static final
* All above methods are implicitly public */