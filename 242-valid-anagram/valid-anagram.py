class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        s_dic = {}
        for c in s:
            if c not in s_dic:
                s_dic[c] = 0
            
            s_dic[c]+=1

        for c in t:
            if c not in s_dic:
                return False
            else:
                s_dic[c]-=1
            
            if s_dic[c] == 0:
                s_dic.pop(c)
        
        return True if len(s_dic) == 0 else False
        