//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);
        n = n * 3;
        int b = Integer.parseInt("10101", 2);
        n = n + b;
        int h = Integer.parseInt("FF", 16);
        n = n + h;
        n = n * 6;
        int a=0;
        while(n>9)
        {
            a=0;
            while(n>0)
            {
                a+=n%10;
                n/=10;
            }
            n=a;
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);

    }
}
