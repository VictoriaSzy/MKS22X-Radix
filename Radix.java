import java.util.* ;
import java.io.* ;

@SuppressWarnings("unchecked")
public class Radix {
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long rtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Radix.radixsort(data2);
        t2 = System.currentTimeMillis();
        rtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*rtime/btime);
    }
    System.out.println();
  }
}
public static void radixsort(int[] data){
    MyLinkedList<Integer>[] lis = new MyLinkedList[20] ;
    for (int i = 0 ; i < lis.length ; i++) {
      lis[i] = new MyLinkedList<Integer>() ;
    }
    MyLinkedList<Integer> merging = new MyLinkedList<Integer>() ;
    int numOfPasses = calculatePasses(data) ;
    for (int i = 0 ; i < numOfPasses + 1 ; i++){
      if (i == 0) roundOne(data, lis) ;
      else {
        makeBuckets(i, merging, lis) ;
      }
      merging.clear() ;
      for (int x = 0 ; x < lis.length ; x++){
        merging.extend(lis[x]) ;
      }
    }
    Node<Integer> no = merging.start() ;
    data[0] = no.getData() ;
    int i = 1 ;
    while (no.hasNext()) {
      no = no.next() ;
      data[i] = no.getData() ;
      i++ ;
    }
  }

  private static int calculatePasses(int[] data) {
    int max = max(data) ;
    if (max == 0) return 0 ;
    String str = "" + max ;
    return str.length() - 1 ;
  }

  private static int max(int[] data) {
    if (data.length == 0) return 0 ;
    int max = 0 ;
    for (int i = 0 ; i < data.length ; i++) {
      if (data[i] > max) max = data[i] ;
    }
    return max ;
  }
  // for the first time that we make and use the buckets
  private static void roundOne(int[] data, MyLinkedList<Integer>[] lis){
    for (int i = 0 ; i < data.length ; i++) {
      int n = data[i] ;
      int digit = n % 10 ;
      lis[digit + 9].add(n) ;
    }
  }
  private static void makeBuckets(int i, MyLinkedList<Integer> data, MyLinkedList<Integer>[] lis) {
    Node<Integer> node = data.start() ;
    int n = node.getData() ;
    int digit = n / (int) Math.pow(10, i) % 10 ; // similar to what I did before but it's more organized now
    lis[digit + 9].add(n) ;
    while (node.hasNext()) {
      node = node.next() ;
      n = node.getData() ;
      digit = n / (int) Math.pow(10, i) % 10 ;
      lis[digit + 9].add(n) ;
    }
  }
}
