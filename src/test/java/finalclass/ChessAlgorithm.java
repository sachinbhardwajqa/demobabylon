package finalclass;

public class ChessAlgorithm {
    enum ChessPlayer { WHITE, BLACK }
//    ...
    final ChessPlayer getFirstPlayer() {
        return ChessPlayer.WHITE;
    }
//    ...

    /*
    We can declare some or all of a class's methods final.
    We use the final keyword in a method declaration to indicate that the method cannot be overridden by subclasses.
    The Object class does this—a number of its methods are final.

    Methods called from constructors should generally be declared final.
    If a constructor calls a non-final method, a subclass may redefine that method
    with surprising or undesirable results.

    Note that we can also declare an entire class final.
    A class that is declared final cannot be subclassed.
    This is particularly useful, for example, when creating an immutable class like the String class.
    */
}
