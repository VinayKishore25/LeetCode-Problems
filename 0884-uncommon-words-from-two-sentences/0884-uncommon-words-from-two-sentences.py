class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        l = list(s1.split(" "))
        s = list(s2.split(" "))
        dic = {}
        for i in l:
            if i in dic:
                dic[i]+=1
            else:
                dic[i] = 1
        for i in s:
            if i in dic:
                dic[i] += 1
            else:
                dic[i] = 1
        res = []
        for i in dic:
            if dic[i] == 1:
                res.append(i)
        return res