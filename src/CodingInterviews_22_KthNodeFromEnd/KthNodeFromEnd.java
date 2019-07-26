package CodingInterviews_22_KthNodeFromEnd;

import ListNode.ListNode;

/*
	面试题22：两遍中倒数第k个结点
		输入一个链表，输出该链表中倒数第k个结点。
 */
public class KthNodeFromEnd {
	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k < 0) {
			return null;
		}
		ListNode right = head;
		for (int i = 0; i < k; i++) {
			if (right != null) {
				right = right.next;
			} else {
				return null;
			}
		}

		while (right != null) {
			right = right.next;
			head = head.next;
		}
		return head;
	}

	// cpp版本改写
	// 注意：1.头指针为空；2.链表长度小于k;3.k的数值超过整型

	public ListNode FindKthToTailCpptoJava(ListNode pListHead, int k) {
		if (pListHead == null || k == 0)
			return null;

		ListNode pAhead = pListHead;
		ListNode pBehind = null;

		for (int i = 0; i < k - 1; ++i) {
			if (pAhead.next != null)
				pAhead = pAhead.next;
			else {
				return null;
			}
		}

		pBehind = pListHead;
		while (pAhead.next != null) {
			pAhead = pAhead.next;
			pBehind = pBehind.next;
		}

		return pBehind;
	}
}
