package CodingInterviews_49_UglyNumber;

/*
	面试题49：丑数
		我们把只包含因子2、3和5的数称作丑数（Ugly Number）。
		求按从小到大的顺序的第1500个丑数。
		例如6、8都是丑数，但14不是，因为它包含因子7。
		习惯上我们把1当做第一个丑数。
 */
public class UglyNumber {
	public static void main(String[] args) {
		int index = 8;
		new UglyNumber().GetUglyNumber_Solution(index);
	}

	public int GetUglyNumber_Solution(int index) {
		if (index <= 6) {
			return index;
		}
		// 3个指针
		int i2 = 0;// *2
		int i3 = 0;// *3
		int i5 = 0;// *5
		int[] dp = new int[index];
		dp[0] = 1;
		for (int i = 1; i < index; i++) {
			int next2 = dp[i2] * 2;
			int next3 = dp[i3] * 3;
			int next5 = dp[i5] * 5;
			dp[i] = Math.min(next2, Math.min(next3, next5));
			//指针后移
			if (dp[i] == next2)
				i2++;
			if (dp[i] == next3)
				i3++;
			if (dp[i] == next5)
				i5++;
		}
		return dp[index - 1];
	}
}
