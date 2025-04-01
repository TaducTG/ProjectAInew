package MoveSet;

import java.util.*;

public class Move {
    public static int check = 0;
    static int[] ATK = {0, 10, 100, 501, 99999,99999};
    static int[] DEF = {0, 3, 50, 200, 20000,20000};

    // Kiểm tra theo hướng ngang
    public static int checkHangNgang(Point tmp, int[][] E, int a) {
        int line = 0;
        int line2 = 0;
        int x = tmp.x;
        int y = tmp.y;

        if (x >= 1 && E[x - 1][y] == a) {
            line += 1;
            if (x >= 2 && E[x - 2][y] == a) {
                line += 1;
                if (x >= 3 && E[x - 3][y] == a) {
                    line += 1;
                    if (x >= 4 && E[x - 4][y] == a) {
                        line += 1;
                    }
                }
            }
        }

        if (E[x + 1][y] == a) {
            line += 1;
            if (E[x + 2][y] == a) {
                line += 1;
                if (E[x + 3][y] == a) {
                    line += 1;
                    if (E[x + 4][y] == a) {
                        line += 1;
                        System.out.println("check");
                    }
                }
            }
        }

        if (x >= 1 && E[x - 1][y] == 0) {
            if (x >= 2 && E[x - 2][y] == a) {
                line2 += 1;
                if (x >= 3 && E[x - 3][y] == a) {
                    line2 += 1;
                    if (x >= 4 && E[x - 4][y] == a) {
                        line2 += 1;
                    }
                }
            }
        }

        if (E[x + 1][y] == 0) {
            if (E[x + 2][y] == a) {
                line2 += 1;
                if (E[x + 3][y] == a) {
                    line2 += 1;
                    if (E[x + 4][y] == a) {
                        line2 += 1;
                    }
                }
            }
        }

        if (line == 4) {
            check = 1;
        }

        if (a == 1) {
            return DEF[line];
        } else {
            return ATK[line] + ATK[line2];
        }
    }

    // Kiểm tra theo hướng dọc
    public static int checkHangDoc(Point tmp, int[][] E, int a) {
        int col = 0;
        int col2 = 0;
        int x = tmp.x;
        int y = tmp.y;
        if (y >= 1 && E[x][y - 1] == a) {
            col += 1;
            if (y >= 2 && E[x][y - 2] == a) {
                col += 1;
                if (y >= 3 && E[x][y - 3] == a) {
                    col += 1;
                    if (y >= 4 && E[x][y - 4] == a) {
                        col += 1;
                    }
                }
            }
        }

        if (E[x][y + 1] == a) {
            col += 1;
            if (E[x][y + 2] == a) {
                col += 1;
                if (E[x][y + 3] == a) {
                    col += 1;
                    if (E[x][y + 4] == a) {
                        col += 1;
                        System.out.println("check");
                    }
                }
            }
        }

        if (y >= 1 && E[x][y - 1] == 0) {
            if (y >= 2 && E[x][y - 2] == a) {
                col2 += 1;
                if (y >= 3 && E[x][y - 3] == a) {
                    col2 += 1;
                    if (y >= 4 && E[x][y - 4] == a) {
                        col2 += 1;
                    }
                }
            }
        }

        if (E[x][y + 1] == 0) {
            if (E[x][y + 2] == a) {
                col2 += 1;
                if (E[x][y + 3] == a) {
                    col2 += 1;
                    if (E[x][y + 4] == a) {
                        col2 += 1;
                    }
                }
            }
        }

        if (col == 4) {
            check = 1;
        }

        if (a == 1) {
            return DEF[col];
        }
        else {
            return ATK[col] + ATK[col2];
        }
    }

    // Kiểm tra theo đường chéo 1
    public static int checkDuongcheo1(Point tmp, int[][] E, int a) {
        int cheo1 = 0;
        int x = tmp.x;
        int y = tmp.y;
        if (E[x + 1][y + 1] == a) {
            cheo1 += 1;
            if (E[x + 2][y + 2] == a) {
                cheo1 += 1;
                if (E[x + 3][y + 3] == a) {
                    cheo1 += 1;
                    if (E[x + 4][y + 4] == a) {
                        cheo1 += 1;
                    }
                }
            }
        }

        if (x >= 1 && y >= 1 && E[x - 1][y - 1] == a) {
            cheo1 += 1;
            if (x >= 2 && y >= 2 && E[x - 2][y - 2] == a) {
                cheo1 += 1;
                if (x >= 3 && y >= 3 && E[x - 3][y - 3] == a) {
                    cheo1 += 1;
                    if (x >= 4 && y >= 4 && E[x - 4][y - 4] == a) {
                        cheo1 += 1;
                    }
                }
            }
        }

        if (cheo1 == 4) {
            check = 1;
        }
        if(a == 1){
            return DEF[cheo1];
        }
        return ATK[cheo1];
    }

    // Kiểm tra theo đường chéo 2
    public static int checkDuongcheo2(Point tmp, int[][] E, int a) {
        int cheo2 = 0;
        int x = tmp.x;
        int y = tmp.y;
        if (x >= 1 && E[x - 1][y + 1] == a) {
            cheo2 += 1;
            if (x >= 2 && E[x - 2][y + 2] == a) {
                cheo2 += 1;
                if (x >= 3 && E[x - 3][y + 3] == a) {
                    cheo2 += 1;
                    if (x >= 4 && E[x - 4][y + 4] == a) {
                        cheo2 += 1;
                    }
                }
            }
        }

        if (y >= 1 && E[x + 1][y - 1] == a) {
            cheo2 += 1;
            if (y >= 2 && E[x + 2][y - 2] == a) {
                cheo2 += 1;
                if (y >= 3 && E[x + 3][y - 3] == a) {
                    cheo2 += 1;
                    if (y >= 4 && E[x + 4][y - 4] == a) {
                        cheo2 += 1;
                    }
                }
            }
        }

        if (cheo2 == 4) {
            check = 1;
        }
        if(a==1){
            return DEF[cheo2];
        }
        return ATK[cheo2];
    }


}

