import java.util.*;
import EvictionPolicy;

/*

* This class implements the Least Recently Used (LRU) eviction policy for a cache.
* It uses a doubly linked list and a hash map to keep track of the keys and values in the cache.
* The most recently accessed item is at the tail of the linked list, and the least recently accessed item is at the head.
* The class provides methods to insert, access and remove elements from the cache.
*/

public class LRU extends DoublyLinkedList implements EvicitionPolicy {
    DoublyLinkedList list; //  The DoublyLinkedList used to store the elements
    Map<String, DoublyNode> map; //  The HashMap used to store the keys and node
    int MAX_CACHE_SIZE_LIMIT; // it is the maximum size limit for the cache

    //Constructor
    public LRU(int MAX_CACHE_SIZE_LIMIT){
        this.MAX_CACHE_SIZE_LIMIT = MAX_CACHE_SIZE_LIMIT;
        list = new DoublyLinkedList();
        map = new HashMap<>();
    }

    // Inserts an element into the cache
    @Override
    public void insert(String key, Object value){
        if(map.containsKey(key)){
            DoublyNode node = map.get(key);
            list.removeNode(node);
            node.value = value;
            list.addLastNode(node);
            map.put(key, node);
            
        }else{
            if(list.size() == MAX_CACHE_SIZE_LIMIT){
                remove();
            }
            DoublyNode node = new DoublyNode(key, value);
            list.addLastNode(node);
            map.put(key, node);
        }
    }

    //  access to an element from the cache
    @Override
    public Object access(String key){
        if(!map.containsKey(key)){
            return null;
        }
        DoublyNode node = map.get(key);
        list.removeNode(node);
        list.addLastNode(node);
        return node.value;
    }

    // clears the cache
    @Override
    public void clear(){
        list.clear();
        map.clear();
    }

    // returns the size of the cache
    @Override
    public int size(){
        return map.size();
    }
}