from typing import List



from heapq import *

class Solution:
    def kthLargest(self, arr, k) -> int:
        # code here
        min_heap = []
        for i in range(len(arr)):
            summ = 0
            for j in range(i, len(arr)):
                summ += arr[j]
                if len(min_heap) < k:
                    heappush(min_heap, summ)
                else:
                    if min_heap[0] < summ:
                        heappop(min_heap)
                        heappush(min_heap, summ)
        return min_heap[0]


        



#{ 
 # Driver Code Starts
#Initial Template for Python 3
import heapq

# Position this line where user code will be pasted.

#Initial Template for Python 3

if __name__ == "__main__":
    t = int(input())
    while t > 0:
        arr = list(map(int, input().split()))
        k = int(input())
        ob = Solution()
        res = ob.kthLargest(arr, k)
        print(res)
        print("~")
        t -= 1

# } Driver Code Ends