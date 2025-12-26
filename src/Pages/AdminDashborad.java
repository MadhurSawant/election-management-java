package Pages;

import  java.awt.*;
import javax.swing.*;

class DesginAdminDashborad extends JFrame
{
     DesginAdminDashborad()
     {

         Font f1 = new Font("calibri",Font.BOLD,40);
         Font f2 =new Font("calibri",Font.PLAIN,20);
         Font f3 =new Font("calibri",Font.BOLD,22);


         ImageIcon candiate=new ImageIcon("C:\\Users\\Madhur\\IdeaProjects\\JAVASWINGS\\src\\image\\img_2.png");
         ImageIcon voter =new ImageIcon("C:\\Users\\Madhur\\IdeaProjects\\JAVASWINGS\\src\\image\\img_3.png");
         ImageIcon result = new ImageIcon("C:\\Users\\Madhur\\IdeaProjects\\JAVASWINGS\\src\\image\\img_4.png");

         JLabel l1=new JLabel("Dashborad");
         l1.setFont(f1);
         l1.setBounds(60,40,250,40);



         JButton b1=new JButton();
         b1.setBounds(40,160,225,225);
         b1.setFont(f2);
         b1.setIcon(candiate);
         b1.setFocusable(false);

         JButton b2=new JButton();
         b2.setBounds(300,160,225,225);
         b2.setIcon(voter);
         b2.setFocusable(false);

         JButton b3 = new JButton();
           b3.setBounds(550,160,225,225);
           b3.setIcon(result);
           b3.setFocusable(false);

           JButton b4=new JButton("Log out");
           b4.setBounds(550,550,150,30);
           b4.setFont(f3);
           b4.setForeground(Color.white);
         b4.setFocusable(false);
         b4.setBackground(Color.RED);

         Container c =getContentPane();
         c.add(l1);
         c.add(b1);
         c.add(b2);
         c.add(b3);
         c.add(b4);

         c.setLayout(null);
         setVisible(true);
         setSize(800,650);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         setTitle("Dashborad");
         c.setBackground(Color.WHITE);

         b1.addActionListener(
                 a->
                 {

                            new CandiatePage();
                            dispose();
                 }
         );

         b2.addActionListener(
                 a->
                 {
                     new VoterPage();
                     dispose();
                 }
         );


         b3.addActionListener(
                 a->
                 {
                     new ResultPage();
                     dispose();
                 }

         );

         b4.addActionListener(
                 a->
                 {
                     new RoleSelection();
                     dispose();
                 }

         );


     }
}


 class AdminDashborad {


     DesginAdminDashborad obj1=new DesginAdminDashborad();
}
