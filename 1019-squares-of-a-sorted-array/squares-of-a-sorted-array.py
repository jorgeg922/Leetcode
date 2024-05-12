class Solution(object):
    def sortedSquares(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result = [0] * len(nums)
        left = 0
        right = len(nums)-1
        
        for i in range(len(nums)-1, -1, -1):
            if abs(nums[left]) > abs(nums[right]):
                square = nums[left]
                left+=1
            else:
                square = nums[right]
                right-=1
            result[i] = square * square;
        return result
            