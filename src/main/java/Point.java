/**
 * Created by TOM on 04/01/2017.
 */
public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point move(Vector v) {
        return new Point(this.x + v.getX(), this.y + v.getY());
    }

    public boolean isInside() {
        return x>=-1000 && y>=-1000 && x<=1000 && y<=1000;
    }

    @Override
    public String toString() {
        return "[" + this.x + "," + this.y + "]";
    }

    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;
        if (object != null && object instanceof Point) {
            isEqual = (this.x == ((Point) object).x && this.y == ((Point) object).y);
        }
        return isEqual;
    }
}
