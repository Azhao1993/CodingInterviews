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
}
