import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class GUI extends JComponent {
    private static ArrayList<Cells> empty = new ArrayList<Cells>();
    public int width = 100;
    public int height = 100;
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Image img1 = Toolkit.getDefaultToolkit().getImage("square.gif");
        Image img12 = Toolkit.getDefaultToolkit().getImage("square2.gif");


        boolean there = false;

        for (int col = 0; col < height - 1; col++) {
            for (int row = 0; row <= width; row++) {
                for (Cells cell : getArray()) {
                    if (cell.y == col && cell.x == row) {
                        there = true;
                    }
                }
                if (there) {
                    g2.drawImage(img1, row*18+2, col*18+2, this);
                    there = false;
                } else {
                    g2.drawImage(img12, row*18+2, col*18+2, this);

                }

            }

        }
        g2.finalize();
    }
    public static ArrayList<Cells> getArray() {
        return empty;
    }

    public static void setArray(ArrayList<Cells> ar) {
        empty.clear();
        for (Cells item : ar) empty.add(item);
    }
}