package Testing;


import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MenuBar extends JFrame {

    MenuBar()
    {
//        Font f1 = new Font("calibri",Font.BOLD,40);
//        Font f2 =new Font("calibri",Font.PLAIN,22);
//        Font f3 =new Font("calibri",Font.PLAIN,22);

        Container c =getContentPane();
        c.setLayout(null);
        setVisible(true);
        setSize(1020,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Admin");


        JMenuBar menu =new JMenuBar();

        JMenu Candidate =new JMenu("Candidate");
        JMenu save=new JMenu("save");
        menu.add(Candidate);
        menu.add(save);

        JMenuItem j=new JMenuItem("Add");
        JMenuItem j1=new JMenuItem("Delete");
        Candidate.add(j);
        Candidate.add(j1);

        save.add(new JMenuItem("Save as"));


        setJMenuBar(menu);





//     JButton b1= new JButton("Candiate");
//    b1.setBounds(40,60,100,50);
//    b1.setFont(f2);


        j.addActionListener(
                a->
                {


                    Font f1 = new Font("calibri", Font.BOLD, 40);
                    Font f2 = new Font("Arial", Font.PLAIN, 22);
                    Font f3 = new Font("calibri", Font.BOLD, 22);



                    setBackground(Color.WHITE);


                    JLabel l1=new JLabel("GRNO");
                    l1.setFont(f2);
                    l1.setBounds(100,100,100,30);

                    JTextField t1=new JTextField(30);
                    t1.setFont(f2);
                    t1.setBounds(200,100,200,30);

//         JLabel l2=new JLabel("Password");
//         l2.setFont(f2);
//         l2.setBounds(100,100,100,30);

//         JTextField t2=new JTextField(30);
//         t2.setFont(f2);
//         t2.setBounds(200,100,200,30);

//
//         JLabel l3=new JLabel("Email");
//         l3.setFont(f2);
//         l3.setBounds(100,150,100,30);
//         JTextField t3=new JTextField(30);
//         t3.setFont(f2);
//         t3.setBounds(200,150,200,30);

                    JLabel l4=new JLabel("Deparment");
                    l4.setFont(f2);
                    l4.setBounds(100,150,200,30);

                    JTextField t4=new JTextField(30);
                    t4.setFont(f2);
                    t4.setBounds(250,150,200,30);

                    JLabel l5 =new JLabel("name");
                    l5.setFont(f2);
                    l5.setBounds(100,200,100,30);

                    JTextField t5=new JTextField(30);
                    t5.setFont(f2);
                    t5.setBounds(250,200,200,30);

                    JLabel l6 =new JLabel("Position");
                    l6.setFont(f2);
                    l6.setBounds(100,250,100,30);

                    JTextField t6=new JTextField(30);
                    t6.setFont(f2);
                    t6.setBounds(250,250,200,30);




                    JButton b1 =new JButton("ADD");
                    b1.setFont(f3);
                    b1.setBounds(200,300,100,30);
                    b1.setFocusable(false);


                    JButton b2 =new JButton("Delete");
                    b2.setFont(f3);
                    b2.setBounds(450,300,100,30);
                    b2.setFocusable(false);


                    b1.addActionListener(
                            ae->
                            {
                                String url = "jdbc:mysql://localhost:3306/sample";
                                try(Connection conn = DriverManager.getConnection(url, "", ""))
                                {
                                    String sql = "INSERT INTO candidates (GRNO, name, department,position) VALUES (?,?,?,?)";

                                    try(PreparedStatement pst = conn.prepareStatement(sql))
                                    {
                                        String GRNO = t1.getText();
                                        String name = t5.getText();
//                             String pass= t2.getText();
//                             String email =t3.getText();
                                        String department = t4.getText();
                                        String position= t6.getText();


                                        pst.setString(1,GRNO);
                                        pst.setString(2,name);
                                        pst.setString(3, department);
                                        pst.setString(4,position);
                                        ;

                                        pst.executeUpdate();

                                        JOptionPane.showMessageDialog(null,"Success");

                                    }
                                }
                                catch (SQLException e)
                                {
                                    JOptionPane.showMessageDialog(null,e.getMessage());
                                }
                            }


                    );



                    Container ce = getContentPane();
                    setVisible(true);
//                    setSize(800, 550);
                    setDefaultCloseOperation(EXIT_ON_CLOSE);
                    setLocationRelativeTo(null);
//                    setTitle("");
                    c.add(l1);
                    c.add(t1);
//         c.add(t2);
//         c.add(l3);
//         c.add(t3);
                    c.add(l4);
                    c.add(t4);
                    c.add(l5);
                    c.add(t5);
                    c.add(l6);
                    c.add(t6);

                    c.add(b1);
                    c.add(b2);
                    c.setLayout(null);












                }
        );


    }

    public static void main(String[] args) {
         MenuBar j  =new MenuBar();
    }

}
