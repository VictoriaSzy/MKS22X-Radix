import java.io.* ;
import java.util.* ;

public class MyLinkedList<E> {
  //////// Start of Node class ////////////////////////////////
  public class Node {
    private E data ;
    private Node next, prev ;
    // Constructors
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
    public boolean hasNext() {
      if (next == null) return false ;
      return true ;
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
  ///////////// END OF NODE CLASS ////////////////////////////////
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
  // returns size
  public int size() {
    return length ;
  }
  @SuppressWarnings("unchecked") 
  public void extend(MyLinkedList other){
        //in O(1) runtime (CONSTANT), move the elements from other onto the end of this
        //The size of other is reduced to 0
        //The size of this is now the combined sizes of both original lists
        this.end.setNext(other.start) ;
        this.end = other.end ;
        other.start = null ;
        other.end = null ;
        this.length += other.length ;
        other.length = 0 ;
    }

  // returns the Node at the specified index
  private Node getNthNode(int n) {
    if (n < 0 || n >= length) throw new IndexOutOfBoundsException("The index given is not valid and can't be used to find a Node!") ;
    Node result = start ;
    for (int i = 0 ; i < length && i < n ; i++) {
      // I'm using i as a visual representation of the index that an array would have
      result = result.next() ;
    }
    return result ;
  }

  // returns the Integer at the specified index
  public E get(int index) {
    if (index < 0 || index >= length) throw new IndexOutOfBoundsException("The index given is not valid!") ;
    Node item = getNthNode(index) ;
    return item.getData() ;
  }

  // changes the Integer at the specified index and returns the old or previous value there
  public E set(int index, E value) {
    if (index < 0 || index >= length) throw new IndexOutOfBoundsException("The index given is not valid!") ;
    Node result = start ;
    for (int i = 0 ; i < length ; i++) {
      result = result.next() ;
    }
    E previousData = result.getData() ;
    result.setData(value) ;
    return result.getData() ;
  }

  // returns whether the Linked List has the given value
  public boolean contains(E value) {
    Node result = start ;
    for (int i = 0 ; i < length ; i++) {
      if (result.getData() == value) return true ;
      result = result.next() ;
    }
    return false ;
  }

  // returns the index of the value
  // if the value is not in the Linked List --> -1
  public int indexOf(E value) {
    Node current = start ;
    int index = 0 ;
    while (current != null) {
      // used the while loop from the website
      E v = current.getData() ;
      if (v.equals(value)) return index ;
      current = current.next() ;
      index++ ;
    }
    // if the value is not in the LinkedList, return -1
    return -1 ;
  }

  // returns true if the Integer was added successfully
  // and adds it to the end
  public boolean add(E value) {
    if (length == 0) {
      // if the linked list doesn't have anything yet
      end = new Node(value) ;
      start = end ;
      length++ ;
    }
    else {
      // if the linked list has something in it, then we have to add on to the last node
      Node nextNode = new Node(value, end, null) ;
      end.setNext(nextNode) ;
      end = end.next() ;
      length++ ;
    }
    return true ;
  }

  // adds an Integer to a specific index (as long as it is valid)
  public void add(int index, E value) {
    if (index < 0 || index > length) throw new IndexOutOfBoundsException("The index given does not exist. Therefore, nothing can be changed!") ;
    Node nodeToAdd = new Node(value, null, null) ;
    if (index == 0) {
      // we are adding the Integer to the front
      start.setPrev(nodeToAdd) ;
      nodeToAdd.setNext(start) ;
      start = nodeToAdd ;
      length++ ;
    }
    else if (index == length) {
      // add element to the end
      add(value) ;
    }
    else {
      // we are adding the Integer somewhere into the list --> we need to shift the Integer at the index
      Node nodeToBeShifted = getNthNode(index) ;
      nodeToAdd.setPrev(nodeToBeShifted.prev()) ;
      nodeToAdd.setNext(nodeToBeShifted) ;
      Node nodeThatStays = nodeToBeShifted.prev() ;
      nodeThatStays.setNext(nodeToAdd) ;
      nodeToBeShifted.setPrev(nodeToAdd) ;
      length++ ;
    }
  }

  // removes the Integer at the given index and returns what was removed
  public E remove(int index) {
    if (index < 0 || index >= length) throw new IndexOutOfBoundsException("The given index can't be used!") ;
    E old = get(index) ;
    if (index == 0) {
      // we are getting rid of the first Integer
      start = start.next() ;
      start.setPrev(null) ;
      length-- ;
      return old ;
    }
    if (index == length - 1) {
      // this means that we will be removing the last Integer
      end = end.prev() ;
      end.setNext(null) ;
      length-- ;
      return old ;
    }
    // otherwise, we need to remove an Integer that is not the first or last
    Node prevNode = getNthNode(index - 1) ;
    Node nextNode = getNthNode(index + 1) ;
    prevNode.setNext(nextNode) ;
    nextNode.setPrev(prevNode) ;
    length-- ;
    return old ;
  }

  // returns true if the value exists in the Linked List
  // returns false if the value is NOT in the Linked List
  public boolean remove(E value) {
    int index = indexOf(value) ;
    if (index == -1) return false ; // since the Integer is not in the Linked List
    else {
      remove(index) ;
      return true ;
    }
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
