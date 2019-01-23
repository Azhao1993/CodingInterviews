package CodingInterviews_25_MergeSortedLists;

import ListNode.ListNode;

/*
	������25���ϲ��������������
		����������������������ϲ�����������ʹ�������еĽ����Ȼ�ǰ�
		�յ�������ġ�
 */
public class MergeSortedLists {
	// cpp�汾��д
	// �ݹ�
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode newHead = null;
		if (list1.val < list2.val) {
			newHead = list1;
			newHead.next = Merge(list1.next, list2);
		} else {
			newHead = list2;
			newHead.next = Merge(list1, list2.next);
		}
		return newHead;
	}

	// ����
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode result = new ListNode(0);
		ListNode prev = result;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}
		if (l1 != null) {
			prev.next = l1;
		}
		if (l2 != null) {
			prev.next = l2;
		}
		return result.next;
	}
}
