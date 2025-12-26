public class LC69_Sqrt_X {

    public static void main(String[] args) {
        int x = 11;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        long high = x;
        long low = 0;
        long ans = 0;
        while (low < high) {
            long mid = (low + high) /2;
            if(mid * mid < x) {
                low = mid + 1;
                ans = mid;
            } else if (mid * mid > x) {
                high = mid - 1;
            } else {
                return (int)mid;
            }
        }
        return (int) ans;
    }
}
