package CodingInterviews_31_StackPushPopOrder;

import java.util.Stack;

/*
	������31��ջ��ѹ�롢��������
		��Ŀ�����������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ���������
		��Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ�
		��������1��2��3��4��5��ĳջ��ѹջ���У�
		����4��5��3��2��1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
		��4��3��5��1��2�Ͳ������Ǹ�ѹջ���еĵ������С�
 */
public class StackPushPopOrder {
	public boolean IsPopOrder(int[] pushA, int[] popA) {

		Stack<Integer> stack = new Stack<>();
		int i = 0;
		int j = 0;
		while (j < popA.length) {
			while (stack.isEmpty() || stack.peek() != popA[j]) {
				if (i == pushA.length) {
					break;
				}
				stack.push(pushA[i++]);
			}

			if (stack.peek() != popA[j]) {
				break;
			}
			stack.pop();
			j++;
		}
		return stack.isEmpty();
	}

	// cpp�汾
	public boolean IsPopOrderCppToJava(int[] pushA, int[] popA) {
		boolean bPossible = false;
		int nLength = popA.length;
		int i = 0;
		int j = 0;

		if (pushA != null && popA != null && nLength > 0) {
			int pNextPush = pushA[i];
			int pNextPop = popA[j];

			Stack<Integer> stackData = new Stack<>();

			while (j < nLength) {
				// ������ջ��ջ��Ԫ�ز���Ҫ������Ԫ��
				// ��ѹ��һЩ������ջ
				while (stackData.isEmpty() || stackData.peek() != pNextPop) {
					// ����������ֶ�ѹ�븨��ջ�ˣ��˳�ѭ��

					if (i == nLength)
						break;
					pNextPush = pushA[i];
					stackData.push(pNextPush);
					i++;
				}

				if (stackData.peek() != pNextPop)
					break;

				stackData.pop();
				pNextPop = popA[++j];
			}

			if (stackData.isEmpty() && j == nLength)
				bPossible = true;
		}
		return bPossible;
	}
}
