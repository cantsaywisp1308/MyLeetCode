package LeetCode;

import java.util.*;
import java.util.regex.Pattern;

public class ValidateIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String queryIP = "";
		System.out.print(validIPAddress(queryIP));
	}

	public static String validIPAddress(String queryIP) {
		List<String> ip4Dict = new ArrayList<String>();
		for (int i = 0; i < 256; i++) {
			ip4Dict.add(Integer.toString(i));
		}
		List<String> ip6Dict = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			ip6Dict.add(Integer.toString(i));
		}
		ip6Dict.add("A");
		ip6Dict.add("B");
		ip6Dict.add("C");
		ip6Dict.add("D");
		ip6Dict.add("E");
		ip6Dict.add("F");
		ip6Dict.add("a");
		ip6Dict.add("b");
		ip6Dict.add("c");
		ip6Dict.add("d");
		ip6Dict.add("e");
		ip6Dict.add("f");
		if (isIP4(queryIP, ip4Dict)) {
			return "IPv4";
		}
		if (isIP6(queryIP, ip6Dict)) {
			return "IPv6";
		}
		return "Neither";
	}

	public static boolean isIP4(String queryIP, List<String> ip4Dict) {
		if (queryIP == "" || queryIP.charAt(0) == '.' || queryIP.charAt(queryIP.length() - 1) == '.') {
			return false;
		}

		String[] ip4Parts = queryIP.split(Pattern.quote("."));
		int count = 0;
		if (ip4Parts.length == 4) {
			for (int i = 0; i < ip4Parts.length; i++) {
				if (ip4Dict.contains(ip4Parts[i])) {
					count++;
				}
			}
			if (count == 4) {
				return true;
			}
		}

		return false;
	}

	public static boolean isIP6(String queryIP, List<String> ip6Dict) {
		if (queryIP == "" || queryIP.charAt(0) == ':' || queryIP.charAt(queryIP.length() - 1) == ':') {
			return false;
		}

		String[] ip6Parts = queryIP.split(Pattern.quote(":"));
		boolean[] status = new boolean[ip6Parts.length];
		if (ip6Parts.length == 8) {
			for (int k = 0; k < ip6Parts.length; k++) {
				if (ip6Parts[k].length() > 0 && ip6Parts[k].length() <= 4) {
					int count = 0;
					for (int i = 0; i < ip6Parts[k].length(); i++) {
						String value = "";
						value += ip6Parts[k].charAt(i);
						if (ip6Dict.contains(value)) {
							count++;
						}
					}
					if (count == ip6Parts[k].length()) {
						status[k] = true;
					} else {
						status[k] = false;
					}
				}
			}

		}
		boolean res = true;
		for (int i = 0; i < status.length; i++) {
			if (status[i] == false) {
				res = false;
			}
		}
		return res;
	}
}
