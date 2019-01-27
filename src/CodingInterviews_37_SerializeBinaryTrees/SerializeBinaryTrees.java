package CodingInterviews_37_SerializeBinaryTrees;

import java.util.ArrayList;
import java.util.Arrays;

import TreeNode.TreeNode;

/*
	面试题37：序列化二叉树
		请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class SerializeBinaryTrees {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		root.left = node2;
		root.right = node7;
		node2.left = node3;
		node2.right = node4;
		node4.left = node5;
		node4.right = node6;
		node7.right = node8;
		node8.left = node9;
		SerializeBinaryTrees sbt = new SerializeBinaryTrees();

		sbt.Deserialize(sbt.Serialize(root));
	}

	public String Serialize(TreeNode root) {
		String str = "";
		return Serialize(root, str);

	}

	public String Serialize(TreeNode root, String str) {
		if (root == null) {
			str += "null,";
			return str;
		}

		str += String.valueOf(root.val);
		str += ",";
		str = Serialize(root.left, str);
		str = Serialize(root.right, str);
		return str;

	}

	public TreeNode Deserialize(String str) {
		String[] node = str.split(",");
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(node));
		return Deserialize(list);
	}

	public TreeNode Deserialize(ArrayList<String> list) {
		if (list.get(0).equals("null")) {
			list.remove(0);
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
		list.remove(0);
		root.left = Deserialize(list);
		root.right = Deserialize(list);
		return root;
	}

}
