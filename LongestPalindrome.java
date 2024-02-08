package LeetCode;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		System.out.print(longestPalindrome(s));
	}
	
	public static int longestPalindrome(String s) {
		int[] nums = new int[52];
		
		for(int i = 0; i < s.length();i++) {
			if(s.charAt(i)>= 65 && s.charAt(i)<=90) {
				nums[s.charAt(i)-65]++;
			} else if(s.charAt(i)>= 97 && s.charAt(i)<=122) {
				nums[s.charAt(i)-71]++;
			}
		}
		int odd = -1;
		for(int i = 0; i<nums.length;i++) {
			if(nums[i]%2 != 0) {
				odd++;
			}
		}
		int res = 0;
		if(odd > 0) {
			res = s.length() - odd;
		} else {
			res = s.length();
		}
		return res;
	}

}
