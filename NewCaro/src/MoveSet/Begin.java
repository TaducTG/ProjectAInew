package MoveSet;

import Test.Main;

public class Begin {
    public static int firstLoc_x = 0;
    public static int firstLoc_y = 0;
    private static double branch = 0.0;
    public static Point BeginMove(){
        Point tmp = new Point(0,0);
        if(Main.startMove == 1 && Main.E[7][7] == 2){
            firstLoc_x = 7;
            firstLoc_y = 7;
            if(Main.E[6][6] == 1 || Main.E[8][6] == 1){
                branch = 1.1;
                Point a = new Point(7,5);
                return a;
            }
            if(Main.E[6][8] == 1 || Main.E[8][8] == 1){
                branch = 1.1;
                Point a = new Point(7,90);
            }



            if(Main.E[7][6] == 1){
                branch = 1.21;
                Point a = new Point(9,9);
                return a;
            }
            if(Main.E[7][8] == 1){
                branch = 1.22;
                Point a = new Point(6,6);
                return a;
            }
            if(Main.E[6][7] == 1){
                branch = 1.23;
                Point a = new Point(9,5);
                return a;
            }
            if(Main.E[8][7] == 1){
                branch = 1.24;
                Point a = new Point(5,9);
                return a;
            }




        }
        return tmp;
    }
}
