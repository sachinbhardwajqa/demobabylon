package abstractclass;

public class X {
    /* When an Abstract Class Implements an Interface

class that implements an interface must implement all of the interface's methods.
It is possible, however, to define a class that does not implement all of the interface's methods,
provided that the class is declared to be abstract.

For example,
abstract class X implements Y {
  // implements all but one method of Y
}
class XX extends X {
  // implements the remaining method in Y
}
In this case, class X must be abstract because it does not fully implement Y, but class XX does, in fact, implement Y.
    *
    Class Members
    An abstract class may have static fields and static methods.
    We can use these static members with a class reference
    (for example, AbstractClass.staticMethod()) as we would with any other class.
    */
}
