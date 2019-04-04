import java.util.* ;
import java.io.* ;

@SuppressWarnings("unchecked")
public class Node<E> {
  private E data ;
  private Node<E> next, prev ;
  // Constructors
  public Node(E d, Node<E> p, Node<E> n) {
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
  public Node<E> next() {
    return next ;
  }
  public Node<E> prev() {
    return prev ;
  }
  public boolean hasNext() {
    if (next == null) return false ;
    return true ;
  }
  // mutators
  public E setData(E d) {
    E r = data ;
    data = d ;
    return r ;
  }
  public void setNext(Node<E> n) {
    next = n ;
  }
  public void setPrev(Node<E> p) {
    prev = p ;
  }
  public String toString() {
    String fin = "" ;
    return fin + data ;
  }
}
