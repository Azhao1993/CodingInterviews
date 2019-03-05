package CodingInterviews_19_RegularExpressionsMatching;

/*
	面试题19：正则表达式匹配
		请实现一个函数用来匹配包含'.'和'*'的正则表达式。
		模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
		在本题中，匹配是指字符串的所有字符匹配整个模式。
		例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
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
		// 字符串和模式同时结束
		if (i == length1 && j == length2) {
			return true;
		}
		// 字符串结束但模式没结束
		if (i == length1 && j != length2) {
			// 需要只剩'*'或者'.*'
			while (j != length2) {
				if (pattern[j] != '*' && (j + 1 >= length2 || pattern[j + 1] != '*')) {
					return false;
				}
				j++;
			}
			return true;
		}
		// 字符串未结束，但模式结束
		if (i != length1 && j == length2) {
			return false;
		}
		// 模式到做最后一位
		if (j + 1 == length2) {
			// 匹配或者模式最后一位'.',各向后移动一位
			if (str[i] == pattern[j] || pattern[j] == '.')
				return matchTwo(str, i + 1, length1, pattern, j + 1, length2);
			else {
				return false;
			}
		}
		// 匹配或者模式为'.'并且模式下一位不是'*',各向后移动一位
		if ((str[i] == pattern[j] || pattern[j] == '.') && pattern[j + 1] != '*')
			return matchTwo(str, i + 1, length1, pattern, j + 1, length2);
		// 匹配或者模式为'.'，并且模式下一位是'*,
		if ((str[i] == pattern[j] || pattern[j] == '.') && pattern[j + 1] == '*')
			// 字符串不动，模式向后移动两位
			return matchTwo(str, i, length1, pattern, j + 2, length2)
					// 字符串向后移动，模式不动
					|| matchTwo(str, i + 1, length1, pattern, j, length2);
		// 不匹配，但模式匹配的下一位是'*',模式向后移动两位
		if (pattern[j + 1] == '*')
			return matchTwo(str, i, length1, pattern, j + 2, length2);
		return false;
	}
}
