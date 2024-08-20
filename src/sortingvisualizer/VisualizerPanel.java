package sortingvisualizer;

import sortingvisualizer.sortingAlgorithms.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class VisualizerPanel extends JPanel {

    private int[] array;
    private int currentIndex = -1;
    private int comparingIndex = -1;

    public VisualizerPanel() {
        setPreferredSize(new Dimension(800, 400));
        randomizeArray(50);
    }

    public void randomizeArray(int size) {
        array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100) + 1;
        }
        repaint();
    }

    public void startSorting(String algorithm, int speed) {
        if (algorithm.equals("Bubble Sort")) {
            new Thread(() -> {
                BubbleSort bubbleSort = new BubbleSort(this);
                bubbleSort.sort(array, speed);
            }).start();
        } else if (algorithm.equals("Quick Sort")) {
            new Thread(() -> {
                QuickSort quickSort = new QuickSort(this);
                quickSort.sort(array, speed);
            }).start();
        } else if (algorithm.equals("Merge Sort")) {
            new Thread(() -> {
                MergeSort mergeSort = new MergeSort(this);
                mergeSort.sort(array, speed);
            }).start();
        } else if (algorithm.equals("Insertion Sort")) {
            new Thread(() -> {
                InsertionSort insertionSort = new InsertionSort(this);
                insertionSort.sort(array, speed);
            }).start();
        } else if (algorithm.equals("Heap Sort")) {
            new Thread(() -> {
                HeapSort heapSort = new HeapSort(this);
                heapSort.sort(array, speed);
            }).start();
        } else if (algorithm.equals("Selection Sort")) {
            new Thread(() -> {
                SelectionSort selectionSort = new SelectionSort(this);
                selectionSort.sort(array, speed);
            }).start();
        }
        // Add other algorithms here
    }

    public void setIndices(int currentIndex, int comparingIndex) {
        this.currentIndex = currentIndex;
        this.comparingIndex = comparingIndex;
        repaint();
    }

    public void setSorted() {
        currentIndex = -1;
        comparingIndex = -1;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth() / array.length;


        int maxBarHeight = getHeight();
        double heightScale = maxBarHeight / 200.0;
        for (int i = 0; i < array.length; i++) {
            int barHeight = (int) (array[i] * heightScale);

            if (currentIndex == -1 && comparingIndex == -1) {
                g.setColor(Color.BLUE);
            } else if (i == currentIndex) {
                g.setColor(Color.RED);
            } else if (i == comparingIndex) {
                g.setColor(Color.YELLOW);
            } else {
                g.setColor(Color.GRAY);
            }

            g.fillRect(i * width, getHeight() - barHeight, width - 2, barHeight);
            g.setColor(Color.BLACK);
            g.drawString("" + array[i], i * width + (width / 4), getHeight() - barHeight - 5);
        }
    }

    public void sleep(int speed) {
        try {
            Thread.sleep(101 - speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
