package CodingInterviews_50_FirstNotRepeatingChar;

import java.util.HashSet;

/*
	面试题50（二）：字符流中第一个只出现一次的字符
		请实现一个函数用来找出字符流中第一个只出现一次的字符。
		例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。
		当从该字符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
 */
public class FirstNotRepeatingCharInStream {
	// Insert one char from stringstream
	HashSet<Character> set = new HashSet<Character>();
	StringBuilder sb = new StringBuilder();

	public void Insert(char ch) {
		if (!set.contains(ch)) {
			set.add(ch);
			sb.append(ch);
		} else {
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) == ch) {
					sb.deleteCharAt(i);
					break;
				}
			}
		}
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		if (sb.length() > 0) {
			return sb.charAt(0);
		} else {
			return '#';
		}
	}
}
