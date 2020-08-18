package 数据结构.q146_LRU缓存机制;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author fmk
 * @date 2020/8/12 17:59
 */
public class LRUCache2<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_ENTRIES = 3;

    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }

    LRUCache2() {
        super(MAX_ENTRIES, 0.75f, true);
    }
    public static void main(String[] args) {
        // 当一个节点被访问时，如果 accessOrder 为 true，则会将该节点移到链表尾部。
        // 保证链表尾部是最近访问的节点，那么链表首部就是最近最久未使用的节点
        LRUCache2<Integer, String> cache = new LRUCache2<>();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);
        cache.get(2);
        cache.put(4, "d");
        System.out.println(cache.keySet());
    }
}
