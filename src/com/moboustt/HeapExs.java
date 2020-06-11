package com.moboustt;

public class HeapExs {
    public void heapify(int[] numbers) {
        for (int i = 0; i < numbers.length; i++)
            heapify(numbers, i);
    }

    public int getKthLargestItem(int k, int[] items) {
        if (k < 1 || k > items.length) throw new IllegalStateException();

        var heap = new Heap(10);
        for (int item : items)
            heap.insert(item);
        for (int i = k; i > 1 ; i--)
            heap.remove();
        return heap.remove();
    }

    public boolean isMaxHeap(int[] items){
        var heap = new Heap(items.length);
        for (int item : items)
            heap.insert(item);
        var root = heap.remove();
        return root > heap.remove() && root > heap.remove();
    }

    private void heapify(int[] numbers, int index) {
        var largestValueIndex = index;

        var leftIndex = index * 2 + 1;
        if (leftIndex < numbers.length && numbers[leftIndex] > numbers[largestValueIndex])
            largestValueIndex = leftIndex;

        var rightIndex = index * 2 + 2;
        if (rightIndex < numbers.length && numbers[rightIndex] > numbers[largestValueIndex])
            largestValueIndex = rightIndex;

        if (largestValueIndex == index)
            return;

        swap(index, largestValueIndex, numbers);

        heapify(numbers, largestValueIndex);
    }

    private void swap(int first, int second, int[] numbers) {
        var tmp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = tmp;
    }
}
