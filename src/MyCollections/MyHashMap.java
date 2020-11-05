package MyCollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyHashMap<K,V> implements Interface.MyHashMap<K, V> {

    private int Buckets = 16;
    private List<Bucket<K, V>> list;
    private int size = 0;

    public MyHashMap() {
        list = new ArrayList<Bucket<K, V>>();
        Bucket<K,V> bucket;
        for(int i=0; i < Buckets; i++)
        {
            bucket = new BucketImpl();
            list.add(bucket);
        }
    }

    public MyHashMap(int Buckets)
    {
        list = new ArrayList<Bucket<K, V>>();
        Bucket<K,V> bucket;
        for(int i=0; i < Buckets; i++)
        {
            bucket = new BucketImpl();
            list.add(bucket);
        }
        this.Buckets = Buckets;
    }

    @Override
    public V get(K key) {
        int i = translate(key.hashCode(),Buckets);
        Bucket<K,V> bucket = list.get(i);
        for (Entry<K, V> entry : bucket.getEntries())
        {
            if(entry.getKey().equals(key))
                return entry.getValue();
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int i=translate(key.hashCode(),Buckets);
        Bucket<K,V> bucket=list.get(i);
        for(Entry<K, V> entry:bucket.getEntries()) {
            if(entry.getKey().equals(key))
            {
                V val=((EntryImpl)entry).v;
                ((BucketImpl)bucket).list2.remove(entry);
                ((EntryImpl)entry).v=value;
                ((BucketImpl)bucket).list2.add(entry);
                return val;
            }
        }
        EntryImpl entry = new EntryImpl();
        entry.k=key;
        entry.v=value;
        ((BucketImpl)bucket).list2.add(entry);
        size++;
        return null;
    }

    @Override
    public V remove(K key) {
        int i=translate(key.hashCode(),Buckets);
        Bucket<K,V> bucket=list.get(i);
        for(Entry<K, V> entry:bucket.getEntries())
        {
            if(entry.getKey()==key)
            {
                V val=((EntryImpl)entry).v;
                ((BucketImpl)bucket).list2.remove(entry);
                size--;
                return val;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<? extends Bucket<K, V>> getBuckets() {
        return list;
    }


    private int translate(int hashCode, int size) {
        return hashCode % size;
    }

    public class EntryImpl implements Entry<K, V> {
        K k;
        V v;
        @Override
        public K getKey() {
            return k;
        }
        @Override
        public V getValue() {
            return v;
        }
    }

    public class BucketImpl implements Bucket<K, V> {

        private List<Entry<K, V>> list2 = new ArrayList<Entry<K, V>>();

        @Override
        public List<? extends Entry<K, V>> getEntries() {

            return list2;
        }
    }

    @Override
    public String toString() {
        return "MyHashMapImpl{" +
                "Buckets=" + Buckets +
                ", size=" + size +
                '}';
    }
}
