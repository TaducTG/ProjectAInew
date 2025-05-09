package application;
import java.util.*;

import static calculateDistance.CalculateDistance.*;

import moveSet.*;
import view.View;
public class SelectMove {
    public static int turn = 0;
    public static int startMove = 0;
    public static int locx; //Vị trí máy đánh
    public static int locy; //VỊ trí máy đánh
    public static int[][] E = new int[20][20];
    public static double[][] map = new double[20][20];
    public static int choosemove;
    public static int choosemove2;
    public static int choosemove3;

    public static void main(String[] args) {
        turn +=1;
        new View("GAME CARO"); // gọi chương trình
        // Khởi tạo mảng E
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                E[i][j] = 0;
                map[i][j] = 0;
            }
        }
    }
    public static void machineTurn(){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                map[i][j] = 0;
            }
        }
        long startTime = System.nanoTime();
        startMove += 1;
        A.clear();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (E[i][j] == 1 || E[i][j] == 2) {
                    if (startMove < 2) {
                        firstLayer(i, j, E);
                    } else {
                        secondLayer(i, j, E);
                    }
                }
            }
        }
        Point tmp = Begin.BeginMove();
        if(tmp.getX() == 0 && tmp.getY() == 0){
            double max = 0;
            for (Point point : A) {
                point.setScore(cal(point, E, 2));
                if(point.getScore() > map[point.getX()][point.getY()]){
                    map[point.getX()][point.getY()] = point.getScore();
                }
                if (max < point.getScore()) {
                    max = point.getScore();
                }
            }
            List<Point> B = new ArrayList<>();  // Lưu các vị trí tốt nhất ở thời điểm 1 của O
            // => max(B) = vị trí đánh tốt nhất trong 1 nước của bản thân
            List<Point> C = new ArrayList<>();  // Lưu các vị trí tốt nhất ở thời điểm 1 của X
            // => max(B) * min(C) => vị trí đánh tốt nhất trong 1 nước của bản thân
            //                      để đối thủ không đánh được điểm cao nhất
            List<Point> D = new ArrayList<>();  // Lưu các vị trí tốt nhất ở thời điểm 2 của O
            // => max(B) * (min(C) < x) * max(D) => vị trí đánh tốt nhất trong 2 nước của bản thân
            //                                      với điều kiện đối thủ không có khả năng tấn công lượt sau



            List<Point> F = new ArrayList<>();  // Lưu các vị trí tốt nhất ở thời điểm 2 của X
            List<Point> G = new ArrayList<>();
            // Chưa dùng
            List<Point> H = new ArrayList<>();
            List<Point> I = new ArrayList<>();
            for (Point item : A) {
                if (item.getScore() >= max * 0.85) {
                    B.add(item);
                }
            }
            // Tiến hành lọc theo alpha-beta pruning

            int location = 0;
            double C_min = 99999;
            for (int k = 0; k < B.size(); k++) {
                A.clear();
                CanATK.clear();
                B.get(k).setRank(k + 1);
                E[B.get(k).getX()][B.get(k).getY()] = 2; // Giả định 1 điểm trong mảng B được đánh
                secondLayer(B.get(k).getX(), B.get(k).getY(), E); // Thêm các điểm vào mảng A
                double A_max = 0;
                for (Point point : A) {
                    point.setScore(cal(point, E, 1));
                    if (A_max < point.getScore()) {
                        A_max = point.getScore();
                    }
                }
                for (Point point : A) {
                    if (point.getScore() > A_max * 0.9) {
                        C.add(point); // Thêm các điểm có điểm số cao vào C
                    }
                }
                for (Point point : C) {
                    if (point.getScore() < C_min) {
                        C_min = point.getScore();
                        location = k; // Lưu vị trí của điểm trong mảng B mà dẫn tới C_min
                    }
                }
//                if (!CanATK.isEmpty()) {
//                    for (Point point : CanATK) {
//                        point.setScore(cal(point, E, 1));
//                        if (point.getScore() > 4000) {
//                            point.setRank(-1);
//                        }
//                    }
//                }
                if(!CanATK.isEmpty() && mark == 0){
                    C.clear();
                    for (Point point : CanATK) {
                        //point.setScore(cal(point, E, 1));
                        System.out.println(point.getX() + " " + point.getY());
                        if(point.getScore() < 4000){
                            C.add(point);
                        }
                    }
                }
//                System.out.println(C_min);
                if(C_min <= 4000 && k == B.size() - 1){
                    // depth = 3
                    for(int l = 0;l<C.size();l++){
                        A.clear();
                        CanATK.clear();
                        E[C.get(l).getX()][C.get(l).getY()] = 1;
                        secondLayer(C.get(l).getX(), C.get(l).getY(), E);
                        for (Point point : A) {
                            point.setScore(cal(point, E, 2));
                            if (point.getScore() >= 4000) {
                                D.add(point);
                                choosemove = C.get(l).getRank();
                            }
                        }
                        for(int m = 0;m<D.size();m++){ // depth = 4
                            A.clear();
                            CanATK.clear();
                            E[D.get(m).getX()][D.get(m).getY()] = 2;
                            secondLayer(D.get(m).getX(), D.get(m).getY(), E);
                            double maxF = 0;
                            for (Point point : A) {
                                point.setScore(cal(point, E, 1));
                                if (point.getScore() > maxF) {
                                    maxF = point.getScore();
                                }
                            }
                            for (Point value : A) {
                                if (value.getScore() > maxF*0.9) {
                                    F.add(value);
                                }
                            }
                            double minF = 99999;
                            for (Point value : F) {
                                if(value.getScore() < minF){
                                    minF = value.getScore();
                                    choosemove2 = D.get(m).getRank();
                                }
                            }
                            if(minF <= 2000 && m == D.size() - 1){ // depth = 5
                                for(int n = 0;n<F.size();n++){
                                    A.clear();
                                    CanATK.clear();
                                    E[F.get(n).getX()][F.get(n).getY()] = 1;
                                    firstLayer(F.get(n).getX(), F.get(n).getY(), E);
                                    for (Point point : A) {
                                        point.setScore(cal(point, E, 2));
                                        if (point.getScore() >= 6000) {
                                            G.add(point);
                                            choosemove3 = F.get(n).getRank();
                                        }
                                    }
                                    E[F.get(n).getX()][F.get(n).getY()] = 0;
                                }
                            }
                            E[D.get(m).getX()][D.get(m).getY()] = 0;
                        }
                        E[C.get(l).getX()][C.get(l).getY()] = 0;
                    }
                }
                E[B.get(k).getX()][B.get(k).getY()] = 0; // Xóa giả định
            }
            if(!G.isEmpty()){
                E[B.get(choosemove3).getX()][B.get(choosemove3).getY()] = 2;
                locx = B.get(choosemove3).getX();
                locy = B.get(choosemove3).getY();
                System.out.println(B.get(choosemove3).getX() + " " + B.get(choosemove3).getY() + " " + B.get(choosemove3).getScore() +"***");
            }
            else if(!F.isEmpty()){
                E[B.get(choosemove2).getX()][B.get(choosemove2).getY()] = 2;
                locx = B.get(choosemove2).getX();
                locy = B.get(choosemove2).getY();
                System.out.println(B.get(choosemove2).getX() + " " + B.get(choosemove2).getY() + " " + B.get(choosemove2).getScore() +"**");
            }
            else if(!D.isEmpty()){
                E[B.get(choosemove).getX()][B.get(choosemove).getY()] = 2;
                locx = B.get(choosemove).getX();
                locy = B.get(choosemove).getY();
                System.out.println(B.get(choosemove).getX() + " " + B.get(choosemove).getY() + " " + B.get(choosemove).getScore() +"*");
            }
            else {
                E[B.get(location).getX()][B.get(location).getY()] = 2; // Chọn điểm có điểm số tốt nhất
                locx = B.get(location).getX();
                locy = B.get(location).getY();
                System.out.println(B.get(location).getX() + " " + B.get(location).getY() + " " + B.get(location).getScore());
            }
            A.clear();
            B.clear();
            C.clear();
            D.clear();
            F.clear();
            G.clear();
            CanATK.clear();
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Thời gian chạy: " + duration/1e6 + "ms");
        }
        else{
            int bg_x = tmp.getX();
            int bg_y = tmp.getY();
            E[bg_x][bg_y] = 2;
            locx = tmp.getX();
            locy = tmp.getY();
            System.out.println(locx + " " + locy);
            A.clear();
            CanATK.clear();
        }
    }
}