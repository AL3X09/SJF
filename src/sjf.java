
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static java.lang.Character.UnicodeBlock.of;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC1008
 */
class SJF {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n, BT[], WT[], TAT[];
        System.out.println("Ingrese el numero de procesos");
        n = sc.nextInt();
        BT = new int[n + 1];
        WT = new int[n + 1];
        TAT = new int[n + 1];
        float AWT = 0;
        System.out.println("Introduzca el tiempo de ráfaga para cada proceso");
        for (int i = 0; i < n; i++) {
            System.out.println("Introduzca TR para el procesos " + (i + 1));
            BT[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            WT[i] = 0;
            TAT[i] = 0;
        }
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (BT[j] > BT[j + 1]) {
                    temp = BT[j];
                    BT[j] = BT[j + 1];
                    BT[j + 1] = temp;
                    temp = WT[j];
                    WT[j] = WT[j + 1];
                    WT[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            TAT[i] = BT[i] + WT[i];
            WT[i + 1] = TAT[i];
        }
        TAT[n] = WT[n] + BT[n];
        System.out.println("  PROCESO   TR      TE      TAT     ");
        for (int i = 0; i < n; i++) {
            System.out.println("    " + i + "       " + BT[i] + "       " + WT[i] + "       " + TAT[i]);
        }
        for (int j = 0; j < n; j++) {
            AWT += WT[j];
        }
        AWT = AWT / n;
        System.out.println("***********************************************");
        System.out.println("Tiempo de espera promedio es=" + AWT + "\n***********************************************");
    }
}
