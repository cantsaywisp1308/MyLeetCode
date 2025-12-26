import java.util.HashMap;
import java.util.Map;

public class DecimalToFraction {

    public static void main(String[] args) {
        int a = 1;
        int b = 3;
        System.out.println(fractionToDecimal(a,b));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        String sign = ((numerator < 0) ^ (denominator < 0)) ? "-" : "";
        result.append(sign);

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part
        result.append(num / den);
        num %= den;

        if (num == 0) { // Terminating decimal
            return result.toString();
        }

        // Decimal part
        result.append(".");
        Map<Long, Integer> remainderMap = new HashMap<>(); // remainder -> index in result

        while (num != 0) {
            if (remainderMap.containsKey(num)) {
                int repeatingStartIndex = remainderMap.get(num);
                result.insert(repeatingStartIndex, "(");
                result.append(")");
                return result.toString();
            }

            remainderMap.put(num, result.length());
            num *= 10;
            result.append(num / den);
            num %= den;
        }

        return result.toString();
    }

}
