package CodingInterviews_57_ContinuousSquenceWithSum;

import java.util.ArrayList;

/*
	������57��������Ϊs��������������
		����һ������s����ӡ�����к�Ϊs�������������У����ٺ�������������
		��������15������1+2+3+4+5=4+5+6=7+8=15�����Խ����ӡ��3����������1��5�� 4��6��7��8��
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
