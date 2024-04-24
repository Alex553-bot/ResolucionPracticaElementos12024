import java.util.*;
public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int cx = sc.nextInt();
        int cy = sc.nextInt();
        int tx = sc.nextInt(); 
        int ty = sc.nextInt();

        System.out.println(simular(n, m, cx-1, cy-1, tx-1, ty-1));

        sc.close();
    }
    static String simular(int n, int m, int cx, int cy, int tx, int ty) {
        int v[][] = new int[n][m]; 

        for (int i= 0; i<m; i++) v[tx][i]=1;
        for (int i= 0; i<n; i++) v[i][ty]=1;
        v[tx][ty] = 0;
        f(n,m , v, cx, cy);
        if (v[tx][ty]==0) {
            int sum = 0;
            for (int i=0; i<n;i ++) 
            for (int j= 0 ; j<m; j++) 
            if (v[i][j]==2) sum++;
            if (sum==1) {
                if (tx==cx || ty==cy) return "Second";
                else return "Draw";
            } else return "Draw";
        } else return "First";
    }
    static int dx[] = {1,1,2,2,-1,-1,-2,-2};
    static int dy[] = {2,-2,1,-1,-2,2,-1,1};
    
    static void f(int n, int m, int v[][], int i, int j) {
        v[i][j] = 2; 
        for (int k = 0; k<8; k++) {
            int x = i+dx[k], y = j+dy[k]; 
            if (Math.min(x, y)<0 || x>=n || y>=m || v[x][y]!=0) continue;
            f(n, m, v, x, y);
        }
    }
}