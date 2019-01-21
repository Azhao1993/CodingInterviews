package CodingInterviews_04_FindInPartiallySortedMatrix;

/*
	面试题4：	二维数组中的查找
	在一个二维数组中（每个一维数组的长度相同），
	每一行都按照从左到右递增的顺序排序，
	每一列都按照从上到下递增的顺序排序。
	请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
*/
public class FindInPartiallySortedMatrix {
	//面试题4：
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

	// cpp代码改写
	public boolean Find(int[][] matrix, int rows, int columns, int number) {
		boolean found = false;
		if (matrix != null && rows > 0 && columns > 0) {
			int row = 0;// 行
			int column = columns - 1;// 列
			// 每行的最后一个数与target大小关系
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
