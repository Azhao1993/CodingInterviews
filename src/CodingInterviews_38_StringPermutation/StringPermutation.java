package CodingInterviews_38_StringPermutation;

import java.util.ArrayList;
import java.util.Arrays;

/*
	面试题38：字符串的排列
		输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，
		则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 */
public class StringPermutation {
	public static void main(String[] args) {
		String str = "abc";
		StringPermutation sp = new StringPermutation();
		sp.Permutation(str);
	}

	public ArrayList<String> Permutation(String str) {
		ArrayList<String> res = new ArrayList<String>();
		if (str == null || str.length() == 0) {
			return res;
		}
		char[] nums = str.toCharArray();
		boolean[] used = new boolean[nums.length];
		// List<Character> list = new ArrayList<Character>();
		StringBuilder list = new StringBuilder();
		Arrays.sort(nums);
		dfs(nums, used, list, res);
		return res;
	}

	public void dfs(char[] nums, boolean[] used, StringBuilder list, ArrayList<String> res) {
		if (list.length() == nums.length) {
			res.add(list.toString());
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i])
				continue;
			if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
				continue;
			used[i] = true;
			list.append(nums[i]);
			dfs(nums, used, list, res);
			used[i] = false;
			list.deleteCharAt(list.length() - 1);
		}
	}

}
