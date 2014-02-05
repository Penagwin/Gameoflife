import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by penagwin on 2/3/14.
 */
public class ReadFile {
    FileInputStream file;
    int r;
    public int x, y = 0;
    String hnext = "";

    public void run(Display d) throws IOException {
        FileInputStream file = new FileInputStream("cells.txt");
        while ((r = file.read()) != -1) {
            char c = (char) r;
            if (String.valueOf(c).equals("\n")) {
                y++;
                x = 0;
            } else {
                if (String.valueOf(c).equals("X")) {
                    d.cells.add(new Cells(x, y));
                }
                x++;
            }

        }

    }
}
