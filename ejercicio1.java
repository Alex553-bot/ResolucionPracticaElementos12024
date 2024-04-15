import java.util.*;

public class ejercicio1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String v[] = new String[n];
        for (int i=0 ; i<n;i ++) v[i] = sc.next();

        System.out.println(puedoSalir(v, n));

        sc.close();
    }
    private static int start_i, start_j;
    private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};
    
    public static boolean puedoSalir(String s[], int n) {
        int dp[][] = new int[n][n]; 
        encontrarFila(s, n, 0);
        return f(s, n, start_i, start_j, dp);
    }
    public static void encontrarFila(String s[], int n, int i) {
        if (i<n) {
            int indice = encontrarColumna(s[i], n, 0); 
            if (indice!=-1 && s[i].charAt(indice)=='S') start_i = i;
            else encontrarFila(s, n, i+1);    
        }
    }
    public static int encontrarColumna(String s, int n, int j) {
        int res = -1;
        if (j<n) {
            char actual = s.charAt(j); 
            if (actual=='S') {
                res = j;
                start_j = j;
            }
            else res = encontrarColumna(s, n, j+1);
        }
        return res;
    }
    public static boolean f(String s[], int n, int i, int j, int dp[][]) {
        boolean resultado = false;
        if (Math.max(i, j)<n && Math.min(i, j)>-1 && s[i].charAt(j)!='?' && dp[i][j]==0) {
            dp[i][j] = 1; 
            resultado|=s[i].charAt((j))=='E';
            resultado|=seguir(s, n, i, j, dp, 0);
        }
        return resultado;
    }
    public static boolean seguir(String s[], int n, int i, int j, int dp[][], int indice) {
        boolean res = false;
        if (indice<4) {
            res |= f(s, n, i+dx[indice], j+dy[indice], dp);
            res |= seguir(s, n, i, j, dp, indice+1);
        }
        return res;
    }
}