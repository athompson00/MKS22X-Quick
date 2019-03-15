import java.util.*;

public class Quick{
  public static int partition( int [] data, int start, int end){
    Random rand = new Random();
    int n = rand.nextInt(data.length);
    int a = data[n];
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
    if (a > data[n] || n == 0){
      int y = data[n];
      data[n] = a;
      data[0] = y;
      return n;
    } else {
      int y = data[n - 1];
      data[n - 1] = a;
      data[0] = y;
      return n - 1;
    }
  }


  public static int quickselect(int []data, int k){
    return 1;
  }

  public static void main(String[] args){
    int[] a = new int[100];
    for (int i = 100; i > 0; i--){
      a[100 - i] = i;
    }
    quickSort(a);
    String n = "[";
    for (int i = 0; i < a.length; i++){
      n += " " + a[i];
    }
    n += "]";
    System.out.println(n);
    System.out.println("" + a.length);
  }

  public static void quickSort(int[] ary){
    quickSortHelp(ary, 0, ary.length - 1);
  }

  public static void quickSortHelp(int[] ary, int lo, int hi){
    if (lo <= hi){
      int pivot = partition(ary, lo, hi);
      quickSortHelp(ary, lo, pivot - 1);
      quickSortHelp(ary, pivot + 1, hi);
    }
  }
}
