package Testing;
import  java.util.Scanner;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DesignTester
{
    String hello = "Employee";
    DesignTester()
    {  Scanner sc = new Scanner(System.in);
      int id =sc.nextInt();
      String name = sc.next();
      double salary = sc.nextDouble();

        String url = "jdbc:mysql://localhost:3306/sample";
        try(Connection conn = DriverManager.getConnection(url, "", ""))
        {
            String sql = "INSERT INTO "+ hello+ " (id ,name, salary) VALUES (?,?,?)";

            try(PreparedStatement pst = conn.prepareStatement(sql))
            {
                 pst.setInt(1,id);
                 pst.setString(2,name );
                 pst.setDouble(3,salary);
                JOptionPane.showMessageDialog(null,"Success");

            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    }



class Tester1 {
    public static void main(String[] args) {
        DesignTester j= new DesignTester();
    }


}
