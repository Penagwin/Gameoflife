import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by penagwin on 2/3/14.
 */
public class Run {
    private static int neighbors;
    private static Cells last;
    private static int sleep = 250;

    public static void main(String[] args) throws IOException, CloneNotSupportedException, InterruptedException {
        Display d = new Display();
        ReadFile read = new ReadFile();
        read.run(d);
        ArrayList<Cells> clone = new ArrayList<Cells>(d.cells.size());
        while (true) {
            Evolve(clone, d);
            Thread.sleep(sleep);
        }
    }

    private static void Evolve(ArrayList<Cells> clone, Display d) {
        clone.clear();
        for (Cells item : d.cells) clone.add(item);

        for (int row = 0; row <= d.width; row++) {
            for (int col = 0; col < d.height - 1; col++) {
                last = null;
                neighbors = 0;
                for (Cells celli : d.cells) {

                    if (celli.y == col - 1 && celli.x == row) {
                        add(celli.x, celli.y, d);
                        neighbors++;
                    }
                    if (celli.y == col - 1 && celli.x == row + 1) {
                        add(celli.x, celli.y, d);
                        neighbors++;
                    }
                    if (celli.y == col - 1 && celli.x == row - 1) {
                        add(celli.x, celli.y, d);
                        neighbors++;
                    }
                    if (celli.y == col && celli.x == row + 1) {
                        add(celli.x, celli.y, d);
                        neighbors++;
                    }
                    if (celli.y == col && celli.x == row - 1) {
                        add(celli.x, celli.y, d);
                        neighbors++;
                    }
                    if (celli.y == col + 1 && celli.x == row + 1) {
                        add(celli.x, celli.y, d);
                        neighbors++;
                    }
                    if (celli.y == col + 1 && celli.x == row - 1) {
                        add(celli.x, celli.y, d);
                        neighbors++;
                    }
                    if (celli.y == col + 1 && celli.x == row) {
                        add(celli.x, celli.y, d);
                        neighbors++;
                    }
                    if (celli.y == col && celli.x == row) {
                        last = celli;
                    }


                }
               /* Use for debugging

               if (row == 6 && col == 2) {
                    d.debug.add(new Cells(row, col, 1));
                    d.debug();
                }
                */
                if (neighbors != 0)
                    System.out.println(neighbors);
                if (neighbors == 3) {
                    clone.add(new Cells(row, col));
                }
                if (neighbors < 2 && last != null) {
                    clone.remove(last);
                }
                if (neighbors > 3 && last != null) {
                    clone.remove(last);
                }


            }
        }
        d.cells.clear();
        for (Cells item : clone) d.cells.add(item);
        d.write();
    }

    public static void add(int row, int col, Display d) {
        d.debug.add(new Cells(row, col));

    }
}