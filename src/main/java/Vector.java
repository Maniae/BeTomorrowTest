/**
 * Created by TOM on 04/01/2017.
 */
public class Vector {
    private int x;
    private int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector(Point p1, Point p2) {
        this.x = p2.getX()-p1.getX();
        this.y = p2.getY()-p1.getY();
    }

    public Vector orthogonal() {
        /* Return a new Vector that is directly orthogonal to this one */
        return new Vector(-this.y, this.x);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
