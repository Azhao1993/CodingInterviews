package CodingInterviews_06_PrintListInReversedOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import ListNode.ListNode;

/*
	面试题6：从尾到头打印链表
		输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintListInReversedOrder {
	// 打印后修改
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

	// cpp版本改写：用栈来代替翻转
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

	// 递归
	public void PrintListReversingly_Recursively(ListNode pHead) {
		if (pHead != null) {
			if (pHead.next != null) {
				PrintListReversingly_Recursively(pHead.next);
			}

			System.out.println(pHead.val);
		}
	}
}
