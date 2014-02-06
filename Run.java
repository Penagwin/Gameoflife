import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by penagwin on 2/3/14.
 */
class Run {

    public static void main(String[] args) throws IOException, CloneNotSupportedException, InterruptedException {
        Display d = new Display();
        ReadFile read = new ReadFile();
        read.run();
        Boolean stuff = true;
        ArrayList<Cells> clone = new ArrayList<Cells>();
        while (stuff) {
            stuff = Evolve(clone, d);
            int sleep = 250;
            Thread.sleep(sleep);
        }
    }
    private static Boolean Evolve(ArrayList<Cells> clone, Display d) {
        ArrayList<Cells> news = ReadFile.getArray();
        for (int row = 0; row <= d.width; row++) {
            for (int col = 0; col < d.height - 1; col++) {
                Cells last = null;
                int neighbors = 0;
                for (Cells celli : news) {
                    if (celli.y == col && celli.x == row)
                        last = celli;
                    if (celli.y == col - 1 && celli.x == row)
                        neighbors++;
                    if (celli.y == col - 1 && celli.x == row + 1)
                        neighbors++;
                    if (celli.y == col - 1 && celli.x == row - 1)
                        neighbors++;
                    if (celli.y == col && celli.x == row + 1)
                        neighbors++;
                    if (celli.y == col && celli.x == row - 1)
                        neighbors++;
                    if (celli.y == col + 1 && celli.x == row + 1)
                        neighbors++;
                    if (celli.y == col + 1 && celli.x == row - 1)
                        neighbors++;
                    if (celli.y == col + 1 && celli.x == row)
                        neighbors++;
                }
                if (neighbors == 3)
                    clone.add(new Cells(row, col));
                if (neighbors == 2 && last != null)
                    clone.add(new Cells(row, col));
                if (neighbors < 2 && last != null)
                    clone.remove(last);
                if (neighbors > 3 && last != null)
                    clone.remove(last);
            }
        }
        ReadFile.setArray(clone);
        d.write(clone);
        clone.clear();
        return !ReadFile.getArray().isEmpty();
    }


}