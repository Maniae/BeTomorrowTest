import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by TOM on 04/01/2017.
 */
public class Main {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Please enter the path to the coordinates file as an argument");
            return;
        }
//        String file = "src/main/resources/exercice.txt";
        String file = args[0];
        List<Point> pointList = new ArrayList<Point>();
        try {
            try (Stream<String> stream = Files.lines(Paths.get(file))) {
                stream.forEach(s -> {
                    String[] pos = s.split(" ");
                    if (pos.length > 1 && !"".equals(pos[0])) {
                        Point p = new Point(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]));
                        pointList.add(p);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        SquareFinder squareFinder = new SquareFinder();
        List<Point[]> squareList = squareFinder.findSquares(pointList);

        System.out.println("Done. " + squareList.size() + " squares found");
    }
}
