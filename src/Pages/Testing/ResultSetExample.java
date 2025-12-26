package Testing;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ResultSetExample extends JFrame {
    private JTextArea textArea;

    public ResultSetExample() {
        textArea = new JTextArea(20, 30);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        setTitle("ResultSet Example");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        fetchData();
    }

    private void fetchData() {
        String query =  "SELECT *  FROM voters WHERE  GRNO = '2023FHIT062' AND password ='423' ";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "", "");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // Retrieve data from the ResultSet

                String name = rs.getString("GRNO");
                String email = rs.getString("password");

                // Append data to the text area
                textArea.append( "Name: " + name + ", Email: " + email + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ResultSetExample().setVisible(true);
        });
    }
}

