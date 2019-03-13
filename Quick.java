import java.util.*;

public class Quick{
  public static int partition( int [] data, int start, int end){
    Random rand = new Random();
    int n = rand.nextInt(end - start) + start;
    int a = data[n];
    data[n] = data[start];
    data[start] = a;
    for (int i = start; i < end + 1; i++){
      //a = data[i];
      if (a > data[i]){
        int z = data[i];
        data[start] = data[i];
        for (int j = i - 1; j > start; j--){
          if (j == start + 1){
            data[j] = z;
          } else {
            data[j] = data[j - 1];
          }
        }
      }
    }
    for (int i = start; i < end; i++){
      if (data[i] == a){
        return i;
      }
    }
    return -1;
  }


  public static int quickselect(int []data, int k){
    return 1;
  }

  public static void main(String[] args){
    int[] a = new int[100];
    for (int i = 100; i > 0; i--){
      a[100 - i] = i;
    }
    partition(a, 0, 99);
    String n = "[";
    for (int i = 0; i < a.length; i++){
      n += " " + a[i];
    }
    n += "]";
    System.out.println(n);
  }

  public static void quickSort(int[] ary){
    quickSortHelp(ary, 0, ary.length - 1);
  }

  public static void quickSortHelp(int[] ary, int lo, int hi){
    if (lo >= hi){
      return;
    }
    int pivot = partition(ary, lo, hi);
    quickSortHelp(ary, pivot + 1, hi);
    quickSortHelp(ary, lo, pivot - 1);
  }
}
