package sortingvisualizer.sortingAlgorithms;

import sortingvisualizer.VisualizerPanel;

public class MergeSort implements SortAlgorithm {

    private VisualizerPanel panel;

    public MergeSort(VisualizerPanel panel) {
        this.panel = panel;
    }

    private void merge(int[] array, int left, int mid, int right, int speed) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = array[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            panel.setIndices(left + i, mid + 1 + j);
            panel.sleep(speed);

            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
            panel.repaint();
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    private void mergeSort(int[] array, int left, int right, int speed) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid, speed);
            mergeSort(array, mid + 1, right, speed);

            merge(array, left, mid, right, speed);
        }
    }

    @Override
    public void sort(int[] array, int speed) {
        mergeSort(array, 0, array.length - 1, speed);
        panel.setSorted();
    }
}
