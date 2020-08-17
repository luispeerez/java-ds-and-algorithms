import java.util.Scanner;

class Main4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] m = new int[rows][cols];

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                m[r][c] = sc.nextInt();
            }
        }

        int sRows = sc.nextInt();
        int sCols = sc.nextInt();

        int[][] subM = new int[sRows][sCols];

        for(int r = 0; r < sRows; r++){
            for(int c = 0; c < sCols; c++){
                subM[r][c] = sc.nextInt();
            }
        }

        sc.close();

        int[][] res = processMatrix(m, subM);

        for(int r = 0; r < rows; r++){
            StringBuilder line = new StringBuilder();
            for(int c = 0; c < cols; c++){
                line.append(res[r][c]);

                if(c != cols - 1){
                    line.append(" ");
                }
            }
            System.out.println(line);
        }
    }

    public static int[][] processMatrix(int[][] m, int[][] subM){
        int rows = m.length;
        int cols = m[0].length;

        int sRows = subM.length;
        int sCols = subM[0].length;

        int[][] res = new int[rows][cols];

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols - sCols; c++){
                res[r][c] = 0;
            }
        }

        for(int r = 0; r < rows - sRows; r++){
            for(int c = 0; c < cols - sCols; c++){
                if( isEqualM(m, r, c, subM  ) ){
                    markSubM(res, r, c, subM);
                }
            }
        }

        return res;
    }

    public static boolean isEqualM(int[][] m, int r, int c, int[][] subM){
        int cPrime = c;
        for(int i = 0; i < subM.length; i++){
            cPrime = c;
            for(int j = 0; j < subM[0].length; j++){
                if(subM[i][j] != m[r][cPrime]){
                    return false;
                }
                cPrime++;
            }
            r++;
        }
        return true;
    }

    public static void markSubM(int[][] m, int r, int c, int[][] subM){
        int cPrime = c;
        for(int i = 0; i < subM.length; i++){
            cPrime = c;
            for(int j = 0; j < subM[0].length; j++){
                m[cPrime][r] = 1;
                cPrime++;
            }
            r++;
        }

    }
}