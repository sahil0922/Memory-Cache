import java.lang.*;

/*
--The EvicitionPolicy interface is used to define the behavior of eviction policies.
--An eviction policy is used to determine which element should be removed from the cache when it becomes full.
*/

/*
 * Inserts: a key-value pair into the cache. If the key already exists, it updates the value.
 * access: to an element from the cache
 * remove: removes the item based on the eviction policy
 * clear: clears the entire cache
 * size : return the current size of cache
 */

public interface EvicitionPolicy {
    void insert(String key, Object value);
    Object access(String key);
    void remove();
    void clear();
    void size();
}
