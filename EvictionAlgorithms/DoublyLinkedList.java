import java.util.*;
import DoublyNode;

// this is an Doubly-linkedList Class which is requried 
// to implement the "LRU Cache"

public class DoublyLinkedList{
    DoublyNode head;
    DoublyNode tail;
    int size; // maintains the current length of linkedlist Length

    public DoublyLinkedList(){
        head = new DoublyNode();
        tail = new DoublyNode();
        
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // removes the first node from the list and return it
    public DoublyNode removeFirstNode(){
        if(size == 0) return null;

        DoublyNode node = head.next;
        head.next = node.next;
        node.next.prev = head;
        size--;

        return node;
    }

    // removes the last node 
    public void addLastNode(DoublyNode node){
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    // removes the particular node given as argument
    public void removeNode(DoublyNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    // clears the entire linkedList
    public void clear(){
        head = new DoublyNode();
        tail = new DoublyNode();

        head.next = tail;
        tail.prev = head;
        size = 0;
    }


    // returns the size of linkedList
    public int size(){
        return size;
    }
}