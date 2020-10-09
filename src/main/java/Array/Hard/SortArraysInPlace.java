package Array.Hard;// { Driver Code Starts
import java.io.*;
import java.util.*;

class SortArraysInPlace {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int arr1[] = new int[n];
            int arr2[] = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            new SolutionNlogN().merge(arr1, arr2, n, m);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr1[i] + " ");
            }
            for (int i = 0; i < m; i++) {
                str.append(arr2[i] + " ");
            }
            System.out.println(str);
        }
    }
}// } Driver Code Ends


class SolutionNlogN {

    public void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        sortFirstArray(arr1, arr2);
        //System.out.println("Calling heap sort");
        heapSort(arr2);
    }

    void heapSort(int arr[]){
        for(int i=1; i<=arr.length; i++){
            heapify(arr, i);
        }
    }

    void sortFirstArray(int arr1[], int arr2[]){
        int j = 0;
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]<=arr2[j]) i++;
            else{
                int data = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = data;
                //System.out.println("Swapped "+data+" with "+arr1[i]+" and i++ to "+i);
                heapify(arr2, 0);
            }
        }
    }

    void heapify(int arr[], int offset){
        int i = 1;
        int min = i;
        int l = 2*i;
        int r = 2*i+1;
        if(l+offset<=arr.length && r+offset<=arr.length){
            min = arr[l-1+offset] < arr[r-1+offset]? l:r;
            min = arr[i-1+offset] < arr[min-1+offset]? i:min;
            //System.out.println("Hi min= "+min);
            if(i == min) return;
            int data = arr[i-1+offset];
            arr[i-1+offset] = arr[min-1+offset];
            arr[min-1+offset]=data;
            //System.out.println("Heapified by swapping "+ data+" with "+arr[i-1+offset]);
            heapify(arr, min);
        } else{
            if(l+offset<=arr.length){
                min = arr[l-1+offset]<arr[i-1+offset]?l:i;
                int data = arr[i-1+offset];
                arr[i-1+offset] = arr[min-1+offset];
                arr[min-1+offset]=data;
                //System.out.println("Heapified by swapping "+ data+" with "+arr[i-1+offset]);
            }
        }

    }
}