package algorithm.ArrayAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainVisitCount {
    public static void main(String[] args) {
        System.out.println(new SubDomainVisitCount().subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
        System.out.println(new SubDomainVisitCount().subdomainVisits2(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : cpdomains) {
            int times = Integer.valueOf(str.split(" ")[0]);
            String url = str.split(" ")[1];
            map.put(url, map.getOrDefault(url, 0) + times);
            while (url.contains(".")) {
                url = url.substring(url.indexOf(".") +1);
                map.put(url, map.getOrDefault(url, 0) + times);
            }
        }

        List<String> rst = new ArrayList<>();
        for (String key : map.keySet()) {
            rst.add(map.get(key) + " " + key);
        }
        return rst;
    }

    public List<String> subdomainVisits2(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpd : cpdomains) {
            String[] arr = cpd.split(" ");
            int count = Integer.valueOf(arr[0]);
            String[] domains = arr[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int i=domains.length-1; i>=0; i--) {
                if (i == domains.length-1) {
                    sb.append(domains[i]);
                } else {
                    sb.insert(0, domains[i] + ".");
                }
                String domain = sb.toString();
                map.put(domain, map.getOrDefault(domain, 0) + count);
            }
        }

        List<String> rst = new ArrayList<>();
        for (String domain : map.keySet()) {
            rst.add(map.get(domain) + " " + domain);
        }
        return rst;
    }
}
