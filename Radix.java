import java.util.* ;
import java.io.* ;

public class Radix {
  public static void main(String[] args) {
    int[] a = {1, 3, 5, 83, 256, 7226, 1, 6263622} ;
    System.out.println(Arrays.toString(a)) ;
    System.out.println("Max # of digits expected is 7 and we got: " + (int) maxDigits(a)) ;
  }
  @SuppressWarnings("unchecked")
  public static void radixsort(int[]data) {
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10] ;
    int maxNumOfDigits = (int) maxDigits(data) ;
    for (int i : data) {
      // thinking of storing it in either an array or MyLinkedList
    }
    for (int a = 0 ; a < maxDigits(data) ; a++) {
      for (int b = 0 ; b < data.length ; b++) {

      }
    }
  }
  public static double maxDigits(int[] d) {
    double max = 0 ;
    for (int i : d) {
      if (Math.log(i) / 2 > max) {
        // i has a greater number of digits than max
        max = Math.log(i) / 2 ;
      }
    }
    return max ;
  }
}
