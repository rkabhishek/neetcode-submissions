public class DynamicArray {

    private int[] ar;
    private int size;
    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
        ar = new int[capacity];
    }

    public int get(int i) {
        checkIndex(i);
        return ar[i];
    }

    public void set(int i, int n) {
        checkIndex(i);
        ar[i] = n;
    }

    public void pushback(int n) {
        if (size == getCapacity()) {
            resize();
        }
        ar[size++] = n;
    }

    public int popback() {
       if (size == 0) {
           throw new NoSuchElementException("Cannot pop from empty array");
       }
       return ar[--size];
    }

    private void resize() {
        int capacity = getCapacity();
        int[] temp = new int[2 * capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = ar[i];
        }
        ar = temp;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return ar.length;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(ar[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
