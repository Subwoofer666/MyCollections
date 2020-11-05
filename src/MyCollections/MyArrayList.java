package MyCollections;

@SuppressWarnings("all")
public class MyArrayList<T> implements Interface.MyArrayList<T> {
    private final int SIZE = 16;
    private Object[] array = new Object[SIZE];
    private int count = 0;

    public void add(T obj) {
        if (count == array.length - 1)
            resize(array.length * 2);
        array[count++] = obj;
    }

    public int size() {
        return count;
    }

    public Object get(int index) {
        rangeCheck(index);
        return (T) array[index];
    }

    private void rangeCheck(int index) {
        if (index > array.length)
            throw new IndexOutOfBoundsException();
    }

    public void remove(int index) {
        for (int i = index; i < count; i++)
            array[i] = array[i + 1];
        array[count] = null;
        count--;
        if (array.length < SIZE && count < array.length / 4)
            resize(array.length / 2);
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, count);
        array = newArray;
    }

    public void printList() { //распечатывает массив в строку
        for (int i = 0; i < count; i++) {
                System.out.print(array[i] + " ");
        }
    }

    public void printlnList() { //распечатывает массив в столбик
        for (int i = 0; i < count; i++) {
                System.out.println(array[i]);
        }
    }
}
