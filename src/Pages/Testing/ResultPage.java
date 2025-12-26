package Testing;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

class DesignResultPage extends JFrame {
    private Map<String, Integer> voteData = new HashMap<>();
Font d1 = new Font("roman",Font.BOLD,16);
    DesignResultPage() {
        String url = "jdbc:mysql://localhost:3306/sample";
        try (Connection conn = DriverManager.getConnection(url, "", "" )) {
            String sql = "SELECT candidate_id, candiadate_name, COUNT(*) AS vote_count FROM votes GROUP BY candidate_id, candiadate_name";

            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                String candidateName = rs.getString("candiadate_name");
                int voteCount = rs.getInt("vote_count");
                voteData.put(candidateName, voteCount);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        setTitle("Election Results");
        setSize(800, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new BarGraphPanel());
        setVisible(true);
    }

    class BarGraphPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawBarGraph(g);
        }

        private void drawBarGraph(Graphics g) {
            int width = 50; // Width of each bar
            int gap = 20;   // Gap between bars
            int maxVotes = voteData.values().stream().max(Integer::compare).orElse(1);
            int panelHeight = getHeight() - 50; // Leave space for labels

            int x = 50; // Initial x position for the first bar
            for (Map.Entry<String, Integer> entry : voteData.entrySet()) {
                String candidateName = entry.getKey();
                int voteCount = entry.getValue();
                int barHeight = (int) ((double) voteCount / maxVotes * panelHeight);

                // Draw the bar
                g.setColor(Color.BLUE);
                g.fillRect(x, panelHeight - barHeight, width, barHeight);

                // Draw the vote count inside the bar
                g.setColor(Color.WHITE);
                g.setFont(d1);// Change color to white for better visibility
                String voteCountStr = String.valueOf(voteCount);
                FontMetrics metrics = g.getFontMetrics();
                int textWidth = metrics.stringWidth(voteCountStr);
                int textX = x + (width - textWidth) / 2; // Center the text
                int textY = panelHeight - barHeight + (metrics.getHeight() / 2); // Center vertically within the bar
                g.drawString(voteCountStr, textX, textY);

                // Draw the candidate name below the bar
                g.setColor(Color.BLACK);
                g.drawString(candidateName, x, panelHeight + 15);

                x += width + gap; // Move to the next bar position
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DesignResultPage::new);
    }
}

class ResultPage {
    public static void main(String[] args) {
        new DesignResultPage();
    }
}