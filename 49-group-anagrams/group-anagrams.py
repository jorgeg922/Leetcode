class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hashmap = {}
        for str in strs:
            currChars = list(str)
            currChars.sort()
            reconstructedStr = ''.join(currChars)
            if reconstructedStr not in hashmap:
                hashmap[reconstructedStr] = []
            hashmap[reconstructedStr].append(str)
        
        ans = []
        for key, value in hashmap.items():
            ans.append(value)
        
        return ans