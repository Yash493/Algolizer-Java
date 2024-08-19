package sortingvisualizer;

import javax.swing.*;
import java.awt.*;

public class SortingVisualizer extends JFrame {

    private VisualizerPanel visualizerPanel;
    private ControlPanel controlPanel;
    private LegendPanel legendPanel;

    public SortingVisualizer() {
        setTitle("Algoliser");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize panels
        visualizerPanel = new VisualizerPanel();
        controlPanel = new ControlPanel(visualizerPanel);
        legendPanel = new LegendPanel();

        // Add panels to the frame
        add(controlPanel, BorderLayout.NORTH);
        add(visualizerPanel, BorderLayout.CENTER);
        add(legendPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SortingVisualizer frame = new SortingVisualizer();
            frame.setVisible(true);
        });
    }
}
