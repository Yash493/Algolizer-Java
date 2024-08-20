package sortingvisualizer.sortingAlgorithms;

import sortingvisualizer.VisualizerPanel;

public class SelectionSort implements SortAlgorithm {

    private VisualizerPanel panel;

    public SelectionSort(VisualizerPanel panel) {
        this.panel = panel;
    }

    @Override
    public void sort(int[] array, int speed) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                panel.setIndices(minIndex, j);
                sleep(speed);

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }

        panel.setIndices(-1, -1);  // Reset after sorting
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
