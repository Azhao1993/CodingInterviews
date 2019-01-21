package CodingInterviews_05_ReplaceSpaces;

/*
	面试题5: 替换空格
	请实现一个函数，将一个字符串中的每个空格替换成“%20”。
	例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
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
	// cpp版思路
	// 将字符串数组扩充，从后往前复制；
}
