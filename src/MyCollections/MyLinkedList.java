package MyCollections;

import java.util.Iterator;

@SuppressWarnings("All")
public class MyLinkedList<E> implements Interface.MyLinkedList<E>, Iterable<E> {

    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public MyLinkedList() {
        last = new Node<E>(first,null,  null);
        first = new Node<E>(null, null, last);
    }
    @Override
    public void addLast(E e) {
        Node<E> p = last;
        p.setItem(e);
        last = new Node<E>(p, null, null);
        p.setNext(last);
        size++;
    }
    @Override
    public void addFirst(E e) {
        Node<E> next = first;
        next.setItem(e);
        first = new Node<>(null, null, next);
        next.setPrev(first);
        size++;
    }
    @Override
    public int size() {
        return size;
    }
    private boolean replaceElement(Node<E> delete) {
        Node<E> prevElement = delete.prev;
        Node<E> nextElement = delete.next;
        if (size == 0) {
            first = null;
            last = null;
        } else {
            if (prevElement == null) {
                nextElement.prev = null;
                first = prevElement;
            } else if (nextElement == null) {
                prevElement = null;
                last = prevElement;
            } else {
                prevElement.next = nextElement;
                nextElement.prev = prevElement;
            }
        }
        size--;
        return true;
    }











//    @Override
//    public E remove(int i) {
//        Node<E> delete = asd2(i);
//        if (delete != null) {
//            replaceElement(delete);
//            return delete.item;
//        }
//        return null;
//    }

//hz
public void add(Object e) {
    Node<E> newNode = new Node<E>( last,(E) e, null);
    if (size == 0) {
        newNode.setItem((E) e);
        newNode.setPrev(first);
    } else {
        Node<E> saveLast = last;
        last = newNode;
        saveLast.next = newNode;
    }
    size++;
}
    private Node<E> asd(Object o) {
        Node<E> f;
        for (f = first; f!=null; f = f.next) {
            if (f.item.equals(o)) return f;
        }
        return null;
    }
    private Node<E> asd2(int index) {
        int i = 0;
        for (Node<E> n = first; n!=null; n = n.next) {
            if (i == index) {
                return n;
            }
            i++;
        }
        return null;
    }


    //rabotaet vrode tolko s obj
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean removeeeee2(int i) {
        if (i == 0) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

//    public E removeInd(int index) {
//        return unlink(node(index));
//    }

    //rabotaet
    public E unlink(Node<E> x) {
        // assert x != null;
        E element = x.item;
        Node<E> next = x.next;
        Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

//    //rabotaet
//    Node<E> node(int index) {
//    if (index < (size >> 1)) {
//        Node<E> x = first;
//        for (int i = 0; i < index; i++)
//            x = x.next;
//        return x;
//    } else {
//        Node<E> x = last;
//        for (int i = size - 1; i > index; i--)
//            x = x.prev;
//        return x;
//    }
//}
//
//    public E gett(int index) {
//        return node(index).item;
//    }


    @Override //rabotaet
    public E get(int counter) {
        Node<E> target = first.getNext();
        for (int i = 0; i <= counter-1; i++) {
            target = getNextNode(target);
        }
        return target.getItem();
    }

    private Node<E> getNextNode(Node<E> current) {
        return current.getNext();
    }



//    private Node<E> findNode(int index) {
//        int i = 0;
//        if (isIndex(index)) {
//            for (Node<E> n = first; n != null; n = n.next) {
//                if (i == index) return n;
//            }
//            i++;
//        }
//        return null;
//    }
//
//    private boolean isIndex(int index) {
//        if (index >= size || index == 0) {
//            throw new ArrayIndexOutOfBoundsException();
//        }
//        return true;
//    }


    @Override
    public Iterator<E> iterator() {
            return new Iterator<E>() {
                int counter = 0;
                @Override
                public boolean hasNext() {
                    return counter <= size-1;
                }

                @Override
                public E next() {
                    return get(counter++);
                }
            };
        }


    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        private Node( Node<E> prev,E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
}
