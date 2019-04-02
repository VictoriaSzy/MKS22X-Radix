import java.util.* ;
import java.io.* ;

public class Radix {
  public static void radixsort(int[]data) {
    MyLinkedList<Integer> buckets = new MyLinkedList<Integer>() ;
    int maxNumOfDigits = maxDigits(data) ;
    for (int i : data) {
      // thinking of storing it in either an array or MyLinkedList
    }
    for (int a = 0 ; a < maxDigits(data) ; a++) {
      for (int b = 0 ; b < data.length ; b++) {

      }
    }
  }
  public static int maxDigits(int[] d) {
    return 0 ;
  }
}
