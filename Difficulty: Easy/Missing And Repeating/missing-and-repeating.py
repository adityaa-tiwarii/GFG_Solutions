from collections import Counter
class Solution:
     def findTwoElement(self, arr):
          # code here
          n = len(arr)
          maxi = n * (n+1) // 2
          total = sum(arr)
          store = Counter(arr)
          double = 0

          for key, value in store.items():
               if value == 2:
                    double += key
                    total -= key
                    break

          missing  = maxi - total
          return [double, missing]