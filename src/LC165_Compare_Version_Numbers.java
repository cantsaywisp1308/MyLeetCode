public class LC165_Compare_Version_Numbers {

    public static void main(String[] args) {
        String version1  = "1.1";
        String version2 = "1.0.1.0";
        System.out.println(compareVersion(version1, version2));
    }

    public static int compareVersion(String version1, String version2) {
        int result = 0;
        int maxInt = Math.max(version1.split("\\.").length, version2.split("\\.").length);
        int[] v1 = new int[maxInt];
        int[] v2 = new int[maxInt];
        for (int i = 0 ; i < version1.split("\\.").length ; i++) {
            v1[i] = Integer.parseInt(version1.split("\\.")[i]);
        }
        for (int i = 0 ; i < version2.split("\\.").length; i++) {
            v2[i] = Integer.parseInt(version2.split("\\.")[i]);
        }
        for (int i = 0 ; i < maxInt; i++) {
            if (v1[i] > v2[i]) {
                result = 1;
                break;
            } else if (v1[i] < v2[i]){
                result = -1;
                break;
            }
        }

        return result;
    }
}
