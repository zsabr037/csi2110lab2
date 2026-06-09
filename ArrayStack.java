public class ArrayStack<E> implements Stack<E>{
	
	private int size;
	private E[] eArray;
	private int topIndex;
	private static final int DEFAULT_CAPACITY = 20;
	
	/* constructor using default capacity */
	public ArrayStack(){
		this.topIndex = -1;
		this.size = 0;
		this.eArray = (E[]) new Object[DEFAULT_CAPACITY];
	}
	/* constructor using using custom capacity */
	public ArrayStack(int capacity){
		this.topIndex = -1;
		this.size = 0;
		this.eArray = (E[]) new Object[capacity];
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public E top(){
		if (size == 0){
			return null;
		}
		return eArray[topIndex];
	}
	
	public E pop(){
		if (size == 0){
			return null;
		}
		E toPop = eArray[topIndex];
		eArray[topIndex] = null;
		topIndex--;
		size--;
		if (size < (eArray.length / 4) && size > DEFAULT_CAPACITY){
			E[] newArray = (E[]) new Object[eArray.length / 2];
			for (int i = 0; i < size; i++){
				newArray[i] = eArray[i];
			}
			eArray = newArray;
		}	
		return toPop;
	}
	
	public void push(E e){
		size++;
		topIndex++;
		if (size == eArray.length){
			E[] newArray = (E[]) new Object[eArray.length * 2];
			for (int i = 0; i < size; i++){
				newArray[i] = eArray[i];
			}
			eArray = newArray;
		}
		eArray[topIndex] = e;
	}
}
			
	
	