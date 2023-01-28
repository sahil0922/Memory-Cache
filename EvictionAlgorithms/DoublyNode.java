import java.util.*;

// this is the Structure / layout of the 
// Doubly linkedList 
public class DoublyNode{
    DoublyNode next; // stores the next reference of Node
    DoublyNode prev; // stores the previous reference of Node
    String value; // Value of the node

    String key; // Not rarely seen in Doubly linkedlist implementation
    //The key is used as an index in the HashMap to map the key to its corresponding value
    // in the cache and also used in the eviction policy implementation, 
    //such as identifying the least recently used item



    public DoublyNode(String value){
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}