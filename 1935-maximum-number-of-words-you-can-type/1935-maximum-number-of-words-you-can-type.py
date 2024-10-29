class Solution:
    def canBeTypedWords(self, text: str, brokenLetters: str) -> int:
        words = text.split(" ")
        count = 0
        for word in words:
            flag = True
            for ch in word:
                if ch in brokenLetters:
                    flag = False
                    break
            if flag:
                count+=1

        return count
