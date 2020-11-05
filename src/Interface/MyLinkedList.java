package Interface;

public interface MyLinkedList<E> {
     void addLast(E e);
     void addFirst(E e);
     int size();
     boolean remove(E e);
     E get(int size);

}
