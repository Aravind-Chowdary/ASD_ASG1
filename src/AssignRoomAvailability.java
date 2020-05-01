import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

public class AssignRoomAvailability extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1,l2,l3,l4,l5;
    JButton b0,b1,b2;
    JTextField t4;
    JComboBox c1,c3;
    DB db =null;
    Connection con;
    PreparedStatement ps;
    JDatePickerImpl datePicker;
    SqlDateModel datemodel;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    AssignRoomAvailability(){
        db = new DB();
        jf = new JFrame();
        jf.setLayout(null);

        l5=new JLabel("Assign Room availability ");
        l5.setFont(new Font("Times New Roman",Font.BOLD,25));
        l5.setBounds(250,50,300,40);
        l5.setForeground(Color.blue);
        jf.add(l5);
        
        l1 = new JLabel("Select Room *");
        l1.setBounds(150,120,130,25);
        jf.add(l1);

        c1=new JComboBox();
        c1.setBounds(320,120,200,25);c1.setToolTipText("Select Room");
        jf.add(c1);
        c1.addItem("Select Room");

        try {
            con=db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select rtitle from room_manager");
            while (rs.next()) {
                String round = rs.getString("rtitle");
                c1.addItem(round);
            }
            rs.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        l2= new JLabel("Select Date *");
        l2.setBounds(150,160,170,25);
        jf.add(l2);

        datemodel = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.today", "today");
        p.put("text.month", "month");
        p.put("text.year", "year");
        JDatePanelImpl datePanel = new JDatePanelImpl(datemodel, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datemodel.setSelected(true);
        datePicker.setBounds(320,160,200,25);datePicker.setToolTipText("Select Date");
        jf.add(datePicker);

        l3= new JLabel("Enter Day Type*");
        l3.setBounds(150,200,210,25);
        jf.add(l3);

        c3= new JComboBox();
        c3.setBounds(320,200,200,25);c3.setToolTipText("Choose Type");
        c3.addItem("Select Day Type");
        c3.addItem("Holiday");
        c3.addItem("Weekend");
        c3.addItem("TermTime");
        jf.add(c3);

        l4 = new JLabel("Time *");
        l4.setBounds(150,240,210,25);
        jf.add(l4);

        t4=new JTextField(20);
        t4.setBounds(320,240,200,25);
        t4.setToolTipText("Time");
        jf.add(t4);

        b0 = new JButton("Assign");
        b0.setBounds(150,320,110,35);b0.setToolTipText("click to save details");
        jf.add(b0);
        b0.addActionListener(this);

        b1 = new JButton("Clear");
        b1.setBounds(300,320,110,35);b1.setToolTipText("click to clear all textfilds");
        jf.add(b1);
        b1.addActionListener(this);

        b2= new JButton("All");
        b2.setBounds(450,320,110,35);b2.setToolTipText("click to view all  details");
        jf.add(b2);
        b2.addActionListener(this);

        scrlPane.setBounds(80,380,900,600);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("A_ID");
        model.addColumn("Room");
        model.addColumn("Date");
        model.addColumn("Type");
        model.addColumn("Time");

        jf.setTitle("Assign Day and Room Availability");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b0)
        {


            if((c1.getSelectedItem().toString().equals("Select Room")) || (c3.getSelectedItem().toString().equals("Select Day Type")) || datePicker.getModel().getValue()=="" ||t4.getText()=="" )
            {
                JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
            }

            else
            {
                try
                {
                    con=db.getConnection();
                    System.out.println("Connected to database.");

                    ps=con.prepareStatement("insert into room_availbility (room,adate,dtype,atime) values(?,?,?,?)");
                    ps.setString(1,c1.getSelectedItem().toString());
                    ps.setDate(2, (java.sql.Date) datePicker.getModel().getValue());
                    ps.setString(3,c3.getSelectedItem().toString());
                    ps.setString(4, t4.getText());
                    ps.executeUpdate();


                    int reply=JOptionPane.showConfirmDialog(null,"Date assigned successfully.Do you want assign more ?","Assigned Data ",JOptionPane.YES_NO_OPTION);

                    if (reply == JOptionPane.YES_OPTION)
                    {
                        jf.setVisible(false);
                        new AssignRoomAvailability();
                    }
                    else if (reply == JOptionPane.NO_OPTION)
                    {
                        jf.setVisible(false);
                    }con.close();
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
        else if(ae.getSource()==b1)
        {
            t4.setText("");
        }
    }
    public static void main(String args[])
    {
        new AssignRoomAvailability();
    }
}