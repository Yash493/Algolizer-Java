package sortingvisualizer.sortingAlgorithms;

import sortingvisualizer.VisualizerPanel;

public class QuickSort implements SortAlgorithm {

    private VisualizerPanel panel;

    public QuickSort(VisualizerPanel panel) {
        this.panel = panel;
    }

    private int partition(int[] array, int low, int high, int speed) {
        int pivot = array[low];
        int cnt = 0;

        for (int i = low + 1; i <= high; i++) {
            if (array[i] <= pivot) {
                cnt++;
            }
        }

        int pivotIndex = cnt + low;

        // Swap pivot element with pivotIndex
        swap(array, low, pivotIndex, speed);

        int i = low;
        int j = high;

        while (i < pivotIndex && j > pivotIndex) {
            while (i < pivotIndex && array[i] <= pivot) {
                i++;
            }

            while (j > pivotIndex && array[j] > pivot) {
                j--;
            }

            if (i < pivotIndex && j > pivotIndex) {
                swap(array, i, j, speed);
                i++;
                j--;
            }
        }
        return pivotIndex;
    }

    private void quickSort(int[] array, int low, int high, int speed) {
        if (low < high) {
            int p = partition(array, low, high, speed);
            quickSort(array, low, p - 1, speed);
            quickSort(array, p + 1, high, speed);
        }
    }

    private void swap(int[] array, int i, int j, int speed) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        // Update indices in the panel for visualization
        panel.setIndices(i, j);
        sleep(speed);
    }

    public void sort(int[] array, int speed) {
        quickSort(array, 0, array.length - 1, speed);
        panel.setSorted();  // Turn all bars green after sorting is complete
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
