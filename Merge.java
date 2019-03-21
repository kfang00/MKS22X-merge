import java.util.*;
import java.io.*;

public class Merge {
  /*
  mergesort(data,lo,hi):
    if lo >= hi :
      return
    mergesort left side
    mergesort right side
    merge*/


  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    mergesortH(data, 0, data.length - 1);

  }

  private static void mergesortH(int[] data, int lo, int hi) {
    if (lo >= hi) {
      //merge(data, 0, data.length - 1);
      return;
    }

    int[] left = new int[data.length / 2];
    int[] right = new int[data.length - (data.length / 2)];
    for (int a = 0; a < data.length; a++) {
      if (a <= ((hi + lo) / 2)) {
        left[a] = data[a];
        //System.out.println(toString(left, 0, a));
      }
      else {
        right[a - ((hi + lo) / 2) - 1] = data[a];
        //System.out.println(toString(right, 0, a - ((hi + lo) / 2) - 1));
      }
    }
    mergesortH(left, 0, left.length - 1);
    System.out.println(toString(data, 0, data.length - 1));
    mergesortH(right, 0, right.length - 1);
    System.out.println(toString(data, 0, data.length - 1));

    int l = 0;
    int r = 0; //keeping track of the index
    int d = 0; //data index

    while ((l < left.length) && (r < right.length)) {
      if (left[l] <= right[r]) {
	data[d] = left[l];
        l++;
        d++;
      }
      else if (left[l] > right[r]) {
	data[d] = right[r];
        r++;
        d++;
      }
    }
    if (left.length > right.length) {//if right and left are different lengths
      while (l < left.length) {
        data[d] = left[l];
        l++;
        d++;
     }
   }
   else if (left.length < right.length) {//if right and left are different lengths
      while (r < right.length) {
        data[d] = right[r];
        r++;
        d++;
     }
   }
    
  }

  /*private static void mergesortH(int[] data, int lo, int hi) {
    if (lo >= hi) {
      //merge(data, 0, data.length - 1);
      return;
    }
    mergesortH(data, ((hi + lo) / 2) + 1, hi);
    System.out.println(toString(data, ((hi + lo) / 2) + 1, hi));
    mergesortH(data, lo, ((hi + lo) / 2));
    System.out.println(toString(data, lo, ((hi + lo) / 2)));
  }*/


  //private static void merge(int data, int lo, int hi) {

  //}

  private static String toString(int[] data, int lo, int hi) {
     String s = "";
     for (int a = lo; a <= hi; a++) {
       s += data[a] + " ";
     }
     return s;
  }

  public static void main(String[] args){
    int[] data1 = {1, 2, 3, 5, 6, 7};
    Merge.mergesort(data1);
    System.out.println(toString(data1, 0, data1.length - 1));
  }
}
