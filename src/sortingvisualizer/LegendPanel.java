package sortingvisualizer;

import javax.swing.*;
import java.awt.*;

public class LegendPanel extends JPanel {

    public LegendPanel() {
        setLayout(new FlowLayout());

        add(createLegendItem(Color.YELLOW, "Compare"));
        add(createLegendItem(Color.RED, "Swap"));
        add(createLegendItem(Color.BLUE, "Sorted"));
    }

    private JPanel createLegendItem(Color color, String text) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel(text));
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(200, 20));
        return panel;
    }
}
