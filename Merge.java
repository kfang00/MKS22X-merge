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

  private static void insertionSort(int[] ary, int start, int end) {
	int hold = 0;
	int idx = start;
	int hold1 = 0;
	for (int a = start + 1; a < end + 1; a++) {
	    hold = ary[a];
	    idx = a - 1;
	    while ((idx >= start) && (hold < ary[idx])) {
		    hold1 = ary[idx];
		    ary[idx + 1] = hold1;
		    idx = idx - 1;
	    }
	    ary[idx + 1] = hold;
	    //System.out.println(printArray(ary));
	}
    }

  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    mergesortH(data, 0, data.length - 1);

  }

  private static void mergesortH(int[] data, int lo, int hi) {
    if (lo >= hi) {
      //merge(data, 0, data.length - 1);
      return;
    }
    if (data.length < 50) {
      insertionSort(data, lo, hi);
    }
    else {
    int[] left = new int[(data.length / 2)];
    int[] right = new int[data.length - (data.length / 2) ];
    for (int a = 0; a < data.length; a++) {
      if (a < (data.length / 2)) {
        left[a] = data[a];
        //System.out.println(toString(left, 0, a));
      }
      else {
        right[a - (data.length / 2)  ] = data[a];
        //System.out.println(toString(right, 0, a - ((data.length) / 2) ));
      }
    }
    mergesortH(left, 0, left.length - 1);
    //System.out.println(toString(data, 0, data.length - 1));
    mergesortH(right, 0, right.length - 1);
    //System.out.println(toString(data, 0, data.length - 1));

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
    //if (left.length > right.length) {//if right and left are different lengths
      while (l < left.length) {
        data[d] = left[l];
        l++;
        d++;
     }
   //}
   //else if (left.length < right.length) {//if right and left are different lengths
      while (r < right.length) {
        data[d] = right[r];
        r++;
        d++;
     }
   //}
   //System.out.println(toString(data, 0, data.length - 1));
   }

  }

  /*private static void mergesortH(int[] data, int lo, int hi) {
    if (lo >= hi) {
      //merge(data, 0, data.length - 1);
      return;
    }
    mergesortH(data, ((hi + lo) / 2) + 1, hi);
    //System.out.println(toString(data, ((hi + lo) / 2) + 1, hi));
    mergesortH(data, lo, ((hi + lo) / 2));
    //System.out.println(toString(data, lo, ((hi + lo) / 2)));
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



 //Sort testing code
  private static final int INCREASE = 0;
  private static final int DECREASE = 1;
  private static final int STANDARD = 2;
  private static final int SMALL_RANGE = 3;

  private static String name(int i){
    if(i==INCREASE)return "Increassing";
    if(i==DECREASE)return "Decreassing";
    if(i==STANDARD)return "Normal Random";
    if(i==SMALL_RANGE)return "Random with Few Values";
    return "Error categorizing array";

  }

  private static int create(int min, int max){
    return min + (int)(Math.random()*(max-min));
  }

  private static int[]makeArray(int size,int type){
    int[]ans =new int[size];
    if(type == STANDARD){
      for(int i = 0; i < size; i++){
        ans[i]= create(-1000000,1000000);
      }
    }
    else if(type == INCREASE){
      int current = -5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current += 10;
      }
    }
    else if(type == DECREASE){
      int current = 5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current -= 10;
      }
    }
    else if(type == SMALL_RANGE){
      for(int i = 0; i < size; i++){
        ans[i]= create(-5,5);
      }
    }
    else{
      ans = new int[0];//empty is default
    }
    return ans;
  }

  // public static void main(String[]args){
  //   //int[]da = {34,5,75,4,678,45,86,45,7856,4,64,585,68,45,75,68,5, 23,43,56,57,467,3,45,2,4,23,4,23,4,2,3344,2,334,2,2334,4,233,88,23,4,234,23,4,2,2};
  //   //Merge.mergesort(da);
  //   //System.out.println(toString(da, 0, da.length - 1));
  //   if(args.length < 2)return;
  //
  //   int size =  Integer.parseInt(args[0]);
  //   int type =   Integer.parseInt(args[1]);
  //
  //   int [] start = makeArray(size,type);
  //   int [] result = Arrays.copyOf(start,start.length);
  //   Arrays.sort(result);
  //
  //   long startTime = System.currentTimeMillis();
  //   ///*
  //   // * Test your sort here //yoursort(start);
  //   // * Add code to switch which sort is tested by changing one of the args!
  //   //
  //   Merge.mergesort(start);
  //   //System.out.println(toString(start, 0, start.length - 1));
  //   long elapsedTime = System.currentTimeMillis() - startTime;
  //   if(Arrays.equals(start,result)){
  //     System.out.println("PASS Case "+name(type)+"\t array, size:"+start.length+"\t"+elapsedTime/1000.0+"sec ");
  //   }else{
  //     System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
  //   }
  // }

  public static void main(String[]args){
     System.out.println("Size\t\tMax Value\tmerge /builtin ratio ");
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
           Merge.mergesort(data2);
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
}
