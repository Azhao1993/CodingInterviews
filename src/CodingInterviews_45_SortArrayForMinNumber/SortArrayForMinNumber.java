package CodingInterviews_45_SortArrayForMinNumber;

import java.util.Arrays;

/*
	������45���������ų���С����
		����һ�����������飬����������������ƴ�������ų�һ������
		��ӡ��ƴ�ӳ���������������С��һ����
		������������{3, 32, 321}��
		���ӡ����3���������ųɵ���С����321323��
 */
public class SortArrayForMinNumber {
	public static void main(String[] args) {
		SortArrayForMinNumber safmn = new SortArrayForMinNumber();
		int[] numbers = { 3, 32, 321 };
		System.out.println(safmn.PrintMinNumber(numbers));
	}

	public String PrintMinNumber(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return null;
		}
		Arrays.sort(numbers);
		String result = String.valueOf(numbers[0]);
		if (numbers.length == 1) {
			return result;
		}
		for (int i = 1; i < numbers.length; i++) {
			String temp = String.valueOf(numbers[i]);
			result = compare(result, temp);
		}
		return result;

	}

	public String compare(String result, String temp) {
		String a = result + temp;
		String b = temp + result;
		if (a.compareTo(b) < 0) {
			return a;
		} else {
			return b;
		}
	}
}
