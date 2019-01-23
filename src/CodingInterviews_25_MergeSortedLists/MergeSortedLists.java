package CodingInterviews_25_MergeSortedLists;

import ListNode.ListNode;

/*
	面试题25：合并两个排序的链表
		输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按
		照递增排序的。
 */
public class MergeSortedLists {
	// cpp版本改写
	// 递归
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

	// 迭代
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
