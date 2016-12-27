package aCollections.StackLinkedList;

import java.util.LinkedList;

//realization of Stack with LinkedList
public class Stack<T> {
	//create Stack
	private LinkedList<T> storage = new LinkedList<>();
	
	//add element to Stack
	public void push(T v){
		storage.addFirst(v);
	}
	
	//get first element of the Stack
	public T peek(){
		return storage.getFirst();
	}
	
	//get first element of the Stack and remove it from Stack
	public T pop(){
		return storage.removeFirst();
	}
	
	//check the Stack on emptiness 
	public boolean empty(){
		return storage.isEmpty();
	}

	@Override
	public String toString() {
		return "Stack [storage=" + storage + "]";
	}
	
	
}
