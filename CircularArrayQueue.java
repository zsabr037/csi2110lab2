public class CircularArrayQueue<E> implements Queue<E>{

	private int size;
	/* front is first occupied index */
	private int front;
	/* rear is first empty index, not last occupied */
	private int rear;
	private E[] circArray;
	private static final int DEFAULT_CAPACITY = 20;
	
	public CircularArrayQueue(){
		this.size = 0;
		this.front = 0;
		this.rear = 0;
		this.circArray = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public CircularArrayQueue(int capacity){
		this.size = 0;
		this.front = 0;
		this.rear = 0;
		this.circArray = (E[]) new Object[capacity];
	}
	
	/* returns the first occupied index, just to help with testing. returns -1 if array is empty */
	public int front(){
		if (isEmpty()){
			return -1;
		}
		return front;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public E first(){
		/* Since the array contains objects, one would assume it would return null when accessing
		 * an empty first array cell anyway. But this is explicit! Clarity! */
		if (isEmpty()){
			return null;
		}
		return circArray[front];
	}
	
	public void enqueue(E e){
		/* resizing "uncircularizes" the array, moving the front of the new queue back to index 0. */
		if (size == circArray.length){
			E[] newArray = (E[]) new Object[circArray.length * 2];
			for (int i = 0; i < size; i++){
				// mod incase old array wraps around
				newArray[i] = circArray[(front + i) % circArray.length];
			}
			circArray = newArray;
			front = 0;
			rear = (size - 1);
		}
		circArray[rear] = e;
		rear = (rear + 1) % circArray.length;
		size++;
	}
	
	public E dequeue(){
		/* null check! */
		if (isEmpty()){
			return null;
		}
		/* removal occurs before potential resizing */
		E temp = circArray[front];
		circArray[front] = null;
		front = (front + 1) % circArray.length;
		size--;
		/* again, resizing "uncircularizes" the array as it's copied over */
		if (size < (circArray.length / 4)){
			E[] newArray = (E[]) new Object[circArray.length / 2];
			for (int i = 0; i < size; i++){
				newArray[i] = circArray[(front + i) % circArray.length];
			}
			circArray = newArray;
			front = 0;
			rear = size;
		}
		return temp;
	}
}