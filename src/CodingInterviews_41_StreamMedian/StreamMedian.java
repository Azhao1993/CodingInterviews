package CodingInterviews_41_StreamMedian;

import java.util.ArrayList;

/*
	������41���������е���λ��
		��εõ�һ���������е���λ����������������ж�����������ֵ��
		��ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ��
		��ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 */
public class StreamMedian {
	public static void main(String[] args) {
		Integer[] nums = { 5, 2, 3, 4, 1, 6, 7, 0, 8 };
		StreamMedian sm = new StreamMedian();
		for (int i = 0; i < nums.length; i++) {
			sm.Insert(nums[i]);
			System.out.println(sm.GetMedian());
		}
	}

	ArrayList<Integer> list = new ArrayList<Integer>();

	public void Insert(Integer num) {
		if (list.isEmpty()) {
			list.add(num);
		}else if (list.get(0) >= num) {
			list.add(0, num);
		} else if (list.get(list.size() - 1) <= num) {
			list.add(num);
		} else {
			for (int i = 0; i < list.size() - 1; i++) {
				if (num > list.get(i) && num <= list.get(i + 1)) {
					list.add(i + 1, num);
				}
			}
		}

	}

	public Double GetMedian() {
		if (list.size() == 0) {
			return 0.0;
		}
		double result = 0.0;
		if (list.size() % 2 == 1) {
			result = (double) list.get(list.size() / 2);
		} else {
			double mid1 = (double) list.get(list.size() / 2);
			double mid2 = (double) list.get(list.size() / 2 - 1);
			result = (mid1 + mid2) / 2;
		}
		return result;
	}
}
