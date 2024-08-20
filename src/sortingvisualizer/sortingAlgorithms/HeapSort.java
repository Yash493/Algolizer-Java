package sortingvisualizer.sortingAlgorithms;

import sortingvisualizer.VisualizerPanel;

public class HeapSort implements SortAlgorithm {

    private VisualizerPanel panel;

    public HeapSort(VisualizerPanel panel) {
        this.panel = panel;
    }

    private void heapify(int[] array, int n, int i, int speed) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            panel.setIndices(i, largest);
            panel.sleep(speed);

            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            panel.repaint();

            heapify(array, n, largest, speed);
        }
    }

    @Override
    public void sort(int[] array, int speed) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, speed);
        }

        for (int i = n - 1; i > 0; i--) {
            panel.setIndices(0, i);
            panel.sleep(speed);

            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            panel.repaint();

            heapify(array, i, 0, speed);
        }

        panel.setSorted();
    }
}
