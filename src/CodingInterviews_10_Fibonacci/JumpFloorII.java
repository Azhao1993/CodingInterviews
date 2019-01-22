package CodingInterviews_10_Fibonacci;

/*
	变态跳台阶：
		一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
		求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {
	// f(n)=2^(n-1)
	public int JumpFloor2(int target) {
		if (target < 0) {
			return 0;
		}
		if (target < 1) {
			return 1;
		}
		int[] result = new int[target + 1];
		result[0] = 1;

		for (int i = 1; i <= target; i++) {
			int res = 0;
			for (int j = 0; j < i; j++) {
				res += result[j];
			}
			result[i] = res;
		}
		return result[target];

	}
}
