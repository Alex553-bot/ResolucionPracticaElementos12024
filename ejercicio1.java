import java.util.*;

public class ejercicio1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String v[] = new String[n];
        for (int i=0 ; i<n;i ++) v[i] = sc.next();
        System.out.println(puedoSalir(n, v));

        sc.close();
    }
    public static boolean puedoSalir(int n, String v[]) {
        char[][] a = new char[n][n];
        int x = -1, y= -1;
        for (int i=0 ; i<n; i++)
        for (int j = 0; j<n;j ++) {
            a[i][j] = v[i].charAt(j);
            if (a[i][j] == 'S') {
                x = i; y = j;
            }
        }
        
        return sePuede(n, a, x, y);
    }   
    static int dx[] = {0, 0, -1, 1}; 
    static int dy[] = {-1, 1, 0, 0}; 
    public static boolean sePuede(int n, char[][] v, int i, int j) {
        if (v[i][j]=='E') return true;
        boolean res = false;
        v[i][j] = '?';
        for (int k =0 ; k<4; k++) {
            int x = i+dx[k], y = j+dy[k];
            if (Math.min(x, y)<0 || Math.max(x, y) >=n || v[x][y]=='?') continue;
            res |= sePuede(n, v, x, y);
        }
        return res;
    }
}