package CodingInterviews_50_FirstNotRepeatingChar;

import java.util.HashMap;

/*
	面试题50（一）：字符串中第一个只出现一次的字符
		在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'。
 */
public class FirstNotRepeatingCharInString {
	public int firstNotRepeatingChar(String str) {
		if (str == null || str.length() == 0) {
			return -1;
		}
		if (str.length() == 1) {
			return 0;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (map.containsKey(temp)) {
				map.put(temp, 0);
			} else {
				map.put(temp, i + 1);
			}
		}
		int result = Integer.MAX_VALUE;
		for (Character ch : map.keySet()) {
			if (map.get(ch) != 0) {
				result = Math.min(map.get(ch), result);
			}
		}
		if (result == Integer.MAX_VALUE) {
			return 0;
		}
		return result - 1;
	}
}
