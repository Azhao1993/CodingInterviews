package CodingInterviews_04_FindInPartiallySortedMatrix;

/*
	������4��	��ά�����еĲ���
	��һ����ά�����У�ÿ��һά����ĳ�����ͬ����
	ÿһ�ж����մ����ҵ�����˳������
	ÿһ�ж����մ��ϵ��µ�����˳������
	�����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
*/
public class FindInPartiallySortedMatrix {
	//������4��
	public boolean Find(int target, int[][] array) {
		if (array == null || array.length == 0 || array[0].length == 0) {
			return false;
		}
		int col = array.length;
		int row = array[0].length;
		if (target < array[0][0] || array[col - 1][row - 1] < target) {
			return false;
		}
		int c = 0;
		while (target > array[c][row - 1]) {
			c++;
		}
		int r = 0;
		while (target > array[col - 1][r]) {
			r++;
		}
		for (int i = c; i < col; i++) {
			for (int j = r; j < row; j++) {
				if (target == array[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

	// cpp�����д
	public boolean Find(int[][] matrix, int rows, int columns, int number) {
		boolean found = false;
		if (matrix != null && rows > 0 && columns > 0) {
			int row = 0;// ��
			int column = columns - 1;// ��
			// ÿ�е����һ������target��С��ϵ
			while (row < rows && column >= 0) {

				if (matrix[row][column] == number) {
					found = true;
					break;
				} else if (matrix[row][column] > number) {
					--column;
				} else {
					++row;
				}
			}
		}
		return found;
	}
}
