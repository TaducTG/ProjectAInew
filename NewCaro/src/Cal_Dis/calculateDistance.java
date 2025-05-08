package Cal_Dis;
import MoveSet.Point;

import java.util.ArrayList;
import java.util.List;
import static MoveSet.ATKMove.*;
import static MoveSet.Advance.CheckSurround;
import static MoveSet.Advance.FindBestloc;
import static MoveSet.DEFMove.checkSurround;
import static MoveSet.DEFMove.preventATK;
import static MoveSet.Move.*;
public class calculateDistance {
    public static List<Point> CanATK = new ArrayList();
    public static List<Point> A = new ArrayList<>();
    public static int mark = 0;
    public static int cal(Point tmp, int[][] E, int a) {
        int x = tmp.getX();
        int y = tmp.getY();
        int score = 0;
        int b = 0;
        if(a == 1){
            b = 2;
        }
        if(a == 2){
            b = 1;
        }
        int alpha = CheckSurround(tmp, E, 1); // dùng để check với X

        int beta = CheckSurround(tmp, E,2);  // dùng để check với O

        int gamma = CheckSurround(tmp, E, 3); // dùng để check với X trong lượt của O (xét khả năng tấn công)

        int epsilon = FindBestloc(tmp,E,2);
        // ATK
        // Hàng ngang
        score += checkHangNgang(tmp, E, a);
        // Hàng dọc
        score += checkHangDoc(tmp, E, a);
        // Đường chéo 1
        score += checkDuongcheo1(tmp, E, a);
        // Đường chéo 2
        score += checkDuongcheo2(tmp, E, a);

        // DEF
        // Hàng ngang
        score += checkHangNgang(tmp, E, b);
        // Hàng dọc
        score += checkHangDoc(tmp, E, b);
        // Đường chéo 1
        score += checkDuongcheo1(tmp, E, b);
        // Đường chéo 2
        score += checkDuongcheo2(tmp, E, b);

        if(beta == 6 && a == 2){
            if (!CanATK.contains(tmp)) {
                CanATK.add(tmp);
            }
        }

        if (necessaryATK(tmp, E) == 0 && score < 5000) {
            score = score / 4;
        }
        if (a == 1) {
            if (score < 50000) {
                if(alpha != 0){
                    if(alpha == 1 || alpha == 3){
                        mark = 1;
                    }
                    score += 20000;
                    return score;
                }
            }
        }

        if (a == 2) {
            if (score <50000) {
                // Thứ tự xét
                //      1) Đánh các nước kết hợp 3,4 hoặc nước 4 chưa bị chặn
                //      2) Chặn các nước kết hợp 3,4 hoặc nước 3 chưa bị chặn của địch
                //      3) Đánh các nước kết hợp 3,3
                //      4) Chặn các nước kết hợp 3,3 của địch
                //      5) Đánh các nước tạo thế cờ
                //      6) Chặn các nước tạo thế cờ của địch



                //      1) Đánh các nước kết hợp 3,4 hoặc nước 4 chưa bị chặn
                if (beta == 1 || beta == 2 || beta == 3 ) {
                    // beta = 1 : nước 4 bị chặn 1 đầu
                    // beta = 2 : nuớc 3 chưa bị chặn 2 đầu
                    // beta = 3 : nước kết hợp 3 + 4
                    score += 20000;
                    return score; // Dừng hàm ngay khi có chiến thắng tuyệt đối
                }

                //      2) Chặn các nước kết hợp 3,4 hoặc nước 3 chưa bị chặn của địch
                if(gamma == 1 || gamma == 2 || gamma == 3){
                    // gamma được xét sau khi giả sử X đánh vào vị trí xét
                        // gamma = 1 : nước 4 bị chặn 1 đầu
                        // gamma = 2 : nuớc 3 chưa bị chặn 2 đầu
                        // gamma = 3 : nước kết hợp 3 + 4
                        // beta = 5: tạo được nước 3 hoặc 4 sau khi O đánh
                    //System.out.println(gamma);
                    score += 14000;
                    if(beta == 5){
                        score += 4000;
                    }
                    return score;
                }
                if(gamma == 5 && beta == 5){
                    // gamma = 5: nước 3 chưa bị chặn dạng _EX_XXE_ và X đánh vào 1 trong 2 vị trí E
                    // beta = 5: tạo được nước 3 hoặc 4 sau khi O đánh
                    score += 10000;
                    return score;
                }

                //      3) Đánh các nước kết hợp 3,3
                if (beta == 4) {
                    // beta = 4: tạo được nước 2 nước 3
                    score += 8000;
                    return score;
                }

                //      4) Chặn các nước kết hợp 3,3 của địch
                if(gamma == 4){
                    // gamma = 4: tạo được nước 2 nước 3
                    score += 6000;
                    return score;
                }
                //      5) Đánh các nước tạo thế cờ
                //      6) Chặn các nước tạo thế cờ của địch
                score += epsilon;
            }
        }

        tmp.setScore(score);
        return score;
    }
    public static void firstLayer(int i, int j, int[][] E) {
        int[][] D = new int[15][15];

        // Đặt giá trị cho mảng D dựa trên trạng thái của E
        for (int a = 0; a < 15; a++) {
            for (int b = 0; b < 15; b++) {
                if (E[a][b] == 1 || E[a][b] == 2) {
                    D[a][b] = 1;
                } else {
                    D[a][b] = 0;
                }
            }
        }

        // Kiểm tra vùng xung quanh (các ô từ (i-1, j-1) đến (i+1, j+1))
        for (int a = i - 1; a < i + 2; a++) {
            for (int b = j - 1; b < j + 2; b++) {
                if (a >= 0 && b >= 0 && a <= 14 && b <= 14 && E[a][b] == 0 && D[a][b] == 0) {
                    Point tmp = new Point(a, b,0,0);
                    A.add(tmp);
                    D[a][b] = 1;  // Đánh dấu ô đã được xét
                }
            }
        }
    }

    // Hàm secondLayer tương đương với C++ code
    public static void secondLayer(int i, int j, int[][] E) {
        int[][] D = new int[15][15];

        // Đặt giá trị cho mảng D dựa trên trạng thái của E
        for (int a = 0; a < 15; a++) {
            for (int b = 0; b < 15; b++) {
                if (E[a][b] == 1 || E[a][b] == 2) {
                    D[a][b] = 1;
                } else {
                    D[a][b] = 0;
                }
            }
        }

        // Kiểm tra vùng xung quanh mở rộng (các ô từ (i-6, j-6) đến (i+6, j+6))
        for (int a = i - 5; a < i + 5; a++) {
            for (int b = j - 5; b < j + 5; b++) {
                if (a >= 0 && b >= 0 && a <= 14 && b <= 14 && E[a][b] == 0 && D[a][b] == 0) {
                    Point tmp = new Point(a, b,0,0);
                    A.add(tmp);
                    D[a][b] = 1;  // Đánh dấu ô đã được xét
                }
            }
        }
    }

}

