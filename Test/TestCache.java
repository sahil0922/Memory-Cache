
// used to test the Memory Cache Implementation 
public class TestCache {

    public static void main(String[] args) {

        // here we are creating a cache object of eviction type : LRU
        Cache cache = new Cache("LRU");

        // inserting items into cache
        cache.put("Key1", "Value 1");
        cache.put("Key2", "Value 2");
        cache.put("Key3", "Value 3");
        
        System.out.println(cache.get("Key1"));
        // output -> Value 2

        System.out.println(cache.get("Key2"));
        //output -> Value 1

        cache.put("Key4", "Value 4");
        cache.put("Key5", "Value 5");

        System.out.println(cache.get("Key4"));
        System.out.println(cache.get("Key5"));

        cache.remove();
        // since this is ("LRU") it removes the Key1 and its corresponding value 1

        cache.clear();
        
        System.out.println(cache.size());
        // it will print "0"
    }
}