package CodingInterviews_12_StringPathInMatrix;

/*
	 面试题12：矩阵中的路径
		 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
			 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
			 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
			 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
			 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
			 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
			 A B T G
			 C F C S
			 J D E H
 */
public class StringPathInMatrix {
	boolean[] used;
	int rows;
	int cols;
	char[] matrix;
	char[] str;
	int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		used = new boolean[matrix.length];
		this.rows = rows;
		this.cols = cols;
		this.matrix = matrix;
		this.str = str;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (isPath(i, j, 0)) {
					return true;
				}
			}
		}
		return false;

	}

	private boolean isPath(int x, int y, int k) {

		int index = x * cols + y;
		if (matrix[index] != str[k] || used[index]) {
			return false;
		}
		if (k == str.length - 1) {
			return true;
		}
		used[index] = true;
		for (int i = 0; i < 4; i++) {
			int nextx = x + d[i][0];
			int nexty = y + d[i][1];
			if (isValid(nextx, nexty)) {
				if (isPath(nextx, nexty, k + 1)) {
					return true;
				}
			}
		}
		used[index] = false;
		return false;
	}

	private boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < rows && y < cols;
	}

}
