import java.util.Scanner;

class Main3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] m = new int[rows][cols];

        int k = sc.nextInt();
        int[] ops = new int[k];

        for(int i = 0; i < k; i++){
            ops[i] = sc.nextInt();
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                m[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < k; i++){
            shiftArr(m, ops[i]);
        }

        //System.out.println(Arrays.deepToString(m));

        for(int r = 0; r < rows; r++){
            StringBuilder line = new StringBuilder();
            for(int c = 0; c < cols; c++){
                line.append(m[r][c]);

                if(c != cols - 1){
                    line.append(" ");
                }
            }
            System.out.println(line);
        }

        sc.close();
    }

    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;


    public static void shiftArr(int[][] m, int operation){
        
        switch(operation){
            case UP:
                upArr(m);
                break;
            case DOWN:
                downArr(m);
                break;
            case LEFT:
                leftArr(m);
                break;
            case RIGHT:
                rightArr(m);
            default:
                break;
        }
    }

    public static void upArr(int[][] m){
        int cols = m[0].length;
        int rows = m.length;

        if(rows <= 1){
            return;
        }

        int[] topAux = new int[cols];
        for(int c = 0; c < cols; c++ ){
            topAux[c] = m[0][c];
        }

        for(int r = 0; r < rows - 1; r++){
            for(int c = 0; c < cols; c++){
                m[r][c] = m[r+1][c];
            }
        }

        for(int c = 0; c < cols; c++){
            m[rows - 1][c] = topAux[c];
        }
    }
    public static void downArr(int[][] m){
        int cols = m[0].length;
        int rows = m.length;

        if(rows <= 1){
            return;
        }

        int[] bottomAux = new int[cols];
        for(int c = 0; c < cols; c++ ){
            bottomAux[c] = m[rows - 1][c];
        }

        for(int r = rows - 1; r > 0; r--){
            for(int c = 0; c < cols; c++){
                m[r][c] = m[r-1][c];
            }
        }

        for(int c = 0; c < cols; c++){
            m[0][c] = bottomAux[c];
        }
    }
    
    public static void leftArr(int[][] m){
        int cols = m[0].length;
        int rows = m.length;

        if(cols <= 1){
            return;
        }

        int[] leftAux = new int[rows];
        for(int r = 0; r < rows; r++ ){
            leftAux[r] = m[r][0];
        }

        for(int c = 0; c < cols - 1; c++){
            for(int r = 0; r < rows; r++){
                m[r][c] = m[r][c + 1];
            }
        }

        for(int r = 0; r < rows; r++){
            m[r][cols - 1] = leftAux[r];
        }        
    }
    public static void rightArr(int[][] m){
        int cols = m[0].length;
        int rows = m.length;

        if(cols <= 1){
            return;
        }

        int[] rightAux = new int[rows];
        for(int r = 0; r < rows; r++ ){
            rightAux[r] = m[r][cols - 1];
        }

        for(int c = cols - 1; c > 0; c--){
            for(int r = 0; r < rows; r++){
                m[r][c] = m[r][c - 1];
            }
        }

        for(int r = 0; r < rows; r++){
            m[r][0] = rightAux[r];
        }        
    }
}