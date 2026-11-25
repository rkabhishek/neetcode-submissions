// NeetCode's submission environment handles this import automatically.
// import java.util.NoSuchElementException;
public class DynamicArray {
    int[] ar;
    int size;
    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Can't create an array with capacity " + capacity);
        }
        ar = new int[capacity];
    }

    public int get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for array with " + size + " elements");
        }
        return ar[i];
    }

    public void set(int i, int n) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for array with " + size + " elements");
        }
        ar[i] = n;
    }

    public void pushback(int n) {
        if (size == ar.length) {
            resize();
        }
        ar[size++] = n;
    }

    public int popback() {
        if (size == 0) {
            throw new NoSuchElementException("Array is empty");
        }
        int val = ar[size - 1];
        size--;
        return val;
    }

    public void resize() {
        int capacity = 2 * ar.length;
        int[] newAr = new int[capacity];
        System.arraycopy(ar, 0, newAr, 0, ar.length);
        ar = newAr;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return ar.length;
    }
}
