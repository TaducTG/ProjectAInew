import view.View;
import static machineMoveChoice.SelectMove.*;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                E[i][j] = 0;
                map[i][j] = 0;
            }
        }
        new View("GAME CARO"); // gọi chương trình
        // Khởi tạo mảng E
    }
}
