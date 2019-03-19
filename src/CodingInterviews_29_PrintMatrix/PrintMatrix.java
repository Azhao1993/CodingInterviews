package CodingInterviews_29_PrintMatrix;

import java.util.ArrayList;

/*
	面试题29：顺时针打印矩阵
		输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class PrintMatrix {
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0) {
			return res;
		}
		int a = 0;
		int b = 0;
		int c = matrix.length - 1;
		int d = matrix[0].length - 1;
		while (a <= c && b <= d) {
			printEdge(matrix, a++, b++, c--, d--, res);
		}
		return res;

	}

	public void printEdge(int[][] matrix, int a, int b, int c, int d, ArrayList<Integer> res) {
		int cur = 0;
		// 只有一行
		if (a == c) {
			cur = b;
			while (cur <= d) {
				res.add(matrix[a][cur++]);
			}
			return;
		}
		// 只有一列
		if (b == d) {
			cur = a;
			while (cur <= c) {
				res.add(matrix[cur++][b]);
			}
			return;
		}
		// 向右（a,b->d-1）
		cur = b;
		while (cur < d) {
			res.add(matrix[a][cur++]);
		}
		// 向下（a->c-1,d）
		cur = a;
		while (cur < c) {
			res.add(matrix[cur++][d]);
		}
		// 向左（c,d->b+1）
		cur = d;
		while (cur > b) {
			res.add(matrix[c][cur--]);
		}
		// 向上（c->a+1,b）
		cur = c;
		while (cur > a) {
			res.add(matrix[cur--][b]);
		}

	}
}
