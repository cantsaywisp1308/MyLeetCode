public class LC2443_Sum_of_Number_and_its_Reverse {

    public static void main(String[] args) {
        int num = 443;
        System.out.println(sumOfNumberAndReverse(num));
    }

    public static boolean sumOfNumberAndReverse(int num) {
        if (num == 0) {return true;}
        for (int i = 0; i < num; i ++) {
            if (i + reverseNumber(i) == num) {
                return true;
            }
        }
        return false;
    }

    public static int reverseNumber(int num) {
        String string =  Integer.toString(num);
        StringBuilder result = new StringBuilder();
        for (int i = string.length()-1 ; i>=0 ; i--) {
            result.append(string.charAt(i));
        }
        return Integer.parseInt(String.valueOf(result));
    }
}
