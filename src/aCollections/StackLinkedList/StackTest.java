package aCollections.StackLinkedList;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		aCollections.StackLinkedList.Stack<String> stack = new aCollections.StackLinkedList.Stack<>();
		
		for (String s : "My dog has fleas".split(" ")){
			stack.push(s);
			System.out.println(stack.toString());
		}
		System.out.println();
		while(!stack.empty()){
			System.out.println(stack.pop() + " ");
		}
		System.out.println();
		Stack<String> stack2 = new Stack<>();
		
		for (String s : "My dog has fleas".split(" ")){
			stack2.push(s);
		}
		while (!stack2.empty()) {
			System.out.println(stack2.pop() + " ");
		}

	}

}
