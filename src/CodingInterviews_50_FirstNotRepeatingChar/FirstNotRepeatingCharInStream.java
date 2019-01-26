package CodingInterviews_50_FirstNotRepeatingChar;

import java.util.HashSet;

/*
	������50���������ַ����е�һ��ֻ����һ�ε��ַ�
		��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
		���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���'g'��
		���Ӹ��ַ����ж���ǰ�����ַ�"google"ʱ����һ��ֻ����һ�ε��ַ���'l'��
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
