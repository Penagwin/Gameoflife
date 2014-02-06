import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class GUI extends JComponent {
    private static ArrayList<Cells> empty = new ArrayList<Cells>();

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Image img1 = Toolkit.getDefaultToolkit().getImage("square.gif");
        int width = 1000;
        int height = 1000;
        boolean there = false;

        for (int col = 0; col < height - 1; col++) {
            for (int row = 0; row <= width; row++) {
                //Loop through all penguins
                for (Cells cell : getArray()) {
                    if (cell.y == col && cell.x == row) {
                        there = true;
                    }
                }
                if (there) {
                    g2.drawImage(img1, row*18, col*18, this);
                    there = false;
                } else {
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