package Pages;
import Pages.DesignVoterLogin;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

class  DesignBallotPage extends JFrame
{




    DesignBallotPage( String s1)

    {


        Font f1 = new Font("calibri",Font.BOLD,40);
        Font f2 =new Font("Arial",Font.PLAIN,19);
        Font f3 =new Font("calibri",Font.BOLD,22);

        JLabel title=new JLabel("Ballot");
        title.setFont(f1);
        title.setBounds(50,35,150,40);


        ArrayList<String>GRNO =new ArrayList<>();
        ArrayList<String>names =new ArrayList<>();
        ArrayList<String>combined =new ArrayList<>();

        String url1 = "jdbc:mysql://localhost:3306/sample";
        try(Connection conn = DriverManager.getConnection(url1, "", ""))
        {
            String sql1 = "Select candidates_id ,name  from candidates ";

            try(PreparedStatement pst = conn.prepareStatement(sql1))
            {
               ResultSet rs = pst.executeQuery();

               while (rs.next())
               {
                   GRNO.add(rs.getString("candidates_id"));
                   names.add(rs.getString("name"));


               }

            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }



//        String[] Candiate = { "NOTA","Madhur","Vedant","Riya","Saif"};
        JComboBox <String> ballot= new JComboBox<>();
        String str="";

        for (String item : GRNO  )
        {
            for(String item2:names)
            {
                 if(GRNO.indexOf(item)== names.indexOf(item2)) {
                     str = item + item2;
                     ballot.addItem(str);
                     combined.add(str);
                 }


            }


        }



        ballot.setFont(f2);
        ballot.setBounds(150,160,250,30);


        JButton vote =new JButton("Vote");
        vote.setBounds(200,250,100,30);
        vote.setFont(f3);
        vote.setFocusable(false);
        vote.setForeground(Color.CYAN);
        vote.setBackground(Color.BLACK);

        JLabel j =new JLabel(s1);
        j.setBounds(50,45,150,40);


        JLabel l1=new JLabel();
        l1.setFont(f3);
        l1.setBounds(50,100,700,22);
        l1.setForeground(Color.RED);

        JButton fin =new JButton("Final vote");
        fin.setBounds(200,250,200,30);
        fin.setFont(f3);
        fin.setForeground(Color.RED);
        fin.setBackground(Color.BLACK);
        fin.setVisible(false);

        vote.addActionListener(
                a->
                {
                    String msg="Your Vote to  " + ballot.getSelectedItem();
                    String str5 = ballot.getSelectedItem().toString();
                    l1.setText(msg);

                     for(String item : combined)
                     {
                         if(item.equals(str5))
                         {
                             for (String item1 :GRNO)
                             {
                                 for(String item2 : names)
                                 {
                                    if (str5.equals(item1+item2))
                                    {


                                        String url = "jdbc:mysql://localhost:3306/sample";
                                        try(Connection conn = DriverManager.getConnection(url, "", ""))
                                        {
                                            String sql = "INSERT INTO votes (GRNO,candidate_id,candiadate_name) VALUES (?,?,?)";

                                            try(PreparedStatement pst = conn.prepareStatement(sql))
                                            {

                                                pst.setString(1,s1);
                                                pst.setString(2,item1);
                                                pst.setString(3,item2);


                                                pst.executeUpdate();

                                                JOptionPane.showMessageDialog(null,"Success");

                                            }
                                        }
                                        catch (SQLException e)
                                        {
                                            JOptionPane.showMessageDialog(null,e.getMessage());
                                        }

                                    }
                                 }
                             }

                         }
                     }



                      dispose();
                }


        );







//
//
//


        Container c =getContentPane();
        setVisible(true);
        setSize(800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Ballotpage");
        c.add(title);
        c.add(ballot);
        c.add(vote);
        c.add(l1);
        c.add(fin);
        c.add(j);

        c.setLayout(null);


    }







}

class BallotPage {

BallotPage(String s34)
{

    DesignBallotPage s =new DesignBallotPage(s34);
}



}

