package Interface;

import java.util.List;

public interface MyHashMap<K,V> {

     V get(K key);

     V put(K key, V value);

     V remove(K key);

     int size();

     List<? extends Bucket<K, V>> getBuckets();

      interface Entry<K, V> {
          K getKey();
          V getValue();
    }

    interface Bucket<K, V> {
    List<? extends Entry<K, V>> getEntries();
    }
}
