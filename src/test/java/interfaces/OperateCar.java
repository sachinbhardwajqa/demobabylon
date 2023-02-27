package interfaces;

import com.sun.javafx.scene.traversal.Direction;

/*Interfaces
* Interface is a reference type, similar to class, that can contain only constants, method signatures, default methods, and nested types
*
* Method Body exist only for default methods and static methods
* Interfaces can not be instantiated - they can only be implemented by classes or extended by other interfaces*/
public interface OperateCar {
    // constant declarations, if any

    // method signatures

    // An enum with values RIGHT, LEFT
    int turn(Direction direction,
             double radius,
             double startSpeed,
             double endSpeed);
    int changeLanes(Direction direction,
                    double startSpeed,
                    double endSpeed);
    int signalTurn(Direction direction,
                   boolean signalOn);
    int getRadarFront(double distanceToCar,
                      double speedOfCar);
    int getRadarRear(double distanceToCar,
                     double speedOfCar);
    // more method signatures
}
