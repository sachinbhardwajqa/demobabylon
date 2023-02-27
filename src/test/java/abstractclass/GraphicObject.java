package abstractclass;
/*
An abstract class is a class that is declared abstract
it may or may not include abstract methods.
Abstract classes cannot be instantiated, but they can be subclassed.

An abstract method is a method that is declared without an implementation
(without braces, and followed by a semicolon), like this:

abstract void moveTo(double deltaX, double deltaY);

If a class includes abstract methods, then the class itself must be declared abstract, as in:
*/
public abstract class GraphicObject {
   // declare fields
   // declare nonabstract methods
   abstract void draw();
}
/*
When an abstract class is subclassed,
the subclass usually provides implementations for all of the abstract methods in its parent class.
However, if it does not, then the subclass must also be declared abstract.

Note:
Methods in an interface that are not declared as default or static are implicitly abstract,
so the abstract modifier is not used with interface methods.
*/


/*
* Abstract classes are similar to interfaces.
* We cannot instantiate them, and they may contain a mix of methods declared with or without an implementation.
*
* However, with abstract classes, we can declare fields that are not static and final,
* and define public, protected, and private concrete methods.
*
* With interfaces, all fields are automatically public, static, and final,
* and all methods that you declare or define (as default methods) are public.
*
* In addition, we can extend only one class, whether or not it is abstract,
* whereas we can implement any number of interfaces.
*
* An example of an abstract class in the JDK is AbstractMap,
* which is part of the Collections Framework.
* Its subclasses (which include HashMap, TreeMap, and ConcurrentHashMap) share
* many methods (including get, put, isEmpty, containsKey, and containsValue) that AbstractMap defines.
*
* An example of a class in the JDK that implements several interfaces is HashMap,
* which implements the interfaces Serializable, Cloneable, and Map<K, V>.
* By reading this list of interfaces,
* we can infer that an instance of HashMap can be cloned,
* is serializable (which means that it can be converted into a byte stream),
* and has the functionality of a map.
*
* In addition, the Map<K, V> interface has been enhanced with many default methods
* such as merge and forEach that older classes that have implemented this interface do not have to define.
*
* *
* *
* Note that many software libraries use both abstract classes and interfaces;
* the HashMap class implements several interfaces and also extends the abstract class AbstractMap.

 */
