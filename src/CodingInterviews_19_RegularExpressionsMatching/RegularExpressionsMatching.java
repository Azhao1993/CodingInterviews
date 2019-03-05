package CodingInterviews_19_RegularExpressionsMatching;

/*
	������19��������ʽƥ��
		��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��
		ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ���0�Σ���
		�ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
		���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬����"aa.a"��"ab*a"����ƥ�䡣
 */
public class RegularExpressionsMatching {
	public static void main(String[] args) {
		// "",".*"
		char[] str = "aaa".toCharArray();
		char[] pattern = "a.a".toCharArray();
		new RegularExpressionsMatching().match(str, pattern);
	}

	public boolean match(char[] str, char[] pattern) {
		return matchTwo(str, 0, str.length, pattern, 0, pattern.length);
	}

	private boolean matchTwo(char[] str, int i, int length1, char[] pattern, int j, int length2) {
		// �ַ�����ģʽͬʱ����
		if (i == length1 && j == length2) {
			return true;
		}
		// �ַ���������ģʽû����
		if (i == length1 && j != length2) {
			// ��Ҫֻʣ'*'����'.*'
			while (j != length2) {
				if (pattern[j] != '*' && (j + 1 >= length2 || pattern[j + 1] != '*')) {
					return false;
				}
				j++;
			}
			return true;
		}
		// �ַ���δ��������ģʽ����
		if (i != length1 && j == length2) {
			return false;
		}
		// ģʽ�������һλ
		if (j + 1 == length2) {
			// ƥ�����ģʽ���һλ'.',������ƶ�һλ
			if (str[i] == pattern[j] || pattern[j] == '.')
				return matchTwo(str, i + 1, length1, pattern, j + 1, length2);
			else {
				return false;
			}
		}
		// ƥ�����ģʽΪ'.'����ģʽ��һλ����'*',������ƶ�һλ
		if ((str[i] == pattern[j] || pattern[j] == '.') && pattern[j + 1] != '*')
			return matchTwo(str, i + 1, length1, pattern, j + 1, length2);
		// ƥ�����ģʽΪ'.'������ģʽ��һλ��'*,
		if ((str[i] == pattern[j] || pattern[j] == '.') && pattern[j + 1] == '*')
			// �ַ���������ģʽ����ƶ���λ
			return matchTwo(str, i, length1, pattern, j + 2, length2)
					// �ַ�������ƶ���ģʽ����
					|| matchTwo(str, i + 1, length1, pattern, j, length2);
		// ��ƥ�䣬��ģʽƥ�����һλ��'*',ģʽ����ƶ���λ
		if (pattern[j + 1] == '*')
			return matchTwo(str, i, length1, pattern, j + 2, length2);
		return false;
	}
}
