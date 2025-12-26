import java.util.HashMap;
import java.util.Map;

public class LC273_Integer_To_English_Words {

    public static void main(String[] args) {
        System.out.println(numberToWords(540999));
    }

    public static String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        String result = "";
        int[] layers = new int[4];
        int index = 3;
        while (num != 0) {
            layers[index] = num % 1000;
            num = num / 1000;
            index--;
        }
        for (int i = 0 ; i < 4; i++) {
            if(layers[i] != 0 && i == 0) {
                result += subWord(layers[i]) + " Billion ";
            } else if (layers[i] != 0 && i == 1) {
                result += subWord(layers[i]) + " Million ";
            } else if (layers[i] != 0 && i == 2) {
                result += subWord(layers[i]) + " Thousand ";
            } else {
                result += subWord(layers[i]);
            }
        }
        return result;
    }

    public static String subWord(int num) {
        Map<Integer, String> wordMap = new HashMap<>();
        wordMap.put(0, "");
        wordMap.put(1, "One");
        wordMap.put(2, "Two");
        wordMap.put(3, "Three");
        wordMap.put(4, "Four");
        wordMap.put(5, "Five");
        wordMap.put(6, "Six");
        wordMap.put(7, "Seven");
        wordMap.put(8, "Eight");
        wordMap.put(9, "Nine");
        String result = "";

        int temp = num % 100 / 10;
        int temp1 = num % 100 % 10;
        switch (num % 100 / 10) {
            case 0:
                result += wordMap.get(num % 100);
                break;
            case 1:
                switch (num % 100 % 10) {
                    case 0:
                        result += "Ten";
                        break;
                    case 1:
                        result += "Eleven";
                        break;
                    case 2:
                        result += "Twelve";
                        break;
                    case 3:
                        result += "Thirteen";
                        break;
                    case 4:
                        result += "Fourteen";
                        break;
                    case 5:
                        result += "Fifteen";
                        break;
                    case 6:
                        result += "Sixteen";
                        break;
                    case 7:
                        result += "Seventeen";
                        break;
                    case 8:
                        result += "Eighteen";
                        break;
                    case 9:
                        result += "Nineteen";
                        break;
                }
                break;
            case 2:
                result += "Twenty " + wordMap.get(num % 10);
                break;
            case 3:
                result += "Thirty " + wordMap.get(num % 10);
                break;
            case 4:
                result += "Forty " + wordMap.get(num % 10);
                break;
            case 5:
                result += "Fifty " + wordMap.get(num % 10);
                break;
            case 6:
                result += "Sixty " + wordMap.get(num % 10);
                break;
            case 7:
                result += "Seventy " + wordMap.get(num % 10);
                break;
            case 8:
                result += "Eighty " + wordMap.get(num % 10);
                break;
            case 9:
                result += "Ninety " + wordMap.get(num % 10);
                break;
        }

        if(num / 100 != 0 ) {
            result = wordMap.get(num / 100) + " Hundred " + result;
        }
        return result.strip();

    }
}
