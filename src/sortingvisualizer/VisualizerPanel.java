package sortingvisualizer;

import sortingvisualizer.sortingAlgorithms.BubbleSort;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class VisualizerPanel extends JPanel {

    private int[] array;
    private int currentIndex = -1;
    private int comparingIndex = -1;
    private boolean sorted = false;  // New flag to check if the array is sorted

    public VisualizerPanel() {
        setPreferredSize(new Dimension(800, 400));
        randomizeArray(50); // Default array size
    }

    public void randomizeArray(int size) {
        array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(300) + 1;
        }
        sorted = false;  // Reset the sorted flag when array is randomized
        repaint();
    }

    public void startSorting(String algorithm, int speed) {
        int reversedSpeed = 100 - speed; // Reverse the speed
        if (algorithm.equals("Bubble Sort")) {
            new Thread(() -> {
                BubbleSort bubbleSort = new BubbleSort(this);
                bubbleSort.sort(array, reversedSpeed);
                sorted = true;  // Set the sorted flag to true after sorting
                repaint();  // Repaint to show green bars
            }).start();
        }
    }

    public void setIndices(int currentIndex, int comparingIndex) {
        this.currentIndex = currentIndex;
        this.comparingIndex = comparingIndex;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth() / array.length;
        int spacing = 2; // Space between bars

        for (int i = 0; i < array.length; i++) {
            if (sorted) {
                g.setColor(Color.GREEN);  // Set color to green if sorted
            } else if (i == currentIndex) {
                g.setColor(Color.RED);
            } else if (i == comparingIndex) {
                g.setColor(Color.YELLOW);
            } else {
                g.setColor(Color.GRAY);
            }

            int x = i * width + spacing / 2;
            int barHeight = array[i];
            g.fillRect(x, getHeight() - barHeight, width - spacing, barHeight);

            // Draw the numbers on top of the bars
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(array[i]), x + (width - spacing) / 4, getHeight() - barHeight - 5);
        }
    }
}
