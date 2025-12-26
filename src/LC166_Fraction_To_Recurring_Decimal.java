import java.util.HashMap;
import java.util.Map;

public class LC166_Fraction_To_Recurring_Decimal {
    public static void main(String[] args) {
        int numerator = -1;
        int denumerator = -2147483648;
        System.out.println(fractionToDecimal(numerator, denumerator));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0 ) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        String sign = ((numerator < 0) ^ (denominator < 0)) ? "-" : "";
        result.append(sign);

        long num = Math.abs((long)numerator);
        long den = Math.abs((long) denominator);

        //Add integer part
        result.append(num / den);
        num %= den;

        if (num == 0) {
            return result.toString();
        }

        result.append(".");
        Map<Long, Integer> remainderMap = new HashMap<>();

        while (num != 0) {
            if (remainderMap.containsKey(num)) {
                int repeatStartIndex = remainderMap.get(num);
                result.insert(repeatStartIndex, "(");
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
