class Solution:
    def makeFancyString(self, s: str) -> str:
        n = len(s)
        count = 1
        res = s[0] + ""
        for i in range(1,n):
            if s[i] == s[i-1]:
                count += 1
                if count < 3:
                    res += s[i]
            else:
                count = 1
                res += s[i]
        return res