package CodingInterviews_29_PrintMatrix;

import java.util.ArrayList;

/*
	������29��˳ʱ���ӡ����
		����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֡�
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
		// ֻ��һ��
		if (a == c) {
			cur = b;
			while (cur <= d) {
				res.add(matrix[a][cur++]);
			}
			return;
		}
		// ֻ��һ��
		if (b == d) {
			cur = a;
			while (cur <= c) {
				res.add(matrix[cur++][b]);
			}
			return;
		}
		// ���ң�a,b->d-1��
		cur = b;
		while (cur < d) {
			res.add(matrix[a][cur++]);
		}
		// ���£�a->c-1,d��
		cur = a;
		while (cur < c) {
			res.add(matrix[cur++][d]);
		}
		// ����c,d->b+1��
		cur = d;
		while (cur > b) {
			res.add(matrix[c][cur--]);
		}
		// ���ϣ�c->a+1,b��
		cur = c;
		while (cur > a) {
			res.add(matrix[cur--][b]);
		}

	}
}
