import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by penagwin on 2/3/14.
 */
class Run {

    public static void main(String[] args) throws IOException, CloneNotSupportedException, InterruptedException {
        ReadFile read = new ReadFile();
        read.run();
        Boolean stuff = true;
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        GUI g = new GUI();
        window.getContentPane().add(g);
        window.setVisible(true);
        ArrayList<Cells> clone = new ArrayList<Cells>();
        while (stuff) {
            stuff = Evolve(clone, window, g);
            int sleep = 1000;
            Thread.sleep(sleep);
        }
    }
    public static Boolean Evolve(ArrayList<Cells> clone, JFrame window, GUI g) {
        ArrayList<Cells> news = ReadFile.getArray();
        for (int row = 0; row <= g.width; row++) {
            for (int col = 0; col < g.height - 1; col++) {
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
        g.setArray(clone);
        window.repaint();
        clone.clear();
        return !ReadFile.getArray().isEmpty();
    }


}