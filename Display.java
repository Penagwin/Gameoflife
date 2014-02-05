//Layman terms 2,147,483,639 penguins. (That requires 8 GB of ram for the indexes alone.)

import java.util.ArrayList;

public class Display {

    //Init Vars
    //Width and height are the number of characters that it will display
    int width = 10;
    int height = 10;
    private boolean there = false;
    private int therea = -2;
    public static ArrayList<Cells> cells = new ArrayList<Cells>();
    public static ArrayList<Cells> debug = new ArrayList<Cells>();

    //Writing to the screen
    public void write() {
        print("\n");
        for (int col = 0; col < height - 1; col++) {
            for (int row = 0; row <= width; row++) {
                //Loop through all penguins
                for (Cells cell : cells) {
                    if (cell.y == col && cell.x == row) {
                        there = true;
                    }
                }
                if (there) {
                    print("X");
                    there = false;
                } else {
                    print(".");
                }

            }
            print("\n");

        }

    }

    public void debug() {
        print("\n");
        for (int col = 0; col < height - 1; col++) {
            for (int row = 0; row <= width; row++) {
                //Loop through all penguins
                for (Cells cell : debug) {
                    if (cell.y == col && cell.x == row) {
                        therea = cell.a;
                    }
                }
                if (therea == 0) {
                    print("X");
                    therea = -2;
                } else if (therea == 1) {
                    print("O");
                    therea = -2;
                } else {
                    print(".");
                }

            }
            print("\n");

        }
        debug.clear();
    }


    //'Cause I am lazy :P
    private static void print(Object s) {
        System.out.print(s);
    }
}
