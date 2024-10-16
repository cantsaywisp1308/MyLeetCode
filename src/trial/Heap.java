package trial;

import java.util.ArrayList;
import java.util.List;

class Heap {
    private List<Integer> data = new ArrayList<>();

    // a) Initialize max heap using input vector
    public Heap(List<Integer> input) {
        for (int num : input) {
            insert(num);
        }
    }

    // b) Insert a single value into the heap
    public void insert(int value) {
        data.add(value);
        siftUp(data.size() - 1);
    }

    // c) Delete the maximum value (root of the max heap)
    public int delete() {
        if (data.size() == 0) throw new IllegalStateException("Heap is empty!");

        int removedValue = data.get(0);
        int lastValue = data.remove(data.size() - 1);

        if (data.size() > 0) {
            data.set(0, lastValue);
            siftDown(0);
        }

        return removedValue;
    }

    // d) Find a value (returns true if value exists, otherwise false)
    public boolean find(int value) {
        return data.contains(value);
    }

    // e) Sort all the values in the heap
    public List<Integer> sort() {
        List<Integer> sorted = new ArrayList<>();

        while (data.size() > 0) {
            sorted.add(delete());
        }

        return sorted;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (data.get(index) > data.get(parent)) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void siftDown(int index) {
        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largest = index;

            if (leftChild < data.size() && data.get(leftChild) > data.get(largest)) {
                largest = leftChild;
            }

            if (rightChild < data.size() && data.get(rightChild) > data.get(largest)) {
                largest = rightChild;
            }

            if (largest == index) break;

            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int i, int j) {
        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    public static void main(String[] args) {
        List<Integer> input = List.of(3, 1, 4, 1, 5, 9);
        Heap heap = new Heap(input);

        System.out.println("Inserted values into the heap: " + heap.data);
        System.out.println("Deleted values: " + heap.delete());
        System.out.println("Find 5: " + heap.find(5));
        System.out.println("Sort: " + heap.sort());
    }
}
