package ICPC;
import java.util.*;

public class ConstructingIncreasingSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {0,1,0,3,2,3};
		constructLIS(array);
	}
	
	static void printLIS(List<Integer> arr)
	{
	  for (int x : arr)
	    System.out.print(x + " ");
	  System.out.println();
	}
	
	public static void constructLIS(int[] arr) {
		 Vector<Integer> L[] = new Vector[arr.length];
		  for (int i = 0; i < L.length; i++)
		    L[i] = new Vector<Integer>();
		   
		  // L[0] is equal to arr[0]
		  L[0].add(arr[0]);
		 
		  // Start from index 1
		  for (int i = 1; i < arr.length; i++)
		  {
		    // Do for every j less than i
		    for (int j = 0; j < i; j++)
		    {
		      //L[i] = {Max(L[j])} + arr[i]
		      // where j < i and arr[j] < arr[i]
		      if ((arr[i] > arr[j]) &&
		          (L[i].size() < L[j].size() + 1))
		        L[i] = (Vector<Integer>) L[j].clone();  //deep copy
		    }
		 
		    // L[i] ends with arr[i]
		    L[i].add(arr[i]);
		  }
		 
		  // L[i] now stores increasing sub-sequence of
		  // arr[0..i] that ends with arr[i]
		  Vector<Integer> max = L[0];
		   
		  // LIS will be max of all increasing sub-
		  // sequences of arr
		  for (Vector<Integer> x : L)
		    if (x.size() > max.size())
		      max = x;
		 
		  // max will contain LIS
		  printLIS(max);
	}
	

}
