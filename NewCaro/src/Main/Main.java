package Main;
import static MachineMoveChoice.SelectMove.*;

import View.View;
public class Main {
    public static void main(String[] args) {
        new View("GAME CARO"); // gọi chương trình
        // Khởi tạo mảng E
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 24; j++) {
                E[i][j] = 0;
                map[i][j] = 0;
            }
        }
    }
}