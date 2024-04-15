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

        System.out.println(simular(n, m, cx, cy, tx, ty));

        sc.close();
    }

    private static int dx[] = {1, 2, 1, 2, -1, -2, -1, -2};
    private static int dy[] = {2, 1, -2, -1, -2, -1, 2, 1};
    public static String simular(int n, int m, int cx, int cy, int tx, int ty) {
        int tablero[][] = new int[n][m];
        tx--; ty--; cx--; cy--; 
        llenarFila(tablero, m, tx, 0);
        llenarColumna(tablero, n, ty, 0);

        tablero[tx][ty] = 0;
        tablero[cx][cy] = 0;
        f(tablero, n, m, cx, cy); 

        String resultado = (tablero[tx][ty]==2? "First": "Draw");
        if (tablero[tx][ty]!=2 && (tx==cx || ty==cy) && !seMovio(tablero, n, m, 0)) 
                resultado = "Second";
        return resultado;
    }
    public static void llenarFila(int v[][], int n, int i, int j) {
        if (j<n) {
            v[i][j] = 1; 
            llenarFila(v, n, i, j+1);
        }
    }
    public static void llenarColumna(int v[][], int n, int i, int j) {
        if (j<n) {
            v[j][i] = 1;
            llenarColumna(v, n, i, j+1);
        }
    }
    public static void f(int v[][], int n, int m, int i, int j) {
        if (i<n && j<m && Math.min(i, j)>-1 && v[i][j]==0) {
            v[i][j] = 2; 
            seguir(v, n, m, i, j, 0);
        }
    }
    public static void seguir(int v[][], int n, int m, int i, int j, int ind) {
        if (ind<dx.length) {
            f(v, n, m, i+dx[ind], j+dy[ind]); 
            seguir(v, n, m, i, j, ind+1);
        }
    }
    public static boolean seMovio(int v[][], int n, int m, int i) {
        int res = 0; 
        if (i<n) res+=contar(v[i], m, 0); 
        return res>1;
    }
    public static int contar(int v[], int n, int i) {
        int sum = 0;
        if (i<n) {
            if (v[i]==2) sum++; 
            contar(v, n, i+1);
        }
        return sum;
    }
}