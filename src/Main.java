import MyCollections.MyArrayList;
import MyCollections.MyHashMap;
import MyCollections.MyLinkedList;

public class Main {
    public static void main(String[] args) {

        System.out.println("-----ArrayList-----");
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("String 1");
        myArrayList.add("String 2");
        myArrayList.add("String 3");
        myArrayList.remove(1);
        myArrayList.printList();
        System.out.println();

        System.out.println("-----LinkedList-----");
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.addLast("String 1");
        myLinkedList.addLast("String 2");
        myLinkedList.addLast("String 3");
        myLinkedList.remove("String 2");
        myLinkedList.forEach(System.out::println);

        System.out.println("-----Hashmap-----");
        MyHashMap<String, String> myHashMap = new MyHashMap<String,String>();
        myHashMap.put("aaa", "AAA");
        myHashMap.put("bbb", "BBB");
        myHashMap.put("ccc", "CCC");
        System.out.println(myHashMap.remove("bbb"));
        System.out.println(myHashMap);


    }
}