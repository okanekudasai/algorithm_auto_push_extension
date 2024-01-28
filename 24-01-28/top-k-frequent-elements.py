# 문제 : top-k-frequent-elements
# 결과 : Accepted / 속도: 87ms / 메모리 : 21.02MB
# 제출시각 : 24-01-28  20:51:54
class Solution:

    from collections import Counter

    def topKFrequent(self, nums: List[int], k: int) -> List[int]:



        nums_fre = Counter(nums)

        

        result = sorted(nums_fre.items(), key = lambda x : x[1], reverse = True) 



        return [result[i][0] for i in range(k)]
