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
    mergesortH(data, ((hi + lo) / 2), hi);
    mergesortH(data, lo, ((hi + lo) / 2) - 1);
  }

  //private static void merge(int data, int lo, int hi) {

  //}

  public static void main(String[] args){
    int[] data1 = {10, 80, 30, 90, 40, 50, 70};
    Merge.mergesort(data1);
    System.out.println(data1);
  }
}
