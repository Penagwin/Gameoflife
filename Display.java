//Layman terms 2,147,483,639 penguins. (That requires 8 GB of ram for the indexes alone.)

import java.util.ArrayList;

class Display {

    //Init Vars
    //Width and height are the number of characters that it will display
    final int width = 50;
    final int height = 25;
    private boolean there = false;

    //Writing to the screen
    public void write(ArrayList<Cells> cells) {
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


    //'Cause I am lazy :P
    private static void print(Object s) {
        System.out.print(s);
    }
}
