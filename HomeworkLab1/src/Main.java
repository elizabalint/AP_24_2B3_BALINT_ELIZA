//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.lang.*;
public class Main {
    public static void main(String[] args) {
        Main lab1 = new Main();
        lab1.homework(args);
        lab1.bonus(args);
    }
    //verificare k-reductibilitate
    public static int kReductibil(int i)
    {
        int a = i;
        while (a >= 10)
        {
            int b = a;
            int sum = 0;
            while (b != 0) {
                sum += (b % 10) * (b % 10);
                b /= 10;
            }
            a = sum;
        }
        return a;
    }
    void homework(String[] args)
    {
        if (args.length < 3) {
            System.out.println(
                    "Nu ati introdus destule argumente");
            System.exit(-1);
        }
        //timp in nanosecunde
        long start = System.nanoTime();
        try{
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int k = Integer.parseInt(args[2]);
            System.out.println(args[0]);
            System.out.println(args[1]);
            System.out.println(args[2]);
            StringBuilder nr = new StringBuilder();
            for (int i = a; i <= b; i++) {
                if (kReductibil(i) == k) {
                    nr.append(i).append(", ");
                }
            }
            String nrString = nr.toString();
            System.out.println("Numere: " + nrString);
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }

        long finish = System.nanoTime();
        long time = finish - start;
        System.out.println("Timp in nanosecunde: " + time);
    }

    void bonus(String[] args)
    {
        if (args.length < 4) {
            System.out.println(
                    "Nu ati introdus destule argumente");
            System.exit(-1);
        }
        int[][] mat = new int[100][100];
        int n = Integer.parseInt(args[3]);
        //legam nodul 1 de toate celelalte noduri in matricea de adiacenta
        for(int i = 1;i<n;i++)
        { mat [0][i] = 1;
            mat[i][0] =1;}

        for (int i=1; i< n;i++)
            for(int j = 1; j<n;j++)
            {   //verificam diferenta in modul este 1 sau verifica sa puna muchie intre nodul al-lea si ultimul
                if(Math.abs(j-i) == 1 || (i == 1 && j == n - 1) || (j == 1 && i == n - 1)) {
                    mat[i][j] = 1;
                    mat[j][i] = 1;
                }
                else
                { mat[i][j]=0;
                    mat[j][i] = 0;}
            }
        //afisare matrice
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

    }
}