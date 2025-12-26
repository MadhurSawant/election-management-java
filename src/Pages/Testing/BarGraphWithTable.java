package  Testing;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BarGraphWithTable extends JFrame {

    private JTable table;

    public BarGraphWithTable(String title) {
        super(title);
        setLayout(new BorderLayout());

        // Create the table
        String[] columnNames = {"Item", "Value"};
        Object[][] data = {
                {"Item 1", 5},
                {"Item 2", 3},
                {"Item 3", 8},
                {"Item 4", 2}
        };
        table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane tableScrollPane = new JScrollPane(table);
        add(tableScrollPane, BorderLayout.WEST);

        // Create the bar graph panel
        BarGraphPanel barGraphPanel = new BarGraphPanel();
        barGraphPanel.setPreferredSize(new Dimension(600, 400));
        add(barGraphPanel, BorderLayout.CENTER);
    }

    private class BarGraphPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = 50; // Width of each bar
            int gap = 20; // Gap between bars
            int maxHeight = getHeight() - 50; // Max height for the bars
            int maxValue = getMaxValue(); // Get the maximum value for scaling

            // Get data from the table
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int rowCount = model.getRowCount();

            // Draw the bars
            for (int i = 0; i < rowCount; i++) {
                int value = (int) model.getValueAt(i, 1); // Get the value from the table
                int barHeight = (int) ((double) value / maxValue * maxHeight);
                int x = i * (width + gap) + 50; // X position of the bar
                int y = getHeight() - barHeight - 30; // Y position of the bar
                g.setColor(Color.BLUE);
                g.fillRect(x, y, width, barHeight);
                g.setColor(Color.BLACK);
                g.drawString((String) model.getValueAt(i, 0), x, getHeight() - 10); // Label for the bar
            }
        }

        private int getMaxValue() {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int maxValue = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                int value = (int) model.getValueAt(i, 1);
                if (value > maxValue) {
                    maxValue = value;
                }
            }
            return maxValue;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BarGraphWithTable example = new BarGraphWithTable("Bar Graph with Table Example");
            example.setSize(800, 400);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}