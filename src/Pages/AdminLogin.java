package Pages;
import  java.awt.*;
import java.sql.*;


import javax.swing.*;
class BlankException extends Exception
{
    public String toString() {
        return "Blank";
    }

    public String getMessage() {

        return  "Message";

    }
}
class IncorrectException  extends Exception
{
    public String toString()
    {
        return"Incorrect";
    }

    public String getMessage()
    {
        return "Incorrect";
    }

}


    class DesginAdminLogin extends JFrame {
        DesginAdminLogin() {
            Container c = getContentPane();
            Font f1 = new Font("calibri", Font.BOLD, 40);
            Font f2 = new Font("calibri", Font.PLAIN, 22);
            Font f3 = new Font("calibri", Font.PLAIN, 22);
            setTitle("UserLogin");

            JLabel Grno = new JLabel("Grno");
            Grno.setBounds(40, 100, 100, 30);
            JTextField grno = new JTextField(30);
            grno.setBounds(140, 100, 200, 30);
            JLabel Password = new JLabel("Password");
            Password.setBounds(40, 140, 100, 30);
            JPasswordField password = new JPasswordField(30);
            password.setBounds(140, 140, 200, 30);
            JButton login = new JButton("Login");
            login.setBounds(100, 200, 100, 20);
            JButton Cancel = new JButton("Cancel");
            Cancel.setBounds(300, 200, 100, 20);


            login.addActionListener(

                    a -> {
                        String s1 = grno.getText();
                        String s2 = String.valueOf(password.getPassword());
                        if (verfiy(grno.getText(),s2))
                        {
                            new AdminDashborad();
                            dispose();
                        } else {

                            JOptionPane.showMessageDialog(null, "Invaild GRNO or password");

                        }


                    });

            Cancel.addActionListener(
                    a ->
                    {
                        new RoleSelection();
                        dispose();
                    }

            );


            setVisible(true);
            setSize(600, 500);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setTitle("AdminLogin");
            c.setLayout(null);
            c.setBackground(Color.WHITE);


            c.add(Grno);
            c.add(login);
            c.add(Password);
            c.add(password);
            c.add(grno);
            c.add(Cancel);


        }

        public static boolean verfiy(String username  ,String password1)
        {
            String u1= "";
            String p1 = "";




            try {


                {


                    String url = "jdbc:mysql://localhost:3306/sample";
                    Connection conn = DriverManager.getConnection(url, "", ""); {
                    String sql = "SELECT  *  FROM  admin WHERE  username = ? AND password = ?  ";
                    PreparedStatement pst = conn.prepareStatement(sql);

                    {
                        pst.setString(1,username);
                        pst.setString(2,password1);

                        ResultSet rs = pst.executeQuery();

                        while (rs.next())
                        {
                          u1 = rs.getString("username");
                          p1 = rs.getString("password");

                        }

                        if(u1.equals(username)&& p1.equals(password1) )
                        {


                            return  true;

                        }
                        else
                        {
                            return  false;
                        }


                    }
                }
                }
            }
            catch (SQLException e) {

//            JOptionPane.showMessageDialog(null, e.getMessage());
                return false;


            }



        }
    }

class AdminLogin {

        DesginAdminLogin obj1=new DesginAdminLogin();


}
