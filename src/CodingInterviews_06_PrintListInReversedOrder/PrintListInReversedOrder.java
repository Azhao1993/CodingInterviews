package CodingInterviews_06_PrintListInReversedOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import ListNode.ListNode;

/*
	������6����β��ͷ��ӡ����
		����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��
 */
public class PrintListInReversedOrder {
	// ��ӡ���޸�

	// ��ջ�����淭ת
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (listNode == null) {
			return result;
		}

		Stack<ListNode> stack = new Stack<>();
		while (listNode != null) {
			stack.push(listNode);
			listNode = listNode.next;
		}
		while (!stack.isEmpty()) {
			result.add(stack.pop().val);
		}
		return result;
	}

	// �ݹ�
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (listNode == null) {
			return result;
		}
		PrintListReversingly_Recursively(listNode, result);
		return result;
	}

	public void PrintListReversingly_Recursively(ListNode pHead, ArrayList<Integer> result) {
		if (pHead.next != null) {
			PrintListReversingly_Recursively(pHead.next, result);
		}
		result.add(pHead.val);
	}
}
