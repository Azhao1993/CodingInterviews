package CodingInterviews_67_StringToInt;

/*
	������67�����ַ���ת��������
		��һ���ַ���ת����һ������
		(ʵ��Integer.valueOf(string)�Ĺ��ܣ�����string����������Ҫ��ʱ����0)��
		Ҫ����ʹ���ַ���ת�������Ŀ⺯����
		 ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0��
		��������:
			����һ���ַ���,����������ĸ����,����Ϊ��
		�������:
			����ǺϷ�����ֵ����򷵻ظ����֣����򷵻�0
		ʾ����
			���룺	
				+2147483647
				    1a33
			�����		
				2147483647
				    0
 */
public class StringToInt {
	public int StrToInt(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] arr = str.toCharArray();
		boolean flag = false;
		if (arr[0] == '-' || arr[0] == '+') {
			flag = true;
		} else if (!isNum(arr[0])) {
			return 0;
		}

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 && flag) {
				continue;
			}
			if (isNum(arr[i])) {
				sum = sum * 10 + (arr[i] - '0');
			} else {
				return 0;
			}
		}
		if (flag && arr[0] == '-') {
			return -1 * sum;
		}
		return sum;

	}

	//
	public boolean isNum(char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		}
		return false;
	}
	// cpp�汾��д

}
