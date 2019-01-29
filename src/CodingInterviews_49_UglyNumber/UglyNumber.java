package CodingInterviews_49_UglyNumber;

/*
	������49������
		���ǰ�ֻ��������2��3��5��������������Ugly Number����
		�󰴴�С�����˳��ĵ�1500��������
		����6��8���ǳ�������14���ǣ���Ϊ����������7��
		ϰ�������ǰ�1������һ��������
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
		// 3��ָ��
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
			//ָ�����
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
