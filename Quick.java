import java.util.*;

public class Quick{
  public static int partition( int [] data, int start, int end){
    Random rand = new Random();
    int n = rand.nextInt(end - start) + start;
    int a = data[n];
    data[n] = data[start];
    data[start] = a;
    for (int i = start; i <= end; i++){
      if (a > data[i]){
        int z = data[start];
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

  public static void main(String[] args){
    int[] a = {1, 2, 3, 4, 5, 6};
    partition(a, 0, 5);
    String n = "[";
    for (int i = 0; i < 6; i++){
      n += a[i];
    }
    n += "]";
    System.out.println(n);
  }
}
