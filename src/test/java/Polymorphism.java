public class Polymorphism {
    /*
    With super(), the superclass no-argument constructor is called.
    With super(parameter list), the superclass constructor with a matching parameter list is called.

    Note: If a constructor does not explicitly invoke a superclass constructor,
    the Java compiler automatically inserts a call to the no-argument constructor of the superclass.
    If the super class does not have a no-argument constructor, we will get a compile-time error.
    Object does have such a constructor, so if Object is the only superclass, there is no problem.

    If a subclass constructor invokes a constructor of its superclass, either explicitly or implicitly,
    we might think that there will be a whole chain of constructors called,
    all the way back to the constructor of Object.
    In fact, this is the case. It is called constructor chaining
    * */

    /*
        The methods inherited from Object that are discussed in this section are:

        protected Object clone() throws CloneNotSupportedException
              Creates and returns a copy of this object.
        public boolean equals(Object obj)
              Indicates whether some other object is "equal to" this one.
        protected void finalize() throws Throwable
              Called by the garbage collector on an object when garbage
              collection determines that there are no more references to the object
        public final Class getClass()
              Returns the runtime class of an object.
        public int hashCode()
              Returns a hash code value for the object.
        public String toString()
              Returns a string representation of the object.

      */

    /*
        The notify, notifyAll, and wait methods of Object all play a part in synchronizing the activities of
        independently running threads in a program
        There are five of these methods:

        public final void notify()
        public final void notifyAll()
        public final void wait()
        public final void wait(long timeout)
        public final void wait(long timeout, int nanos)

        Note: There are some subtle aspects to a number of these methods, especially the clone method.
    * */

}
