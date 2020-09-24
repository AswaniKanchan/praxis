package Array.Easy;

/*
Count the triplets
Easy Accuracy: 29.15% Submissions: 1414 Points: 2
Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Example 1:

Input:
N = 4
arr[] = {1, 5, 3, 2}
Output: 2
Explanation: There are 2 triplets:
1 + 2 = 3 and 3 +2 = 5
â€‹Example 2:

Input:
N = 3
arr[] = {2, 3, 4}
Output: 0
Explanation: No such triplet exits
Your Task:
You don't need to read input or print anything. Your task is to complete the function countTriplet() which takes the array arr[] and N as inputs and returns the triplet count

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 103
1 ≤ arr[i] ≤ 105

Sample input:
1
4
1 2 3 5

 */

import java.io.*;
import java.util.*;

class CountTripletsN2 {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");

            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }

            SolutionN2 ob = new SolutionN2();
            System.out.println(ob.countTriplet(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class SolutionN2 {
    int countTriplet(int arr[], int n) {
        // code here
        Arrays.sort(arr);
        //Instead of 3 pointers, take 2 pointers, one pointer for sum, and the second pointer we break into 2 but they traverse data once when combined
        int sumPtr = arr.length-1;
        int result = 0;
        for(int i=sumPtr; i>1; i--){
            int start=0;
            int end = i-1;
            while(start<end){
                //System.out.println(" "+i+" "+start+" "+end);
                int sum = arr[start] + arr[end];
                if(sum == arr[i]){
                    result++;
                    start++;
                    end--;
                } else{
                    if(sum>arr[i]){
                        end--;
                    } else start++;
                }
            }
        }
        return result;
    }
}