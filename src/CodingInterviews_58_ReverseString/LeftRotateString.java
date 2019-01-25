package CodingInterviews_58_ReverseString;

/*
	������58������������ת�ַ���
		�ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β����
		�붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ�
		���������ַ���"abcdefg"������2���ú�������������ת2λ�õ��Ľ��"cdefgab"��
 */
public class LeftRotateString {

	public String leftRotateString(String str, int n) {
		if (str == null || n > str.length()) {
			return "";
		}
		StringBuilder sb = new StringBuilder(str);
		String temp = sb.substring(0, n);
		sb.delete(0, n).append(temp);
		return sb.toString();
	}
	// cpp�汾��д

}
