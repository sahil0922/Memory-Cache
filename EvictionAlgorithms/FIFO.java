import java.util.*;
import EvicitionPolicy;

/*
 * FIFO (First In First Out) implementation of eviction policy.
 * This class implements the EvictionPolicy interface and uses a
 * LinkedList as a queue and a HashMap for the cache storage.
*/

public class FIFO implements EvicitionPolicy {
    Queue<String> queue; //  it is a LinkedList that holds the keys of the cache entries in the order they were added.
    Map<String, Object> cache; // it is HashMap that stores the key-value pairs of the cache entries.

    private static final int MAX_CACHE_SIZE_LIMIT; // a constant that holds the maximum size of the cache.

    public FIFO(int size){
        queue = new LinkedList<>();
        cache = new HashMap<>();
        MAX_CACHE_SIZE_LIMIT = size;
    }


    // inserts a new key-value pair to the cache. If the cache size reaches
    // the MAX_CACHE_SIZE_LIMIT, the oldest key (first one in the queue) is removed.
    @Override
    public void insert(String key, Object value){
        if(queue.size() == MAX_CACHE_SIZE_LIMIT){
           remove();
        }
        queue.add(key);
        cache.put(key, value);
    }


    // accesses a key-value pair by its key. 
    //The key is moved to the end of the queue.
    @Override
    public Object access(String key){
        queue.remove(key);
        queue.add(key);

        return cache.get(key);
    }

    // removes the oldest key-value pair (first one in the queue) from the cache.
    @Override
    public void remove(){
        String key = queue.poll();
        cache.remove(key);
    }

    //clears the queue and the cache.
    @Override
    public void clear(){
        queue.clear();
        map.clear();
    }

    // returns the current size of the cache.
    @Override
    public int size(){
        return map.size();
    }
}