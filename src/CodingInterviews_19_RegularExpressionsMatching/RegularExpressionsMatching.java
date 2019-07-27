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

	public boolean match2(char[] str, char[] pattern) {
		if (str.length == 0 && pattern.length == 0) {
			return true;
		}
		boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
		dp[str.length][pattern.length] = true;
		for (int i = str.length; i >= 0; i--) {
			for (int j = pattern.length; j >= 0; j--) {
				boolean first_match = (i < str.length && (pattern[j] == str[i] || pattern[j] == '.'));
				if (j + 1 < pattern.length && pattern[j + 1] == '*') {
					dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
				} else {
					dp[i][j] = first_match && dp[i + 1][j + 1];
				}
			}
		}
		return dp[0][0];
	}

}
