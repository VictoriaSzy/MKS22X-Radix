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
    int maxNumOfDigits = (int) maxDigits(data) + 1 ;
    int a = 0 ; // this will represent the digit that we are looking at
    while (a < maxNumOfDigits) {
      // for testing purposes
      String place = "" ;
      if (a == 0) place = "ones" ;
      if (a == 1) place = "tens" ;
      if (a == 2) place = "hundreds" ;
      if (a == 3) place = "thousands" ;
      if (a == 4) place = "ten thousands" ;
      if (a == 5) place = "hundred thousands" ;
      if (a == 6) place = "millions" ;
      if (a == 7) place = "ten millions" ;
      if (a == 8) place = "hundred millions" ;
      if (a == 9) place = "billions" ;
      System.out.println("We are checking the " + place + " place value now!") ;
      for (int i : data) {
        // int digit ;
        //if (i < maxNumOfDigits * 10) {
          // we're looking at one of the smaller values
          //digit = 0 ;
        //}
        int digit = i % 10 ;
        buckets[digit].add(i) ;
        i = i / 10 ; // for the future
      }
      // now we have to clear out the buckets after copying it back
      for (MyLinkedList c : buckets) {
        c.clear() ;
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
