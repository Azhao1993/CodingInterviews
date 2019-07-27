package CodingInterviews_35_35_CopyComplexList;

import ListNode.RandomListNode;

/*
	 ������35����������ĸ���
		 ��Ŀ����ʵ�ֺ���ComplexListNode* Clone(ComplexListNode* pHead)����
		 ��һ�����������ڸ��������У�ÿ����������һ��m_pNextָ��ָ����һ��
		 ����⣬����һ��m_pSibling ָ�������е����������nullptr��
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
