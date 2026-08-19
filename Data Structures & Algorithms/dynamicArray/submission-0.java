class DynamicArray {

    private int[] data;
    private int size;
    private int cap;

    public DynamicArray(int capacity) {
        size = 0;
        cap = capacity;
        data = new int[capacity];
    }

    public int get(int i) {
        return data[i];
    }

    public void set(int i, int n) {
        data[i] = n;
    }

    public void pushback(int n) {
        if (size == getCapacity()) {
            resize();
        }
        data[size] = n;
        size++;
    }

    public int popback() {
        size--;
        return data[size];
    }

    private void resize() {
        cap  *= 2;
        int[] temp = data;
        data = new int[cap];
        for (int i = 0; i < size; i++) {
            data[i] = temp[i];
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return cap;
    }
}
