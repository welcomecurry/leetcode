public class Codec {
    //map encoded url with decoded url
    //key is the shortUrl and the value is the longUrl
    //encoded url can just be the hashcode of the longUrl
    
    Map<String, String> map = new HashMap<>();
    String TINY_URL = "http://tinyurl.com/";
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = TINY_URL + longUrl.hashCode();
        map.put(key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));