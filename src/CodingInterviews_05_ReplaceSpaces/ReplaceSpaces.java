package CodingInterviews_05_ReplaceSpaces;

/*
	������5: �滻�ո�
	��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20����
	���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */
public class ReplaceSpaces {
	public String replaceSpace(StringBuffer str) {
		int index = str.indexOf(" ");
		while (index != -1) {
			str.replace(index, index + 1, "%20");
			index = str.indexOf(" ");
		}
		return str.toString();
	}
	// cpp��˼·
	// ���ַ����������䣬�Ӻ���ǰ���ƣ�
}
