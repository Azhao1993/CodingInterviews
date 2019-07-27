package CodingInterviews_31_StackPushPopOrder;

import java.util.Stack;

/*
	面试题31：栈的压入、弹出序列
		题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
		否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
		例如序列1、2、3、4、5是某栈的压栈序列，
		序列4、5、3、2、1是该压栈序列对应的一个弹出序列，
		但4、3、5、1、2就不可能是该压栈序列的弹出序列。
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

	// cpp版本
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
				// 当辅助栈的栈顶元素不是要弹出的元素
				// 先压入一些数字入栈
				while (stackData.isEmpty() || stackData.peek() != pNextPop) {
					// 如果所有数字都压入辅助栈了，退出循环

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
