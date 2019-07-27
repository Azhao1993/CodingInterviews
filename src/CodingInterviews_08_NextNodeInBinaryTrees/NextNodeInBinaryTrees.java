package CodingInterviews_08_NextNodeInBinaryTrees;

import TreeLinkNode.TreeLinkNode;

/*
	 ������8������������һ�����
		 ��Ŀ������һ�ö����������е�һ����㣬����ҳ��������˳�����һ����㣿
		 ���еĽ������������ֱ�ָ�������ӽ���ָ�����⣬����һ��ָ�򸸽���ָ�롣
 */
public class NextNodeInBinaryTrees {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return pNode;
		}
		TreeLinkNode pNext = null;
		if (pNode.right != null) {
			// ��������:����������Ľڵ�
			pNext = pNode.right;
			while (pNext.left != null) {
				pNext = pNext.left;
			}
			return pNext;
		} else {
			// û��������

			// ���󣬷��ظ��ڵ�
			// ���ң���ǰ�ڵ�Ϊĳ���ڵ�������������ҵĽڵ㣬�Ҹ��Ҹ��ڵ㡪��>�����ң��ҵ�����������

			TreeLinkNode pCurrent = pNode;
			TreeLinkNode pParent = pNode.next;			
			while (pParent != null && pCurrent == pParent.right) {
				pCurrent = pParent;
				pParent = pParent.next;
			}
			pNext = pParent;
		}
		return pNext;
	}
}
