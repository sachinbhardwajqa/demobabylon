package interfaces;

import java.awt.*;

public class RectanglePlus implements Relatable{
    public int width = 0;
    public int height = 0;
    public Point origin;

    public RectanglePlus(){
        origin = new Point(0,0);
    }

    public RectanglePlus(Point p){
        origin = p;
    }

    public RectanglePlus(int w, int h){
        origin = new Point(0,0);
        width = w;
        height = h;
    }

    public RectanglePlus(Point p, int w, int h){
        origin = p;
        width = w;
        height = h;
    }

    public void move(int x, int y){
        origin.x = x;
        origin.y = y;
    }

    public int getArea(){
        return width*height;
    }

    @Override
    public int isLargerThan(Relatable other) {
        RectanglePlus otherRect = (RectanglePlus) other; //casts other to a RectanglePlus instance
        if(this.getArea() < otherRect.getArea())
            return -1;
        else if(this.getArea() > otherRect.getArea())
            //Invoking getArea directly on the other instance would fail otherwise to compile
            //because the compiler does not understand that other is actually an instance of RechtanglePlus
            return 1;
        else
            return 0;
    }

    public Object findLargest(Object object1, Object object2) {
        Relatable obj1 = (Relatable)object1; //By casting object1 to a Relatable type, it can invoke the isLargerThan method
        Relatable obj2 = (Relatable)object2;
        if ((obj1).isLargerThan(obj2) > 0)
            return object1;
        else
            return object2;
    }

    public Object findSmallest(Object object1, Object object2){
        Relatable obj1 = (Relatable) object1;
        Relatable obj2 = (Relatable) object2;

        if((obj1).isLargerThan(obj2) < 0)
            return object1;
        else
            return object2;
    }

    public boolean isEqual(Object object1, Object object2){
        Relatable obj1 = (Relatable) object1;
        Relatable obj2 = (Relatable) object2;

        if((obj1).isLargerThan(obj2) == 0)
            return true;
        else
            return false;
    }
}
