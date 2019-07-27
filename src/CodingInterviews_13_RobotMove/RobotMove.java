package CodingInterviews_13_RobotMove;

import java.util.LinkedList;
import java.util.Queue;

/*
	 ������13�������˵��˶���Χ
		 ��Ŀ��������һ��m��n�еķ���һ�������˴�����(0, 0)�ĸ��ӿ�ʼ�ƶ�����
		 ÿһ�ο��������ҡ��ϡ����ƶ�һ�񣬵����ܽ�������������������λ֮��
		 ����k�ĸ��ӡ����磬��kΪ18ʱ���������ܹ����뷽��(35, 37)����Ϊ3+5+3+7=18��
		 �������ܽ��뷽��(35, 38)����Ϊ3+5+3+8=19�����ʸû������ܹ�������ٸ����ӣ�
 */
public class RobotMove {
	boolean[][] used;
	int rows;
	int cols;
	int threshold;
	int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

	public int movingCount(int threshold, int rows, int cols) {
		if (threshold < 0) {
			return 0;
		}
		if (threshold == 0) {
			return 1;
		}
		this.rows = rows;
		this.cols = cols;
		this.threshold = threshold;
		used = new boolean[rows][cols];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });
		used[0][0] = true;
		int res = 1;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextx = cur[0] + d[i][0];
				int nexty = cur[1] + d[i][1];
				if (isValid(nextx, nexty) && !used[nextx][nexty] && canMove(nextx, nexty)) {
					used[nextx][nexty] = true;
					res++;
					queue.add(new int[] { nextx, nexty });
				}
			}
		}
		return res;
	}

	private boolean canMove(int nextx, int nexty) {
		int res = 0;
		while (nextx != 0) {
			res += nextx % 10;
			nextx /= 10;
		}
		while (nexty != 0) {
			res += nexty % 10;
			nexty /= 10;
		}
		return res <= threshold;
	}

	private boolean isValid(int x, int y) {
		return x >= 0 && x < rows && y >= 0 && y < cols;
	}
}
