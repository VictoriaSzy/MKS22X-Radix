import java.io.* ;
import java.util.* ;
@SuppressWarnings("unchecked")
public class MyLinkedList<E> {
  ///////////// START OF ITERATOR CLASS ////////////////
  /*public class Iter implements Iterator<E> {
        Node current = null ;
        public Iter(MyLinkedList<E> a) {
            current = a.start ;
        }
        public boolean hasNext() {
            return current != null ;
        }

        public E next() {
            E a = current.data ;
            current = current.next ;
            return a ;
        }
    }*/
    /////////// END OF ITERATOR CLASS //////////////////////////
  ////////// START OF MYLINKEDLIST CLASS METHODS /////////////////
  private int length ;
  private Node start, end ;
  // Constructor
  public MyLinkedList() {
    length = 0 ;
    start = new Node(null, null, null) ;
    end = new Node(null, null, null) ;
  }
  public MyLinkedList(E[] a) {
    	length = a.length ;
    	if (a.length > 0){
    		start = new Node(a[0]) ;
    		Node current = start ;
    		for (int i = 1 ; i < length ; i++) {
    			current.setNext(new Node(a[i], current, null)) ;
    			current = current.next() ;
    		}
    		end = current ;
    	}
    }
    public E iterator(Node<E> node){
      return node.next().getData() ;
    }
  //public Iterator<E> iterator() {
    //return new Iter(this) ; // from 4/03/19 class notes
  //}
  // returns size
  public int size() {
    return length ;
  }
  public void extend(MyLinkedList other){
        //in O(1) runtime (CONSTANT), move the elements from other onto the end of this
        //The size of other is reduced to 0
        //The size of this is now the combined sizes of both original lists
        if (size() == 0) {
          start = other.start ;
          end = other.end ; // sort of like transferring ownership
        }
        else if (other.size() > 0) {
          end.setNext(other.start) ;
          other.start.setPrev(this.end) ;
          end = other.end ;
        }
        length += other.size() ;
        other.clear() ;
    }
  public void clear() {
    length = 0 ;
		start = null ;
    end = null ;
	}
  // returns true if the Integer was added successfully
  // and adds it to the end
  public boolean add(E value) {
    if (length == 0) {
      Node<E> v = new Node<E>(value, null, null) ;
      start = v ;
      end = v ;
      length ++ ;
      // if the linked list doesn't have anything yet
    }
    else {
      // if the linked list has something in it, then we have to add on to the last node
      Node<E> nextNode = new Node<E>(value, end, null) ;
      end.setNext(nextNode) ;
      end = nextNode ;
      length++ ;
    }
    return true ;
  }
  public Node<E> start() {
    return start ;
  }
  // prints out the Linked List with the node(s)
  public String toString() {
    String fin = "[" ;
    Node index = start ;
    for (int i = 0 ; i < length ; i++) {
      if (i < length - 1) fin += index.getData() + ", " ;
      else {
        fin += index.getData() ;
      }
      index = index.next() ;
    }
    return fin += "]" ;
  }
}
