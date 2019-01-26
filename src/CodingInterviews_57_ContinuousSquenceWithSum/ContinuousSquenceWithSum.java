package CodingInterviews_57_ContinuousSquenceWithSum;

import java.util.ArrayList;

/*
	面试题57（二）：为s的连续正数序列
		输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
		例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、 4～6和7～8。
 */
public class ContinuousSquenceWithSum {
	public static void main(String[] args) {
		ContinuousSquenceWithSum csws = new ContinuousSquenceWithSum();
		csws.FindContinuousSequence(3);
	}

	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int i = 1;
		int j = 1;
		int count = 0;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		while (i < sum) {
			if (j <= sum) {
				if (count < sum) {
					count += j;
					temp.add(j++);
				} else if (count == sum) {
					ArrayList<Integer> temp2 = new ArrayList<Integer>();
					temp2.addAll(temp);
					result.add(temp2);
					count -= i++;
					temp.remove(0);
				} else {
					count -= i++;
					temp.remove(0);
				}
			} else {
				count -= i++;
				temp.remove(0);
			}
		}
		return result;
	}
}
