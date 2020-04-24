import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t7;
    JButton b0,b1,b2,b3,b4;
    Font f;
    JComboBox c1;
    Connection con;
    DB db = null;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    PreparedStatement ps;
    UpdateRoom()
    {
        jf = new JFrame();
        f = new Font("Times New Roman",Font.BOLD,20);
        jf.setLayout(null);

        l6=new JLabel("Update Rooms");
        l6.setFont(new Font("Times New Roman",Font.BOLD,25));
        l6.setBounds(150,70,300,40);l6.setForeground(Color.black);
        jf.add(l6);

        l1= new JLabel("Room  id *");
        //l1.setFont(f);
        l1.setBounds(150,120,130,25);
        jf.add(l1);

        t1=new JTextField(20);
        t1.setBounds(320,120,250,25);t1.setToolTipText("Enter Room id");
        jf.add(t1);

        l2 = new JLabel("Room name*");
        //l2.setFont(f);
        l2.setBounds(150,160,170,25);
        jf.add(l2);

        t2=new JTextField(20);
        t2.setBounds(320,160,250,25);
        t2.setToolTipText("Enter Room name");
        jf.add(t2);

        l3 = new JLabel("Room Size*");
        //l3.setFont(f);
        l3.setBounds(150,200,170,25);
        jf.add(l3);

        t3=new JTextField(20);
        t3.setBounds(320,200,250,25);
        t3.setToolTipText("Enter Room Size");
        jf.add(t3);

        l4 = new JLabel("Availbility*");
        l4.setBounds(150,240,170,25);
        jf.add(l4);

        t4=new JTextField(20);
        t4.setBounds(320,240,250,25);
        t4.setToolTipText("Availbility");
        jf.add(t4);


        l5 = new JLabel("Date*");
        l5.setBounds(150,280,170,25);
        jf.add(l5);

        t5=new JTextField(20);
        t5.setBounds(320,280,250,25);
        t5.setToolTipText("Date");
        jf.add(t5);

        l7 = new JLabel("Time*");
        l7.setBounds(150,320,170,25);
        jf.add(l7);

        t7=new JTextField(20);
        t7.setBounds(320,320,250,25);
        t7.setToolTipText("Time");
        jf.add(t7);

        l8 = new JLabel("Type*");
        l8.setBounds(150,360,170,25);
        jf.add(l8);

        c1=new JComboBox();
        c1.setBounds(320,360,250,25);c1.setToolTipText("Enter Type");
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

        b0 = new JButton("Open");
        b0.setBounds(150,390,110,35);
        b0.setToolTipText("click to open room details");
        b0.addActionListener(this);
        jf.add(b0);

        b1 = new JButton("Update");
        b1.setBounds(300,390,110,35);
        b1.setToolTipText("click to update room details");
        b1.addActionListener(this);
        jf.add(b1);

        b2 = new JButton("Clear");
        b2.setBounds(450,390,110,35);
        b2.setToolTipText("click to clear all");
        b2.addActionListener(this);
        jf.add(b2);

        b3 = new JButton("All");
        b3.setBounds(600,390,110,35);
        b3.setToolTipText("click to view all room details");
        b3.addActionListener(this);
        jf.add(b3);

        b4 = new JButton("Delete");
        b4.setBounds(750,390,110,35);
        b4.setToolTipText("click to delete room details");
        b4.addActionListener(this);
        jf.add(b4);

        scrlPane.setBounds(120,450,900,600);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));
        jf.setTitle("Update Room");
        // jf.setSize(900,700);
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b0) {
            if (((t1.getText()).equals("")) && ((t2.getText()).equals(""))) {
                JOptionPane.showMessageDialog(this, "Please enter room id or name !", "Warning!!!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    con = db.getConnection();
                    System.out.println("Connected to database.");
                    ps=con.prepareStatement("select * from room_manager where room_id='"+t1.getText()+"' or rtitle='"+t2.getText()+"'");
                    rs=ps.executeQuery();
                    while(rs.next())
                    con.close();
                } catch(SQLException se)
                {
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null,"SQL Error:"+se);
                }
            }
        }
        else if (ae.getSource() == b1){
            if(((t1.getText()).equals(""))&&((t2.getText()).equals("")))
            {
                JOptionPane.showMessageDialog(this,"Please enter room id or name !","Warning!!!",JOptionPane.ERROR_MESSAGE);
            }
            else if(((t2.getText()).equals(""))||((t3.getText()).equals(""))||((t4.getText()).equals(""))||((t5.getText()).equals("")))
            {
                JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try {
                    con = db.getConnection();
                    System.out.println("Connected to database.");
                    con.close();
                } catch(SQLException se)
                {
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null,"SQL Error:"+se);
                }
            }
        }
        else if(ae.getSource()==b2)
        {//clear
            t1.setText("");
            t2.setText("");
            t3.setText("");

        }
        else if(ae.getSource()==b3) {//list
            if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
        }
        try {
            con = db.getConnection();
            System.out.println("Connected to database.");
            con.close();
        } catch(SQLException se)
        {
            System.out.println(se);
            JOptionPane.showMessageDialog(null,"SQL Error"+se);
        }
    }
    public static void main(String args[])
    {
        new UpdateRoom();
    }
}