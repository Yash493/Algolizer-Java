package sortingvisualizer;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    private JSlider speedSlider;
    private JSlider sizeSlider;
    private JComboBox<String> algorithmComboBox;
    private JButton randomizeButton;
    private JButton sortButton;
    private VisualizerPanel visualizerPanel;

    public ControlPanel(VisualizerPanel visualizerPanel) {
        this.visualizerPanel = visualizerPanel;

        setLayout(new FlowLayout());

        // Speed slider
        speedSlider = new JSlider(1, 100, 50);
        speedSlider.setMajorTickSpacing(10);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        add(new JLabel("Speed"));
        add(speedSlider);

        // Size slider
        sizeSlider = new JSlider(10, 100, 50);
        sizeSlider.setMajorTickSpacing(10);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setPaintLabels(true);
        add(new JLabel("Length"));
        add(sizeSlider);

        // Algorithm dropdown
        algorithmComboBox = new JComboBox<>(new String[]{"Bubble Sort", "Quick Sort","Selection Sort","Merge Sort","Insertion Sort"});
        add(algorithmComboBox);

        // Randomize button
        randomizeButton = new JButton("Randomize");
        randomizeButton.addActionListener(e -> visualizerPanel.randomizeArray(sizeSlider.getValue()));
        add(randomizeButton);

        // Sort button
        sortButton = new JButton("Sort");
        sortButton.addActionListener(e -> {
            String selectedAlgorithm = (String) algorithmComboBox.getSelectedItem();
            visualizerPanel.startSorting(selectedAlgorithm, speedSlider.getValue());
        });
        add(sortButton);
    }
}
