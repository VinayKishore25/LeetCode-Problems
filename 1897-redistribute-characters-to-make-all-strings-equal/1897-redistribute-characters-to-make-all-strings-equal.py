class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        n = len(words)
        dic = {}
        for word in words:
            for ch in word:
                if ch in dic:
                    dic[ch] += 1
                else:
                    dic[ch] = 1
        for ch in dic:
            if dic[ch] % n != 0:
                return False
        return True