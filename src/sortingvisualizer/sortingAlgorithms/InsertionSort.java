package sortingvisualizer.sortingAlgorithms;

import sortingvisualizer.VisualizerPanel;

public class InsertionSort implements SortAlgorithm {

    private VisualizerPanel panel;

    public InsertionSort(VisualizerPanel panel) {
        this.panel = panel;
    }

    @Override
    public void sort(int[] array, int speed) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                panel.setIndices(j, j + 1);
                panel.sleep(speed);

                array[j + 1] = array[j];
                j = j - 1;

                panel.repaint();
            }
            array[j + 1] = key;
            panel.repaint();
        }
        panel.setSorted();
    }
}
