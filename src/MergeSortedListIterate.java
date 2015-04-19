import java.util.*;

/**
 * Created by Zhuo on 4/19/2015.
 */
public class MergeSortedListIterate {
    public static Iterable<Integer> MergeKSortedIterators(List<Iterator<Integer>> Iters) {
        Queue<newIter> minHeap = new PriorityQueue<newIter>();
        List<Integer> result = new ArrayList<Integer>();
        for (Iterator<Integer> iter : Iters) {
            if (iter.hasNext()) {
                minHeap.add(new newIter(iter.next(), iter));
            }
        }

        while (!minHeap.isEmpty()) {
            newIter newiter = minHeap.poll();
            result.add(newiter.getValue());
            if (newiter.hasNext()) {
                minHeap.add(newiter);
            }
        }
        return result;
    }

    private static class newIter implements Comparable<newIter> {
        private Integer value;
        private Iterator<Integer> iter;

        public newIter(Integer val, Iterator<Integer> it) {
            this.value = val;
            this.iter = it;
        }

        public Integer getValue() {
            return this.value;
        }

        public boolean hasNext() {
            if (iter.hasNext()) {
                value = iter.next();
                return true;
            }
            return false;
        }

        public int compareTo(newIter a) {
            return this.value - a.value;
        }
    }

    public static void main(String[] args){
        final MergeSortedListIterate mergeSortedListIterate=new MergeSortedListIterate();
        List<Iterator<Integer>> list = new ArrayList<Iterator<Integer>>(
        );

        mergeSortedListIterate.MergeKSortedIterators(list);
    }
}