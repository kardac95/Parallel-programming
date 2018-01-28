public class Main {
    public static void main(String [ ] args) {
        int iterations[] = {10, 20, 40, 80, 160, 320};
        int processes[] = {1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println("\\hline");
        System.out.println("$p\\backslash n$ & 10 & 20 & 40 & 80 & 160 & 320 \\\\\\hline");
        for (int p: processes) {
            System.out.print(p + "\t");
            for (int n : iterations) {
                double ts = calcTS(n); double tp = calcTP(n, p);
                System.out.print("& " + calcSpeedup(ts, tp) + "\t");
            }
            System.out.println("\\\\\\hline");
        }

        System.out.println("\\hline");
        System.out.println("$p\\backslash n$ & 10 & 20 & 40 & 80 & 160 & 320 \\\\\\hline");
        for (int p: processes) {
            System.out.print(p + "\t");
            for (int n: iterations) {
                double ts = calcTS(n); double tp = calcTP(n,p);
                System.out.print("& " + calcEfficiency(ts,tp, n) + "\t");
            }
            System.out.println("\\\\\\hline");
        }
    }

    public static double calcTP(int n, int p) {
        return (Math.pow(n,2)/p) + log(p,2);
    }

    public static double calcTS(int n) {
        return Math.pow(n,2);
    }

    public static float calcEfficiency(double ts, double tp, int p) {
        return (float)(ts/(tp*p));
    }

    public static float calcSpeedup(double ts, double tp) {
        return  (float) (ts/tp);
    }

    static int log(int x, int base)
    {
        return (int) (Math.log(x) / Math.log(base));
    }
}
