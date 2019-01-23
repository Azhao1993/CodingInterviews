package CodingInterviews_24_ReverseList;

import ListNode.ListNode;

/*
	������24����ת����
		����һ��������ת��������������ı�ͷ��
 */
public class ReverseList {
	// cpp�汾��д����
	public ListNode reverseList(ListNode head) {
		// ������
		if (head == null) {
			return null;
		}
		// �������
		if (head.next == null) {
			return head;
		}
		// �ȴ����һ���ڵ��Ϊ��ͷ���
		ListNode newHead = null;
		// ǰһ���ڵ㣬��ǰ�ڵ㣬��һ���ڵ�
		ListNode pre = null;
		ListNode cur = head;
		ListNode next = null;
		while (cur != null) {
			// ��¼���Ѻ�Ľڵ�
			next = cur.next;
			// ������Ѻ�Ľڵ��ǿսڵ�˵����ת���
			if (next == null) {
				newHead = cur;
			}
			// ��ǰ�ڵ�ָ��ǰһ���ڵ㣬��һ���ڵ����
			cur.next = pre;
			// ��ǰ�ڵ��Ϊǰһ���ڵ�
			pre = cur;
			// ��һ���ڵ��Ϊ��ǰ�ڵ�
			cur = next;
		}
		// ������ͷ�ڵ�
		return newHead;
	}

	// �ݹ�
	public ListNode reverseList1(ListNode head) {
		// û�нڵ����ֻ��һ���ڵ�
		if (head == null || head.next == null) {
			return head;
		}
		// ���������һ���ڵ�
		ListNode newHead = reverseList1(head.next);
		// head����һ���ڵ�ָ��head
		head.next.next = head;
		// ��head��һ���ڵ��Ϊ�սڵ�
		head.next = null;
		// ������ͷ�ڵ�
		return newHead;
	}
}
