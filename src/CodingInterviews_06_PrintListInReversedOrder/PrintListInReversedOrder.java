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
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (listNode == null) {
			return result;
		}
		while (listNode != null) {
			result.add(listNode.val);
			listNode = listNode.next;
		}
		Collections.reverse(result);
		return result;
	}

	// cpp�汾��д����ջ�����淭ת
	public void PrintListReversingly_Iteratively(ListNode pHead) {
		Stack<ListNode> nodes = new Stack<ListNode>();

		ListNode pNode = pHead;
		while (pNode != null) {
			nodes.push(pNode);
			pNode = pNode.next;
		}

		while (!nodes.isEmpty()) {
			pNode = nodes.pop();
			System.out.println(pNode.val);
		}
	}

	// �ݹ�
	public void PrintListReversingly_Recursively(ListNode pHead) {
		if (pHead != null) {
			if (pHead.next != null) {
				PrintListReversingly_Recursively(pHead.next);
			}

			System.out.println(pHead.val);
		}
	}
}
