package CodingInterviews_58_ReverseString;

/*
	������58��һ������ת����˳��
		����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣
		Ϊ������������ź���ͨ��ĸһ������
		���������ַ���"I am a student. "�������"student. a am I"��
	ţ��������		
		ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
		ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
		���磬��student. a am I����
		��������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����
		Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 */
public class ReverseWordsInString {
	public String ReverseSentence(String str) {
		String[] arr = str.split(" ");
		if (arr.length == 0) {
			return str;
		}
		StringBuilder result = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; i--) {
			result.append(arr[i]);
			if (i != 0) {
				result.append(' ');
			}
		}
		return result.toString();
	}
	// cpp�汾��д

}
