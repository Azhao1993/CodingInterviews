package CodingInterviews_10_Fibonacci;

/*
	��̨�ף�
		һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
		�����������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 */
public class JumpFloor {
	public int jumpFloor(int target) {
		if (target < 0) {
			return 0;
		}
		if (target <= 1) { 
			return 1;
		} else {
			return jumpFloor(target - 1) + jumpFloor(target - 2);
		}
	}
}
