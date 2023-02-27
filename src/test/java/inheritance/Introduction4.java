package inheritance;

public class Introduction4 {
    /*Interface Methods
    * Default method and abstract methods in interfaces are inherited like instance methods
    *
    * When the supertypes of a class or interface provide multiple default methods with the same signature,
    * Java compiler follows inheritance rules to resolve the name conflict
    *
    * Two principles
    * * Instance methods are preferred over interface default methods
    *
        public class Horse {
            public String identifyMyself() {
                return "I am a horse.";
            }
        }
        public interface Flyer {
            default public String identifyMyself() {
                return "I am able to fly.";
            }
        }
        public interface Mythical {
            default public String identifyMyself() {
                return "I am a mythical creature.";
            }
        }
        public class Pegasus extends Horse implements Flyer, Mythical {
            public static void main(String... args) {
                Pegasus myApp = new Pegasus();
                System.out.println(myApp.identifyMyself());
            }
        }
    * The method Pegasus.identifyMyself returns the string I am a horse.
    *
    *
    * * Methods that are already overridden by other candidates are ignored
    * This can arise when supertypes share a common ancestor
    *
        public interface Animal {
            default public String identifyMyself() {
                return "I am an animal.";
            }
        }
        public interface EggLayer extends Animal {
            default public String identifyMyself() {
                return "I am able to lay eggs.";
            }
        }
        public interface FireBreather extends Animal { }
        public class Dragon implements EggLayer, FireBreather {
            public static void main (String... args) {
                Dragon myApp = new Dragon();
                System.out.println(myApp.identifyMyself());
            }
        }
        The method Dragon.identifyMyself returns the string I am able to lay eggs.
    *
    *
    *
    *
    * If two or more independently defined default methods conflict, or a default method
    * conflicts with an abstract method,
    * then the Java compiler produces a compiler error.
    * We must explicitly override the supertype methods.
    *
        public interface OperateCar {
            // ...
            default public int startEngine(EncryptedKey key) {
                // Implementation
            }
        }
        public interface FlyCar {
            // ...
            default public int startEngine(EncryptedKey key) {
                // Implementation
            }
        }
        * A class that implements both OperateCar and FlyCar must override the method startEngine.
        * We could invoke any of the of the default implementations with the super keyword.

        public class FlyingCar implements OperateCar, FlyCar {
            // ...
            public int startEngine(EncryptedKey key) {
                FlyCar.super.startEngine(key);
                OperateCar.super.startEngine(key);
            }
        }
        * The name preceding super (in this example, FlyCar or OperateCar) must refer to
        * a direct superinterface that defines or inherits a default for the invoked method.
        *
        * This form of method invocation is not restricted to differentiating between multiple implemented interfaces
        * that contain default methods with the same signature.
        * We can use the super keyword to invoke a default method in both classes and interfaces.
    *
    * Inherited instance methods from classes can override abstract interface methods.
            public interface Mammal {
                String identifyMyself();
            }
            public class Horse {
                public String identifyMyself() {
                    return "I am a horse.";
                }
            }
            public class Mustang extends Horse implements Mammal {
                public static void main(String... args) {
                    Mustang myApp = new Mustang();
                    System.out.println(myApp.identifyMyself());
                }
            }
            The method Mustang.identifyMyself returns the string I am a horse.
            * The class Mustang inherits the method identifyMyself from the class Horse,
            * which overrides the abstract method of the same name in the interface Mammal.

            Note: Static methods in interfaces are never inherited.
    * */
}
