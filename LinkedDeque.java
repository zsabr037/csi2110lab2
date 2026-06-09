public class LinkedDeque<E> implements Deque<E>{
	
	private class Node<E>{
		E element;
		Node<E> prev;
		Node<E> next;
		
		private Node(E element, Node<E> prev, Node<E> next){
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
	}
	private int size;
	private Node<E> head;
	private Node<E> tail;
	
	public LinkedDeque(){
		size = 0;
		head = new Node<E>(null, null, null);
		tail = new Node<E>(null, head, null);
		head.next = tail;
	}
	
	public void addFirst(E e){
		Node<E> newNode = new Node(e, head, head.next);
		head.next.prev = newNode;
		head.next = newNode;
		size++;
	}
	
	public void addLast(E e){
		Node<E> newNode = new Node(e, tail.prev, tail);
		tail.prev.next = newNode;
		tail.prev = newNode;
		size++;
	}
	
	public E removeFirst(){
		if (size == 0){
			return null;
		}
		E temp = head.next.element;
		// rearranging node connections around removed node
		head.next = head.next.next;
		head.next.prev = head;
		size--;
		return temp;
	}
	
	public E removeLast(){
		if (size == 0){
			return null;
		}
		E temp = tail.prev.element;
		// ditto
		tail.prev = tail.prev.prev;
		tail.prev.next = tail;
		size--;
		return temp;
	}
	
	public E first(){
		if (size == 0){
			return null;
		}
		return head.next.element;
	}
	
	public E last(){
		if (size == 0){
			return null;
		}
		return tail.prev.element;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}

}