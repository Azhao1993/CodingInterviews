package CodingInterviews_24_ReverseList;

import ListNode.ListNode;

/*
	面试题24：反转链表
		输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
	// cpp版本改写如下
	public ListNode reverseList(ListNode head) {
		// 空链表
		if (head == null) {
			return null;
		}
		// 单个结点
		if (head.next == null) {
			return head;
		}
		// 等待最后一个节点成为新头结点
		ListNode newHead = null;
		// 前一个节点，当前节点，下一个节点
		ListNode pre = null;
		ListNode cur = head;
		ListNode next = null;
		while (cur != null) {
			// 记录断裂后的节点
			next = cur.next;
			// 如果断裂后的节点是空节点说明反转完成
			if (next == null) {
				newHead = cur;
			}
			// 当前节点指向前一个节点，下一个节点断裂
			cur.next = pre;
			// 当前节点成为前一个节点
			pre = cur;
			// 下一个节点成为当前节点
			cur = next;
		}
		// 返回新头节点
		return newHead;
	}

	// 递归
	public ListNode reverseList1(ListNode head) {
		// 没有节点或者只有一个节点
		if (head == null || head.next == null) {
			return head;
		}
		// 如果存在下一个节点
		ListNode newHead = reverseList1(head.next);
		// head的下一个节点指向head
		head.next.next = head;
		// 将head下一个节点改为空节点
		head.next = null;
		// 返回新头节点
		return newHead;
	}
}
