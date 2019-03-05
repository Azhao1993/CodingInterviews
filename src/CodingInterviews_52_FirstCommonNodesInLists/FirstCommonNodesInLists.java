package CodingInterviews_52_FirstCommonNodesInLists;

import ListNode.ListNode;

/*
	面试题52：两个链表的第一个公共结点(题目要求不明确，环，双向链表)
		输入两个链表，找出它们的第一个公共结点。
 */
public class FirstCommonNodesInLists {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		}
		int length1 = 0;
		ListNode root = pHead1;
		int length2 = 0;
		while (root != null) {
			length1++;
			root = root.next;
		}
		root = pHead2;
		while (root != null) {
			length2++;
			root = root.next;
		}
		if (length1 > length2) {
			int dif = length1 - length2;
			for (int i = 0; i < dif; i++) {
				pHead1 = pHead1.next;
			}
		} else {
			int dif = length2 - length1;
			for (int i = 0; i < dif; i++) {
				pHead2 = pHead2.next;
			}
		}
		while (pHead1 != null) {
			if (pHead1.val == pHead2.val) {
				return pHead2;
			} else {
				pHead1 = pHead1.next;
				pHead2 = pHead2.next;
			}
		}
		return null;

	}

	// cpp版本改写
	public ListNode FindFirstCommonNodeCppToJava(ListNode pHead1, ListNode pHead2) {
		// 得到两个链表的长度
		int nLength1 = GetListLength(pHead1);
		int nLength2 = GetListLength(pHead2);
		int nLengthDif = nLength1 - nLength2;

		ListNode pListHeadLong = pHead1;
		ListNode pListHeadShort = pHead2;
		if (nLength2 > nLength1) {
			pListHeadLong = pHead2;
			pListHeadShort = pHead1;
			nLengthDif = nLength2 - nLength1;
		}

		// 先在长链表上走几步，再同时在两个链表上遍历
		for (int i = 0; i < nLengthDif; ++i)
			pListHeadLong = pListHeadLong.next;

		while ((pListHeadLong != null) && (pListHeadShort != null) && (pListHeadLong != pListHeadShort)) {
			pListHeadLong = pListHeadLong.next;
			pListHeadShort = pListHeadShort.next;
		}

		// 得到第一个公共结点
		ListNode pFisrtCommonNode = pListHeadLong;

		return pFisrtCommonNode;
	}

	public int GetListLength(ListNode pHead) {
		int nLength = 0;
		ListNode pNode = pHead;
		while (pNode != null) {
			++nLength;
			pNode = pNode.next;
		}

		return nLength;
	}
}
