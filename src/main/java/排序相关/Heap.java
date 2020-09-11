package 排序相关;

public class Heap {
    // 存放数据
    private int[] heap;
    // 数据个数
    private int N = 0;

    public Heap(int maxN) {
        // 第一个位置不放置数据
        this.heap = new int[maxN + 1];
    }
    public boolean isEmpty() {
        return this.N == 0;
    }
    public int size() {
        return this.N;
    }
    private void swap(int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }
    private boolean less(int i, int j) {
        return heap[i] < heap[j];
    }

    // 将较大的数据上浮，位置k处的数据上浮，
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }
    // 将较小的数据下沉，位置k处的数据下沉
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (less(j, k)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }
    // 将新元素放到数组末尾，然后上浮到合适的位置。
    public void insert(int data) {
        heap[++N] = data;
        swim(N);
    }
    // 从数组顶端删除最大的元素，并将数组的最后一个元素放到顶端
    public int delMax() {
        int max = heap[1];
        swap(1, N--);
        sink(1);
        return max;
    }
}
