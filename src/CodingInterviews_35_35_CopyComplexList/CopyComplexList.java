package CodingInterviews_35_35_CopyComplexList;

import ListNode.RandomListNode;

/*
	 面试题35：复杂链表的复制
		 题目：请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，复
		 制一个复杂链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个
		 结点外，还有一个m_pSibling 指向链表中的任意结点或者nullptr。
 */
public class CopyComplexList {
	public RandomListNode Clone(RandomListNode pHead) {
		RandomListNode cur = pHead;
		while (cur != null) {
			RandomListNode copyCur = new RandomListNode(cur.label);
			copyCur.next = cur.next;
			cur.next = copyCur;
			cur = copyCur.next;
		}
		cur = pHead;
		while (cur != null) {
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}

		RandomListNode pummy = new RandomListNode(0);
		RandomListNode curCopy = pummy;

		cur = pHead;
		while (cur != null) {
			RandomListNode next = cur.next.next;
			curCopy.next = cur.next;
			cur.next = next;
			curCopy = curCopy.next;
			cur = cur.next;
		}
		return pummy.next;

	}
}
