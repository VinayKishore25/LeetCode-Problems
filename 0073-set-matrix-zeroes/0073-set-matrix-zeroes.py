class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        m = len(matrix[0])
        row_set = set()
        col_set = set()
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == 0:
                    row_set.add(i)
                    col_set.add(j)
        for i in row_set:
            for j in range(m):
                matrix[i][j] = 0
        for j in col_set:
            for i in range(n):
                matrix[i][j] = 0

        