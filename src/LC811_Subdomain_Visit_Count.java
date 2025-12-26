package out.production.AllLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC811_Subdomain_Visit_Count {
    public static void main(String[] args) {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(cpdomains));

    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < cpdomains.length; i++) {
            String[] sep_strings = cpdomains[i].split(" ");
            Integer count = Integer.parseInt(sep_strings[0]);
            String domains = sep_strings[1];
            String[] subdomains = domains.split("\\.");
            if(subdomains.length == 2) {
                String sub1 = subdomains[1];
                if(!map.containsKey(sub1)) {
                    map.put(sub1, count);
                } else {
                    map.put(sub1, map.get(sub1) + count);
                }
                String sub2 = subdomains[0] + "." + subdomains[1];
                if(!map.containsKey(sub2)) {
                    map.put(sub2, count);
                } else {
                    map.put(sub2, map.get(sub2) + count);
                }
            }

            if(subdomains.length == 3) {
                String sub1 = subdomains[2];
                String sub2 = subdomains[1] + "." + subdomains[2];
                String sub3 = subdomains[0] + "." + subdomains[1] + "." + subdomains[2];
                if (!map.containsKey(sub1)) {
                    map.put(sub1, count);
                } else {
                    map.put(sub1, map.get(sub1) + count);
                }
                if (!map.containsKey(sub2)) {
                    map.put(sub2, count);
                } else {
                    map.put(sub2, map.get(sub2) + count);
                }
                if (!map.containsKey(sub3)) {
                    map.put(sub3, count);
                } else {
                    map.put(sub3, map.get(sub3) + count);
                }
            }
        }
        for(String key: map.keySet()) {
            result.add(map.get(key).toString() + " " + key);
        }
        return result;
    }
}
