import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by penagwin on 2/3/14.
 */
class ReadFile {
    private int r;
    private int x;
    private int y = 0;
    private static ArrayList<Cells> origin = new ArrayList<Cells>();
    public static ArrayList<Cells> empty = new ArrayList<Cells>();

    public void run() throws IOException {
        FileInputStream file = new FileInputStream("cells.txt");
        while ((r = file.read()) != -1) {
            char c = (char) r;
            if (String.valueOf(c).equals("\n")) {
                y++;
                x = 0;
            } else {
                if (String.valueOf(c).equals("X")) {
                    origin.add(new Cells(x, y));
                }
                x++;
            }

        }

    }
    public static ArrayList<Cells> getArray() {
        return origin;
    }

    public static void setArray(ArrayList<Cells> ar) {
        origin.clear();
        for (Cells item : ar) origin.add(item);
    }
}
