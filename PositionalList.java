import java.util.Iterator;

public class PositionalList<E> implements Iterable<E>{
	/* We haven't even learned this yet! */
	private static class Node<T>{
		T element;
		Node<T> prev;
		Node<T> next;
		
		public Node(T element, Node<T> prev, Node<T> next){
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
	}
	// Implementing the iterator
	private class PositionalIterator implements Iterator<E>{
		
		private Node<E> current;
		
		public PositionalIterator(){
			current = head.next;
		}
		
		public boolean hasNext(){
			if (current == tail){
				return false;
			}
			else{
				return true;
			}
		}
		
		public E next(){
			if (hasNext() == false){
				throw new IndexOutOfBoundsException("No more elements!");
			}
			E temp = current.element;
			current = current.next;
			return temp;
		}
	}
	
	int size;
	Node<E> head;
	Node<E> tail;
	
	public PositionalList(){
		this.head = new Node(null, null, null);
		this.tail = new Node(null, head, null);
		head.next = tail;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return (size == 0);
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
		return tail.prev. element;
	}
	/* Returns the element of the node before the position node passed as an argument */
	public E before(Node<E> p){
		if (p == null){
			throw new IllegalArgumentException("p cannot be null");
		} else if (p.prev == null || p.next == null){
			throw new IllegalArgumentException("p must be part of the list");
		}
		return p.prev.element;
	}
	
	public E after(Node<E> p){
		if (p == null){
			throw new IllegalArgumentException("p cannot be null");
		} else if (p.prev == null || p.next == null){
			throw new IllegalArgumentException("p must be part of the list");
		}
		return p.next.element;
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
	
	public void addBefore(Node<E> p, E e){
		Node<E> newNode = new Node(e, p.prev, p);
		p.prev.next = newNode;
		p.prev = newNode;
		size++;
	}
	
	public void addAfter(Node<E> p, E e){
		Node<E> newNode = new Node(e, p, p.next);
		p.next.prev = newNode;
		p.next = newNode;
		size++;
	}
	
	public E set(Node<E> p, E e){
		E temp = p.element;
		p.element = e;
		return temp;
	}
	
	public E remove(Node<E> p){
		E temp = p.element;
		p.next.prev = p.prev;
		p.prev.next = p.next;
		// assisting garbage collection!
		p.element = null;
		p.next = null;
		p.prev = null;
		return temp;
	}
	// implementing iterable
	public Iterator<E> iterator(){
		return new PositionalIterator();
	}
}