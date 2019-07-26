package CodingInterviews_22_KthNodeFromEnd;

import ListNode.ListNode;

/*
	������22�������е�����k�����
		����һ����������������е�����k����㡣
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

	// cpp�汾��д
	// ע�⣺1.ͷָ��Ϊ�գ�2.������С��k;3.k����ֵ��������

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
