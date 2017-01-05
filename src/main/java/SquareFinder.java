import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by TOM on 04/01/2017.
 */
public class SquareFinder {
    HashMap<String,Integer> checked;


    public List<Point[]> findSquares(List<Point> pointList) {
        List<Point[]> squareList = new ArrayList<Point[]>();
        /* A Map where we store the checked couples so there are not checked again
         * The point is to avoid having several Squares that are actually the same one
         * (like ABCD, BCAD, CDAB and DABC) */
        checked = new HashMap<String,Integer>();

        /* Matrix representation of the points */
        int[][] matrix = new int[2001][2001];

        /* Initialize the Matrix */
        for (Point p : pointList) {
            matrix[p.getX()+1000][p.getY()+1000] = 1;
        }

        for (Point p1 : pointList) {
            for (Point p2 : pointList) {
                /* We verify the couple hasn't already been checked, we prefer get over contains for performances */
                if (! (p1.equals(p2) || checked.getOrDefault(p1.toString()+p2.toString(), 0) == 1)) {
                    Vector v1 = new Vector(p1, p2);
                    /* To build our square, we need to find the directly orthogonal vector */
                    Vector v2 = v1.orthogonal();
                    Point p3 = p2.move(v2);
                    /* We verify that the point the found vector leads on is actually a known point */
                    if (p3.isInside() && matrix[p3.getX()+1000][p3.getY()+1000] == 1) {
                        addToChecked(p2,p3);
                        Vector v3 = v2.orthogonal();
                        Point p4 = p3.move(v3);
                        if (p4.isInside() && matrix[p4.getX()+1000][p4.getY()+1000] == 1) {
                            addToChecked(p3,p4);
                            addToChecked(p4,p1);
                            Point[] square = {p1, p2, p3, p4};
                            squareList.add(square);
                            System.out.println("square found : " + Arrays.toString(square));
                        }
                    }

                }
            }
        }
        return squareList;
    }

    private void addToChecked(Point p1, Point p2) {
        checked.put(p1.toString()+p2.toString(),1);
    }

}
