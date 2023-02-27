package inheritance;

public class Introduction {
    /*subclass, derived class, extended class, child class
    * superclass, base class, parent class
    *
    * Except Object, which has no superclass, every class has one and only one direct superclass(Single Inheritance)
    * Every class is implicitly a subclass of Object class
    *
    * A subclass inherits all the members (fields, methods, and nested classes ) from its superclass
    * Constructors are not members, so not inherited by subclasses
    *
    * Constructor of superclass can be invoked from the subclass
    * */

    /*Java Platform Class Hierarchy
    *
    * Object - java.lang
    *
    * Subclass inherit all of the public and protected members of its parent
    * also inherits the package-private members of the parent
    *
    * We can use inherited members as it is
    * replace
    * hide
    * supplement with new members
    *
    * * Can be used directly
    * * Can declare same name field in subclass, thus hiding it but not recommended
    * * Can declare new fields in subclass
    * * inherited methods can be used directly
    * * Can declare same name instance method with same signature, thus overriding it
    * * Can declare same name static method with same signature, thus hiding it
    * * Can declare new methods that are not in superclass
    * * Subclass constructor can invoke the superclass constructor wither implicitly or by using super keyword
    *
    * Private Members in Superclass
    * * Not inherited
    * * but superclass having public or protected methods for accessing its private fields can be used by subclass
    *
    * A nested class has access to all the private members of its enclosing class - both fields and methods
    * Therefore, a public or protected nested class inherited by a subclass has indirect access to
    * ********** all of the private members of the superclass
    *
    * CASTING
    *
    * Implicit and Explicit
    *
    * Object obj = new MountainBike(); //Implicit
    * MountainBike myBike = obj; //Explicit
    *
    * MountainBike myBike = (MountainBike)obj; //Runtime check which will throw run time exception if not same
    *
    * if(obj instanceof MountainBike){
    *   MountainBike myBike = (MountainBike)obj;
    * }
    *
    * */

}
