package Pages;

import javax.swing.*;
import java.awt.*;
import java.net.PasswordAuthentication;
import java.sql.*;


class DesignVoterLogin extends JFrame {

    String g;


    DesignVoterLogin() {
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
                    String pass2 =  String.valueOf(password.getPassword());
                    if (verfiy(grno.getText(),pass2))
                    {
                        new BallotPage(grno.getText());

                        dispose();
                    } else {

                        JOptionPane.showMessageDialog(null, "Invaild GRNO or password");

                    }


                });

        Cancel.addActionListener(
                a->
                {
                    new RoleSelection();
                    dispose();
                }

        );


        setVisible(true);
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("VoterLogin");
        c.setLayout(null);


        c.add(Grno);
        c.add(login);
        c.add(Password);
        c.add(password);
        c.add(grno);
        c.add(Cancel);


    }


   public static boolean verfiy(String grno ,String password1) {

//        String s1 = grno;
//        String s2 = password1;
        String grno1="";
        String pass1="";


        try {


            {


                String url = "jdbc:mysql://localhost:3306/sample";
                Connection conn = DriverManager.getConnection(url, "", ""); {
                    String sql = "SELECT  *  FROM  voters WHERE  GRNO =  ? AND password = ?  ";
                   PreparedStatement pst = conn.prepareStatement(sql);

                    {
                        pst.setString(1,grno);
                        pst.setString(2,password1);

                        ResultSet rs = pst.executeQuery();

                        while (rs.next())
                        {


                           grno1= rs.getString("GRNO");
                           pass1 = rs.getString("password");


                        }

                        if( grno1.equals(grno)&& pass1.equals(password1))
                        {

//                            System.out.println(grno);


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


    DesignVoterLogin(String s1)
{

}





}

class VoterLogin {

    DesignVoterLogin obj1=new DesignVoterLogin();

}
