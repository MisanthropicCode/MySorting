public class QuickSort {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int left, int right) {
        if (right <= left) return;

        int medianPos = medianOf3(a, left, right);
        exchange(a, left, medianPos);

        int position = partition(a, left, right);
        sort(a, left, position-1);
        sort(a, position+1, right);
    }

    private static int medianOf3(Comparable[] a, int left, int right) {
        int center = (left + right) / 2;
        Comparable[] elements = new Comparable[] {a[left], a[center], a[right]};
        SelectionSort.sort(elements);

        if(a[left] == elements[1]) return left;
        else if(a[right] == elements[1]) return right;
        else return center;
    }

    private static int partition(Comparable[] a, int left, int right) {
        int leftPos = left;
        int rightPos = right + 1;

        Comparable v = a[left];

        while(true) {
            while(less(a[++leftPos], v))
                if (leftPos == right) break;

            while(less(v, a[--rightPos]))
                if (rightPos == left) break;

            if (leftPos >= rightPos) break;

            exchange(a, leftPos, rightPos);
        }

        exchange(a, left, rightPos);

        return rightPos;
    }

    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    private static void exchange(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
