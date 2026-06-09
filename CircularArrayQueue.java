public class CircularArrayQueue<E>{

	private int size;
	private int front;
	private int rear;
	private E[] circArray;
	private static final DEFAULT_CAPACITY = 16;
	
	public class CircularArrayQueue(){
		this.size = 0;
		this.front = 0;
		this.rear = 0;
		this.circArray = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public class CircularArrayQueue(int capacity){
		this.size = 0;
		this.front = 0;
		this.rear = 0;
		this.circArray = (E[]) new Object[capacity];
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public E first(){
		return circArray[front];
	}
	
	public void enqueue(E e){
		if (size == circArray.length){
			
		}
		circArray[rear] = e;
		rear = (rear+1) % circArray.length;
		size++;
	
	}
}