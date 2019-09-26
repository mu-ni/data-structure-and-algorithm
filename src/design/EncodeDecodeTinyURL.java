package design;

import java.util.HashMap;
import java.util.Map;

public class EncodeDecodeTinyURL {
    Map<Integer, String> map = new HashMap<>();
    String host = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int tiny = longUrl.hashCode();
        map.put(tiny, longUrl);
        return host + tiny;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int tiny = Integer.parseInt(shortUrl.replace(host, ""));
        return map.get(tiny);
    }

    public static void main(String[] args) {
        EncodeDecodeTinyURL coder = new EncodeDecodeTinyURL();
        String encode = coder.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(encode);
        String decode = coder.decode(encode);
        System.out.println(decode);
    }
}
