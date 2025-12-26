package Testing;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class VoteBarGraph extends JPanel {
    private int[] voteCounts;
    private String[] candidateNames;

    // Constructor to initialize the graph panel with data
    public VoteBarGraph(int[] voteCounts, String[] candidateNames) {
        this.voteCounts = voteCounts;
        this.candidateNames = candidateNames;
    }

    // Method to paint the bar graph
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int barWidth = width / voteCounts.length;

        for (int i = 0; i < voteCounts.length; i++) {
            int barHeight = (int) ((double) voteCounts[i] / getMaxVoteCount() * height);
            g.fillRect(i * barWidth, height - barHeight, barWidth - 5, barHeight);
            g.drawString(candidateNames[i], i * barWidth, height - barHeight - 5);
        }
    }

    // Method to get the maximum vote count for scaling
    private int getMaxVoteCount() {
        int max = 0;
        for (int count : voteCounts) {
            if (count > max) max = count;
        }
        return max;
    }

    // Main method to fetch data and create the bar graph
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample";
        int[] voteCounts = new int[10]; // Adjust size as necessary
        String[] candidateNames = new String[10]; // Adjust size as necessary
        int index = 0;

        // Fetch data from the database
        try (Connection conn = DriverManager.getConnection(url, "", "")) {
            String sql = "SELECT candidate_id, candidate_name, COUNT(*) AS vote_count FROM votes GROUP BY candidate_id, candidate_name";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                candidateNames[index] = rs.getString("candidate_name");
                voteCounts[index] = rs.getInt("vote_count");
                index++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create the JFrame and add the bar graph panel
        JFrame frame = new JFrame("Vote Bar Graph");
        VoteBarGraph panel = new VoteBarGraph(voteCounts, candidateNames);
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}