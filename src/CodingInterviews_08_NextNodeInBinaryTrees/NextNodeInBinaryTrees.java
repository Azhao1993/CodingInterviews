package CodingInterviews_08_NextNodeInBinaryTrees;

import TreeLinkNode.TreeLinkNode;

/*
	 面试题8：二叉树的下一个结点
		 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
		 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 */
public class NextNodeInBinaryTrees {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return pNode;
		}
		TreeLinkNode pNext = null;
		if (pNode.right != null) {
			// 有右子树:右子树最左的节点
			pNext = pNode.right;
			while (pNext.left != null) {
				pNext = pNext.left;
			}
			return pNext;
		} else {
			// 没有右子树

			// 在左，返回父节点
			// 在右，当前节点为某个节点的左子树的最右的节点，找个找个节点——>向上找，找到不是右子树

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
