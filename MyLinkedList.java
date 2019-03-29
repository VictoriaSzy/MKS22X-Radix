import java.io.* ;
import java.util.* ;

public class MyLinkedList<E>{
  public class Node {
    private E data ;
    private Node next, prev ;
    // Constructor
    public Node(E d, Node p, Node n) {
      data = d ;
      next = n ;
      prev = p ;
    }
    public Node(E d) {
      data = d ;
      prev = null ;
      next = null ;
    }
    // accessors
    public E getData() {
      return data ;
    }
    public Node next() {
      return next ;
    }
    public Node prev() {
      return prev ;
    }
    // mutators
    public E setData(E d) {
      data = d ;
      return data ;
    }
    public void setNext(Node n) {
      next = n ;
    }
    public void setPrev(Node p) {
      prev = p ;
    }
    public String toString() {
      String fin = "" ;
      return fin ;
    }
  }
  ///////////// END OF NODE CLASS //////////////////////
  
}
