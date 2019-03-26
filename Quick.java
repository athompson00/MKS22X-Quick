import java.util.*;

public class Quick{
  public static int partition( int [] data, int start, int end){
    //int n = (end - start) / 2 + start;
    Random randgen = new Random();
    int n;
    if (data[start] > data[end] && data[start] < data[(start + end)/2] || data[end] > data[start] && data[start] > data[(start + end)/2] ) {
      n = start;
    } else if (data[start] < data[end] && data[end] < data[(start + end)/2] || data[end] < data[start] && data[end] > data[(start + end)/2]){
      n = end;
    } else {
      n = (start + end) / 2;
    }
/*
    System.out.println("" + start);
    System.out.println("" + end);
    System.out.println("" + data[n]);
    */
    int a = data[n];
//    System.out.println(Arrays.toString(data));
//    System.out.println("pivot: " + a);

    data[n] = data[start];
    data[start] = a;
    if ((end - start) == 1){
      if (data[start] > data[end]){
        int z = data[start];
        data[start] = data[end];
        data[end] = z;
      }
    }
    for (int i = start + 1; i < end;){
      int duble = randgen.nextInt(2);
      //a = data[i];
      if (a == data[i] && duble == 0){
        int z = data[i];
        data[i] = data[end];
        data[end] = z;
        end--;
      }
      else if (a < data[i]){
        int z = data[i];
        data[i] = data[end];
        data[end] = z;
        end--;
      } else {
        i++;
      }
      n = i;
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
    int s = 0;
    int e = data.length;
    for (int i = 1; i != 0;){
      int piv = partition(data, s, e - 1);
      if (piv < k){
        s = piv + 1;
      }
      if (piv > k){
        e = piv - 1;
      }
      if (piv == k){
        i = 0;
      }
    }
    return data[k];
  }

  public static void main(String[]args){
    /*
    int[] ary = {5, 2, 3, 1, 6, 3, 8, 4, 3, 4};

    System.out.println(Arrays.toString(ary));
    quicksort(ary);
    System.out.println(Arrays.toString(ary));
*/

    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
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
          Quick.quicksort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }


  }

  public static void quicksort(int[] ary){
    quickSortHelp(ary, 0, ary.length - 1);
  }
  public static void quickSortHelp(int[] ary, int lo, int hi){
    if (lo < hi){
      int pivot = partition(ary, lo, hi);
      //System.out.println(Arrays.toString(ary));
      quickSortHelp(ary, lo, pivot - 1);
      quickSortHelp(ary, pivot + 1, hi);
    }
  }







}
