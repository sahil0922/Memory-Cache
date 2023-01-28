import EvicitionPolicy;

/*
--LIFO (Last In First Out) is an eviction policy for a cache where the most recently added item is the first one to be removed when the cache reaches its size limit.
--This class implements the EvictionPolicy interface and provides an implementation for the LIFO eviction policy.
--It uses a Stack to keep track of the order in which items were added to the cache, and a HashMap to store the key-value pairs of the cache.
*/


public class LIFO implements EvicitionPolicy {
    Stack<String> stack;
    Map<String, Object> cache; 
    private static final int MAX_CACHE_SIZE_LIMIT; // it a constant that holds the maximum size of the cache.

    public LIFO(int size){
        stack = new Stack<>();
        cache = new HashMap<>();
        MAX_CACHE_SIZE_LIMIT = size;
    }


    // this Inserts a key-value pair into the cache, and removing the oldest item if the cache has reached its size limit.
    @Override
    public void insert(String key, Object value){
        if(stack.size() == MAX_CACHE_SIZE_LIMIT){
           remove();
        }
        stack.push(key);
        cache.put(key, value);
    }

    // This method access the item associated with the given key, moving it to the top of the stack.
    @Override
    public Object access(String key){
        stack.pop(key);
        stack.push(key);

        return cache.get(key);
    }

    // it removes the oldest item from the cache.
    @Override
    public void remove(){
        String key = stack.pop();
        cache.remove(key);
    }

    // this method clears the entire cache.
    @Override
    public void clear(){
        stack.clear();
        map.clear();
    }

    // returns the current size of the cache.
    @Override
    public int size(){
        return map.size();
    }
}