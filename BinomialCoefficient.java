
import java.util.ArrayList;
import java.util.List;

public class BinomialCoefficient {

    private int n;

    public BinomialCoefficient(int degree) {
        this.n = degree;
    }

    private int Cnr(int r) {
        if (r > n) {
            return 0;
        }
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    private int factorial(int num) {
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public void display() {
        System.out.format("(a+b)^%d = ", n);
        System.out.println(calculate());
    }

    public String calculate() {
        List<String> terms = new ArrayList<>();
        for (int k = 0; k <= n; k++) {
            int expCnr = Cnr(k);
            int expA = n - k;
            int expB = k;

            String term = "";

            if (expCnr != 1) {
                term += expCnr;
            }
            if (expA > 0) {
                term += (expA == 1 ? "a" : "a^" + expA);
            }
            if (expB > 0) {
                term += (expB == 1 ? "b" : "b^" + expB);
            }
            terms.add(term);
        }
        return listToString(terms, "+");
    }

    private String listToString(List<String> list, String delimiter) {
        if (list.isEmpty()) {
            return "";
        }
        String result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result += delimiter + list.get(i);
        }
        return result;
    }
}
