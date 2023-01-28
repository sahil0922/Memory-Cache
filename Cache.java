import eviction.EvictionPolicy;
import eviction.EvictionPolicyCustom;

/*
 --Cache class that implements an eviction policy to manage the cache.
 --The cache is implemented using a HashMap to store the key-value pairs,
 --and an eviction policy to manage the eviction of keys from the cache.
 --The eviction policy is determined by the Policy Name passed to the constructor.
*/ 

public class Cache {
    private EvicitionPolicy policy; // an interface 
    private Map<String, Object> cache;

    // constructor with takes policy type as an argument
    // and decides which evcition policy to use
    public Cache(String policyType){
        this.policy = EvictionPolicyCustom.getEvictionPolicy(policyType);
        cache = new HashMap<>();
    }

    // this helps to set policy at Run-time through an interface 
    public void setPolicy(EvicitionPolicy policy){
        thils.policy = policy;
    }

    // insert element into cache with key -> value type
    public void put(String key, Object value){
        policy.insert(key, value);
        cache.put(key, value);
    }

    // remove item from the cache based on the eviction policy specified
    // this is widley used 
    public void remove(){
        String keyToRemove = policy.getKeyToRemove();
        policy.remove(keyToRemove);
        cache.remove(keyToRemove);
    }

    // remove item from the cache with given key 
    // (Personal choice) shouldn't use as it may volaiate the eviciton policy structure
    public void remove(String key){
        policy.remove(key);
        policy.remove(key);
    }

    // return's the item value corresponding to the key
    public Object get(String key){
        return policy.access(key);
    }

    // clear the cache (Emptys it)
    public void clear(){
        cache.clear();
    }
}