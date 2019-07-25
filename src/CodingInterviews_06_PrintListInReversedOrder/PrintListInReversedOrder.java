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

	// 用栈来代替翻转
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

	// 递归
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
