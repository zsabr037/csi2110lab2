public class LinkedStack<E> implements Stack<E>{
	
	private int size;
	private Node<E> top;
	
	private static class Node<E>{
		Node<E> previous;
		Node<E> next;
		E element;
		
		private Node(Node<E> previous, Node<E> next, E element){
			this.previous = previous;
			this.next = next;
			this.element = element;
		}
	}
	
	public LinkedStack(){
		this.size = 0;
		this.top = null;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public void push(E e){
		Node<E> newNode = new Node<>(top, null, e);
		top = newNode;
		size++;
	}
	
	public E top(){
		if (size == 0){
			return null;
		}
		else{
			return top.element;
		}
	}
	
	public E pop(){
		if (size == 0){
			return null;
		}
		else{
			Node<E> toPop = top;
			top = top.previous;
			size--;
			return toPop.element;
		}
	}
}