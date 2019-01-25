package CodingInterviews_58_ReverseString;

/*
	面试题58（二）：左旋转字符串
		字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
		请定义一个函数实现字符串左旋转操作的功能。
		比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"。
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
	// cpp版本改写

}
