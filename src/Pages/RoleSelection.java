package Pages;


import javax.swing.*;
import java.awt.*;

class DesignRoleSelection extends JFrame
{
    DesignRoleSelection()
    {
        Font f1 = new Font("calibri",Font.BOLD,35);
        Font f2 =new Font("calibri",Font.PLAIN,25);
        Font f3 =new Font("calibri",Font.BOLD,22);

        ImageIcon logo=new ImageIcon("C:\\Users\\Madhur\\IdeaProjects\\JAVASWINGS\\src\\image\\logo.png");
        Image lo =logo.getImage();
        Image logoscaled =lo.getScaledInstance(175,175,Image.SCALE_SMOOTH);

        ImageIcon LO=new ImageIcon(logoscaled);
        JLabel Logo =new JLabel();
        Logo.setIcon(LO);
        Logo.setBounds(0,0,175,175);

        JLabel l=new JLabel("Election");

        JLabel l1=new JLabel("Select Your Role");
        l1.setFont(f1);
        l1.setBounds(100,200,500,45);


         JButton b1=new JButton("Voter");
         b1.setFont(f3);
         b1.setFocusable(false);
         b1.setBounds(50,390,100,30);
         b1.setVerticalTextPosition(JButton.CENTER);
         b1.setHorizontalAlignment(JButton.CENTER);
         b1.setBackground(Color.WHITE);

        JButton b2=new JButton("Admin");
        b2.setFont(f3);
        b2.setFocusable(false);
        b2.setBounds(290,390,100,30);
        b2.setVerticalTextPosition(JButton.CENTER);
        b2.setHorizontalAlignment(JButton.CENTER);
        b2.setBackground(Color.WHITE);


        JButton b3 =new JButton("Display result");
        b3.setFont(f3);
        b3.setFocusable(false);
        b3.setBounds(60,450,250,30);
        b3.setVerticalTextPosition(JButton.CENTER);
        b3.setHorizontalAlignment(JButton.CENTER);
        b3.setBackground(Color.WHITE);
        
        Container c =getContentPane();

        setVisible(true);
        setSize(500,650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Election");

        c.setLayout(null);
        c.add(l1);
        c.add(b1);
        c.add(b2);
        c.add(Logo);
        c.add(b3);
        c.setBackground(Color.WHITE);


        b1.addActionListener(
                a->
                {
                    new VoterLogin();
                    dispose();
                }

        );

        b2.addActionListener(
                a->
                {
                    new AdminLogin();
                    dispose();
                }

        );
        b3.addActionListener(
                a->
                {
                    new DesignViewResultPage();

                }
        );


    }
}
class RoleSelection {
    DesignRoleSelection obj1=new DesignRoleSelection();


}
