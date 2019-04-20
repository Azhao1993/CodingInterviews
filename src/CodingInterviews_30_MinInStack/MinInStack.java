package CodingInterviews_30_MinInStack;

import java.util.Stack;

/*
������30������min������ջ
	��Ŀ������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�min������
		�ڸ�ջ�У�����min��push��pop��ʱ�临�Ӷȶ���O(1)��

 */
public class MinInStack {
	Stack<Integer> data = new Stack<>();
	Stack<Integer> min = new Stack<>();

    
    public void push(int node) {
        data.push(node);
        if(min.isEmpty()) {
        	min.push(node);
        }else {
        	min.push(Math.min(min.peek(), node));
        }
    }
    
    public void pop() {
        data.pop();
        min.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int min() {
        return min.peek();
    }
}
