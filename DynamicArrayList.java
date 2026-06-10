public class DynamicArrayList<E> implements SimpleList<E>{
	
	private int size;
	private E[] array;
	private static final DEFAULT_CAPACITY = 16;
	
	public DynamicArrayList(){
		this.size = 0;
		this.array = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public DynamicArrayList(int capacity){
		this.size = 0;
		this.array = (E[]) new Object[capacity];
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public E get(int index){
		if (index < 0 || index >= size){
			throw new IndexOutBoundsException("Index out of bounds");
		}
		return array[index];
	}
	
	public E set(int index, E element){
		if (index < 0 || index >= size){
			throw new IndexOutBoundsException("Index out of bounds");
		}
		// method stores and returns the value previously contained at that index.
		E temp = array[index];
		array[index] = element;
		return temp;
	}
	
	public void add(int index, E element){
		if (index < 0 || index >= size){
			throw new IndexOutBoundsException("Index out of bounds");
		}		
		size++;
		/* If array reaches max capacity, it doubles in size. A new array is created */
		if (size == array.length){
			E[] newArray = (E[]) new Object[array.length * 2];
			for (int i = 0; i < index; i++){
				newArray[i] = array[i];
			}
			newArray[index] = element;
			for (int i = index+1; i < size; i++){
				newArray[i] = array[i-1];
			}
		/* If the array does not need to be resized, a for loop moves backwards from the first empty
		 * position to the first element after the index, moving array elements one position to the
		 * right. Then, the new element value is inserted on top of the (now cloned) value at the 
		 * index position. */
		} else {
			for (int i = size; i > index; i--){
				array[i] = array[i-1];
			}
			array[index] = element;
		}
	}
	
	public E remove(int index){
		if (index < 0 || index >= size){
			throw new IndexOutBoundsException("Index out of bounds");
		}
		E temp = array[index];
		size--;
		/* If array falls to below 1/4 capacity, it's resized down by half.
		 * One for loop copies over all entries before the chosen index to the new array,
		 * and another all the entries after it, shifted one to the left in the new array. */
		if (size <= (array.length / 4)){
			E[] newArray = (E[]) new Object[array.length / 2];
			for (int i = 0; i < index; i++){
				newArray[i] = array[i];
			}
			for (int i = index+1; i < size; i++){
				newArray[i-1] = array[i];
			}
			array = newArray;
		/* if no need to resize array, shift all elements past index one position to the left.
		 * last formerly occupied position is set to null. */
		} else {
			for (int i = index; i < size-1; i++){
				array[i] = array[i+1];
			}
			array[size-1] = null;
		}
		return temp;
	}
}