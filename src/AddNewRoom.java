import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddNewRoom extends JFrame implements ActionListener
{
    JFrame jf;
    Font f;
    JLabel l2,l3,l4,l5,l6,l7,l8;
    JTextField t2,t3,t4,t5,t7;
    JButton b0,b1,b2;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    JComboBox c1;
    DB db = null;
    Connection con;
    Statement stmt;
    ResultSet rs;
    AddNewRoom(){
        jf=new JFrame();
        f = new Font("Times New Roman",Font.BOLD,20);
        jf.setLayout(null);

        l6=new JLabel("Add New Room");
        l6.setFont(new Font("Times New Roman",Font.BOLD,25));
        l6.setBounds(150,100,300,40);l6.setForeground(Color.black);
        jf.add(l6);

        l2 = new JLabel("Room name*");
        l2.setBounds(150,160,170,25);
        jf.add(l2);

        t2=new JTextField(20);
        t2.setBounds(320,160,250,25);
        t2.setToolTipText("Enter Room name");
        jf.add(t2);

        l3 = new JLabel("Room Size*");
        l3.setBounds(150,200,170,25);
        jf.add(l3);

        t3=new JTextField(20);
        t3.setBounds(320,200,250,25);
        t3.setToolTipText("Enter Room Size");
        jf.add(t3);

        l4 = new JLabel("Availbility*");
        //l3.setFont(f);
        l4.setBounds(150,240,170,25);
        jf.add(l4);

        t4=new JTextField(20);
        t4.setBounds(320,240,250,25);
        t4.setToolTipText("Availbility");
        jf.add(t4);

        l5 = new JLabel("Date*");
        //l3.setFont(f);
        l5.setBounds(150,280,170,25);
        jf.add(l5);


        t5=new JTextField(20);
        t5.setBounds(320,280,250,25);
        t5.setToolTipText("Date");
        jf.add(t5);

        l7 = new JLabel("Time*");
        //l3.setFont(f);
        l7.setBounds(150,320,170,25);
        jf.add(l7);

        t7=new JTextField(20);
        t7.setBounds(320,320,250,25);
        t7.setToolTipText("Time");
        jf.add(t7);

        l8 = new JLabel("Type*");
        //l3.setFont(f);
        l8.setBounds(150,360,170,25);
        jf.add(l8);

        c1=new JComboBox();
        c1.setBounds(320,360,250,25);
        c1.setToolTipText("Enter Type");
        c1.addItem("select");
        try {
            con=db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select roomtype from typemaster");
            while (rs.next()) {
                String mrd = rs.getString("roomtype");
                c1.addItem(mrd);
            }

            rs.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        jf.add(c1);

        b0 = new JButton("Save");
        b0.setBounds(150,390,110,35);
        b0.setToolTipText("click to save room details");
        jf.add(b0);
        b0.addActionListener(this);

        b1 = new JButton("Clear");
        b1.setBounds(300,390,110,35);
        b1.setToolTipText("click to clear all textfilds");
        jf.add(b1);

        b2= new JButton("All");
        b2.setBounds(450,390,110,35);
        b2.setToolTipText("click to view all room details");
        jf.add(b2);

        scrlPane.setBounds(120,450,900,300);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("R_ID");
        model.addColumn("TITLE");
        model.addColumn("SIZE");
        model.addColumn("TYPE");
        model.addColumn("AVAILBILITY");
        model.addColumn("DATE");
        model.addColumn("TIME");
        jf.setTitle("Add New Room");
        //jf.setSize(900,700);
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);

                }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b0) {


            if (((t2.getText()).equals("")) || ((t3.getText()).equals("")) || ((t4.getText()).equals("")) || ((t5.getText()).equals("")) || (c1.getSelectedItem().toString().equals("select"))) {
                JOptionPane.showMessageDialog(this, "* Detail are Missing !", "Warning!!!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    con = db.getConnection();
                    System.out.println("Connected to database.");
                    con.close();
                } catch (SQLException se) {
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null, "SQL Error:" + se);
                }


            }
        }
    }
    public static void main(String args[])
    {
        new AddNewRoom();
    }


}