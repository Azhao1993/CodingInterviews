package CodingInterviews_12_StringPathInMatrix;

/*
	 ������12�������е�·��
		 ��Ŀ�������һ�������������ж���һ���������Ƿ����һ������ĳ�ַ�������
			 �ַ���·����·�����ԴӾ���������һ��ʼ��ÿһ�������ھ����������ҡ�
			 �ϡ����ƶ�һ�����һ��·�������˾����ĳһ����ô��·�������ٴν���
			 �ø��ӡ������������3��4�ľ����а���һ���ַ�����bfce����·����·���е���
			 ĸ���»��߱�������������в������ַ�����abfb����·������Ϊ�ַ����ĵ�һ��
			 �ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���������ӡ�
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
