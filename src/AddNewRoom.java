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
    PreparedStatement ps;
    AddNewRoom(){
        jf=new JFrame();
        f = new Font("Times New Roman",Font.BOLD,20);
        jf.setLayout(null);
        db = new DB();

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
        l4.setBounds(150,240,170,25);
        jf.add(l4);

        t4=new JTextField(20);
        t4.setBounds(320,240,250,25);
        t4.setToolTipText("Availbility");
        t4.setText(1+"");
        jf.add(t4);

        //l5 = new JLabel("Date*");
        //l5.setBounds(150,280,170,25);
        //jf.add(l5);

        //t5=new JTextField(20);
        //t5.setBounds(320,280,250,25);
        //t5.setToolTipText("Date");
        //jf.add(t5);

        //l7 = new JLabel("Time*");
        //l7.setBounds(150,320,170,25);
        //jf.add(l7);

        //t7=new JTextField(20);
        //t7.setBounds(320,320,250,25);
        //t7.setToolTipText("Time");
        //jf.add(t7);

        l8 = new JLabel("Type*");
        l8.setBounds(150,280,170,25);
        jf.add(l8);

        c1=new JComboBox();
        c1.setBounds(320,280,250,25);
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
        b0.setBounds(150,340,110,35);
        b0.setToolTipText("click to save room details");
        jf.add(b0);
        b0.addActionListener(this);

        b1 = new JButton("Clear");
        b1.setBounds(300,340,110,35);
        b1.setToolTipText("click to clear all textfilds");
        jf.add(b1);
        b1.addActionListener(this);

        b2= new JButton("All");
        b2.setBounds(450,340,110,35);
        b2.setToolTipText("click to view all room details");
        jf.add(b2);
        b2.addActionListener(this);

        scrlPane.setBounds(120,420,900,330);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("R_ID");
        model.addColumn("TITLE");
        model.addColumn("SIZE");
        model.addColumn("TYPE");
        model.addColumn("AVAILBILITY");

        jf.setTitle("Add New Room");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);

                }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b0) {


            if (((t2.getText()).equals("")) || ((t3.getText()).equals("")) || ((t4.getText()).equals("")) || (c1.getSelectedItem().toString().equals("select"))) {
                JOptionPane.showMessageDialog(this, "* Detail are Missing !", "Warning!!!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    con = db.getConnection();
                    System.out.println("Connected to database.");
                    ps = con.prepareStatement("insert into room_manager(rtitle,room_size,type,availability) values(?,?,?,?)");
                    ps.setString(1,t2.getText());
                    ps.setString(2,t3.getText());
                    ps.setString(3,c1.getSelectedItem().toString());
                    ps.setString(4,t4.getText());

                    ps.executeUpdate();
                    int reply=JOptionPane.showConfirmDialog(null,"Room added successfully.Do you want add more Rooms?","Added Room",JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION)
                    {
                        jf.setVisible(false);
                        new AddNewRoom();
                    }
                    else if (reply == JOptionPane.NO_OPTION)
                    {
                        jf.setVisible(false);
                    }con.close();

                } catch (SQLException se) {
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null, "SQL Error:" + se);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null,"Error:"+e);
                }

            }
        } else if (ae.getSource() == b1) {
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
        }
        else if(ae.getSource()==b2)
        {//list
            if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
            int r = 0;
            try
            {
                con=db.getConnection();
                System.out.println("Connected to database.");
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery("select * from room_manager " );
                while(rs.next())
                {
                    model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5) });
                }
                con.close();
            }
            catch(SQLException se)
            {
                System.out.println(se);
                JOptionPane.showMessageDialog(null,"SQL Error:"+se);
            }
            catch(Exception e)
            {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Error:"+e);
            }
        }
    }
    public static void main(String args[])
    {
        new AddNewRoom();
    }


}