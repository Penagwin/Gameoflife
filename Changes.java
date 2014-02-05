import java.util.ArrayList;

/**
 * Created by penagwin on 2/4/14.
 */
public class Changes {
    public static ArrayList<Cells> changearr = new ArrayList<Cells>();
    String change;
    Cells current;

    public void change(Cells c, String s) {
        change = s;
        current = c;
        //changearr.add(this);
    }

    public void set(ArrayList<Cells> ar) {
        changearr = ar;
    }
}
