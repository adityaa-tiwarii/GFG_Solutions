//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int res=0;
        int n=arr.length;
        for(int i=0;i<n-2;i++){
            int left=i+1,right=n-1;
            while(left<right){
                int sum=arr[i]+arr[left]+arr[right];
                
                if(sum<target){
                    left +=1;
                }
                
                else if(sum>target){
                    right -=1;
                }
                
                else if(sum==target){
                    int ele1=arr[left];
                    int ele2=arr[right];
                    int cnt1=0,cnt2=0;
                    
                    while(left<=right && arr[left]==ele1){
                        left++;
                        cnt1++;
                    }
                    
                     while(left<=right && arr[right]==ele2){
                         right--;
                         cnt2++;
                     }
                     
                     if(ele1==ele2)
                         res += (cnt1 *(cnt1-1))/2;
                         else
                         res +=(cnt1*cnt2);

                }
            }
            
            
        }
        return res;
    }
}