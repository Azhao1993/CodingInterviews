package CodingInterviews_30_MinInStack;

import java.util.Stack;

/*
面试题30：包含min函数的栈
	题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
		在该栈中，调用min、push及pop的时间复杂度都是O(1)。

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
