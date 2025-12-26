package Pages;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;


class DesignResultPage extends JFrame
 {
     DesignResultPage()
     {
          Container c =getContentPane();
         DefaultTableModel model = new DefaultTableModel();

         String url = "jdbc:mysql://localhost:3306/sample";
         try(Connection conn = DriverManager.getConnection(url, "", ""))
         {
                 String sql ="SELECT candidate_id, candiadate_name, COUNT(*) AS vote_count FROM votes GROUP BY candidate_id, candiadate_name";

                 PreparedStatement p = conn.prepareStatement(sql);
                 ResultSet rs = p.executeQuery();
               ResultSetMetaData metaData = rs.getMetaData();
             int  columnCount = metaData.getColumnCount();

             String[] columnNames = new String[columnCount];
             for (int i = 1; i <= columnCount; i++) {
                 columnNames[i - 1] = metaData.getColumnName(i);
             }
               model.setColumnIdentifiers(columnNames);

             while (rs.next()) {


                 Object[] row = new Object[columnCount];

                 for (int i = 1; i <= columnCount; i++)
                 {
                     row[i - 1] = rs.getObject(i);
                 }
                 model.addRow(row);

             }


                 JTable table = new JTable(model);
                 JScrollPane scrollPane = new JScrollPane(table);
                 c.add(scrollPane);




         }

         catch (SQLException e) {

              JOptionPane.showMessageDialog(null,e.getMessage());

         }



         setVisible(true);
         setSize(800,550);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         setTitle("Result");

     }

 }


class ResultPage {
    DesignResultPage i= new DesignResultPage();
}
