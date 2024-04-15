import java.util.*;
public class ejercicio2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); 

        int n = sc.nextInt(); 
        String v[] = new String[n];
        for (int i= 0; i<n; i++) v[i] = sc.next();
        String x = sc.next();
        
        System.out.println(puedoGenerar(v, x));
        
        sc.close();
    }
    private static int n;
    private static int m; 
    
    public static boolean puedoGenerar(String a[], String x) {
        n = a.length;
        m = x.length();
        return f(a, x, 0, 0);
    }
    public static boolean f(String a[], String x, int i, int j) {
        boolean resultado = j==m; 
        if (!resultado && i<n) {
            if (a[i].length()<=x.length()-j) {
                String t = x.substring(j, j+a[i].length());
                if (t.equals(a[i])) 
                    resultado|=f(a, x, i+1, j+a[i].length());
            }
            if (!resultado) resultado|=f(a, x, i+1, j);
        }
        return resultado;
    }

}