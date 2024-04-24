import java.util.*;
public class ejercicio2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); 

        int n = sc.nextInt(); 
        String v[] = new String[n];
        for (int i= 0; i<n; i++) v[i] = sc.next();
        String x = sc.next();
        
        System.out.println(puedoGenerar(v, x));
        //System.out.println(puedoGenerar(x, v));
        
        sc.close();
    } 
    static boolean puedoGenerar(String v[], String x) {
        ArrayList<String> set = new ArrayList<>();

        f(v, "", 0, set);

        return set.contains(x);
    }
    static void f(String v[], String s, int i, ArrayList<String> set) {
        if (i==v.length) {
            set.add(s);
            return;
        }
        f(v, s+v[i], i+1, set);
        f(v, s, i+1, set);
    }
}