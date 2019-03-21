import java.util.*;

public class Quick{
  public static int partition( int [] data, int start, int end){
    int n = (end - start) / 2 + start;
    System.out.println("" + start);
    System.out.println("" + end);
    System.out.println("" + data[n]);
/*
    if (data[start] > data[end] && data[start] < data[(start + end)/2] || data[end] > data[start] && data[start] > data[(start + end)/2] ) {
      n = start;
    } else if (data[start] < data[end] && data[end] < data[(start + end)/2] || data[end] < data[start] && data[end] > data[(start + end)/2]){
      n = end;
    } else {
      n = (start + end) / 2;
    }
    */
    int a = data[n];
    /*
    System.out.println(Arrays.toString(data));
    System.out.println("pivot: " + a);
*/
    data[n] = data[start];
    data[start] = a;
    for (int i = start; i < end;){
      //a = data[i];
      if (a < data[i]){
        int z = data[i];
        data[i] = data[end];
        data[end] = z;
        end--;
        n = i;
      } else {
        i++;
        n = i;
      }
    }
    if (a > data[n] || n == start){
      int y = data[n];
      data[n] = a;
      data[start] = y;
      return n;
    } else {
      int y = data[n - 1];
      data[n - 1] = a;
      data[start] = y;
      return n - 1;
    }
  }


  public static int quickselect(int []data, int k){
    return 1;
  }

  public static void main(String[] args){
    int[] a = new int[10];
    for (int i = 10; i > 0; i--){
      a[10 - i] = i;
    }
    System.out.println(Arrays.toString(a));
    //System.out.println("ind of pivot at end " + partition(a, 0, a.length - 1));
    quickSort(a);
    System.out.println(Arrays.toString(a));
  //  System.out.println("ind of pivot at end " + partition(a, 0, 5));5, 1, 2, 3, 4, 6, 10, 7, 8, 9
    //quickSort(a);
    //System.out.println(Arrays.toString(a));
    //System.out.println(n);
    System.out.println("" + a.length);
  }

  public static void quickSort(int[] ary){
    quickSortHelp(ary, 0, ary.length - 1);
  }
  public static void quickSortHelp(int[] ary, int lo, int hi){
    if (lo < hi){
      int pivot = partition(ary, lo, hi);
      System.out.println(Arrays.toString(ary));
      quickSortHelp(ary, lo, pivot - 1);
      quickSortHelp(ary, pivot + 1, hi);
    }
  }







}
