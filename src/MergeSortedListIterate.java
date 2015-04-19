import java.util.*;

/**
 * Created by Zhuo on 4/19/2015.
 */
public class MergeSortedListIterate {
    public static Iterable<Integer> MergeKSortedIterators(List<Iterator<Integer>> Iters) {
        Queue<newIterator> minHeap = new PriorityQueue<newIterator>();
        List<Integer> result = new ArrayList<Integer>();
        for (Iterator<Integer> iterator : Iters) {
            if (iterator.hasNext()) {
                minHeap.add(new newIterator(iterator.next(), iterator));
            }
        }

        while (!minHeap.isEmpty()) {
            newIterator newiterator = minHeap.poll();
            result.add(newiterator.getValue());
            if (newiterator.hasNext()) {
                minHeap.add(newiterator);
            }
        }
        return result;
    }

    private static class newIterator implements Comparable<newIterator> {
        private Integer value;
        private Iterator<Integer> iterator;

        public newIterator(Integer val, Iterator<Integer> it) {
            this.value = val;
            this.iterator = it;
        }

        public Integer getValue() {
            return this.value;
        }

        public boolean hasNext() {
            if (iterator.hasNext()) {
                value = iterator.next();
                return true;
            }
            return false;
        }

        public int compareTo(newIterator newiterator) {
            return this.value - newiterator.value;
        }
    }

    public static void main(String[] args){
        List<Iterator<Integer>> list = new ArrayList<Iterator<Integer>>();

        new MergeSortedListIterate().MergeKSortedIterators(list);
    }
}