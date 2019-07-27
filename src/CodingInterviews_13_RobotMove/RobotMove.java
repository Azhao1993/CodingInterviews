package CodingInterviews_13_RobotMove;

import java.util.LinkedList;
import java.util.Queue;

/*
	 面试题13：机器人的运动范围
		 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
		 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
		 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
		 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
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
