package sortingvisualizer.sortingAlgorithms;

import sortingvisualizer.VisualizerPanel;

public class BubbleSort implements SortAlgorithm {

    private VisualizerPanel panel;

    public BubbleSort(VisualizerPanel panel) {
        this.panel = panel;
    }

    @Override
    public void sort(int[] array, int speed) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                panel.setIndices(j, j + 1);
                sleep(speed);

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
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
