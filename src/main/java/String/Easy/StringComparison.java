package String.Easy;

/*
Find Intersection

Have the function FindIntersection(strArr) read the array of strings stored in strArr which will contain 2 elements: the first element will represent a list of comma-separated numbers sorted in ascending order, the second element will represent a second list of comma-separated numbers (also sorted). Your goal is to return a comma-separated string containing the numbers that occur in elements of strArr in sorted order. If there is no intersection, return the string false.
Examples

Input: new String[] {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"}
Output: 1,4,13
Input: new String[] {"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"}
Output: 1,9,10

 */
import java.util.*;
import java.io.*;

class StringComparison {

        public static String FindIntersection(String[] strArr) {
            // code goes here
            String response = "false";
            if(strArr.length != 2) return response;
            if(strArr[0] == "" || strArr[1]=="") return response;
            String[] l1 = strArr[0].split(",");
            String[] l2 = strArr[1].split(",");
            int i = 0;
            int j = 0;
            while(i<l1.length && j<l2.length){
                int a = Integer.valueOf(l1[i].trim());
                int b = Integer.valueOf(l2[j].trim());
                if(a==b){
                    response = updateResponse(response, l1[i]);
                    i++;
                    j++;
                } else{
                    if(a<b) i++;
                    else j++;
                }
            }
            return response;
        }
    private static String updateResponse(String response, String i){
        if(response == "false") response = i.trim();
        else response = response+","+i.trim();
        return response;
    }


    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String[] arr = new String[2];
        arr[0] = s.nextLine();
        arr[1]= s.nextLine();
        System.out.print(FindIntersection(arr));
    }

    }
