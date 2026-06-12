public interface SimpleList<E>{
	int size();
	boolean isEmpty();
	E get(int index);
	E set(int index, E element);
	void add(int index, E element);
	E remove (int index);
}