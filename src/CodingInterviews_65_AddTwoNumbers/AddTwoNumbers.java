package CodingInterviews_65_AddTwoNumbers;

/*
	������65�����üӼ��˳����ӷ�
		дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ�ã�������������
		����������š�
 */
public class AddTwoNumbers {
	public int Add(int num1, int num2) {
		// ����λ���
		int sum = num1 ^ num2;// ��򣺲�ͬΪ0
		// ��λ����
		int carry = (num1 & num2) << 1;// �����Ҳ���0
		while (carry != 0) {
			num1 = sum;
			num2 = carry;
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
		}
		return sum;
	}
	// cpp�汾��д
	// ͬ��
}
