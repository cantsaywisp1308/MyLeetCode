package LeetCode;

public class ReverseStringII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "a";
		int k = 2;
		System.out.print(reverseStr(s, k));
	}

	 public static String reverseStr(String s, int k) {
		 String result = "";
		 for(int i = 0 ; i < s.length();i+=2*k) {
			 String s1 = "";
			 if(i + 2*k > s.length()) {
				 s1 = s.substring(i, s.length());
//				 System.out.println(s1); 
			 } else {
				 s1 = s.substring(i, i+2*k);
//				 System.out.println(s1); 
			 }
			 if(s1.length() < 2 * k && s1.length()>=k) {
				 s1 = reverseByK(s1,k);
				 result += s1;
			 } else if(s1.length()== 2*k) {
				 s1 = reverseByK(s1, k);
				 result+=s1;
			 } else {
				 s1 = reverse(s1);
				 result += s1;
			 }
		 }
	     return result;
	 }
	 
	 public static String reverseByK(String s, int k) {
		 char[] c = s.toCharArray();
		 s = "";
		 for(int i = 0; i < k/2; i++) {
	        	char temp = c[i];
	        	c[i] = c[k-i-1];
	        	c[k-i-1] = temp;
	     }
		 for(int i = 0 ; i < c.length;i++) {
	        	s += c[i];
	     }
		 return s;
	 }
	 
	 public static String reverse(String s) {
		 char[] c = s.toCharArray();
		 s = "";
		 for(int i = 0; i < c.length/2; i++) {
	        	char temp = c[i];
	        	c[i] = c[c.length-i-1];
	        	c[c.length-i-1] = temp;
	     }
		 for(int i = 0 ; i < c.length;i++) {
	        	s += c[i];
	     }
		 return s;
	 }
}
