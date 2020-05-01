import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Statement;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateRoomBooking extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5,t7;
    JButton b0,b1,b2,b3,b4;
    JComboBox c1;
    DB db = null;
    Connection con;
    JDatePickerImpl datePicker;
    SqlDateModel datemodel;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    UpdateRoomBooking() {
        jf = new JFrame();
        jf.setLayout(null);
        db = new DB();

        l1= new JLabel("Booking id *");
        l1.setBounds(150,120,130,25);
        jf.add(l1);

        t1=new JTextField(20);
        t1.setBounds(320,120,250,25);t1.setToolTipText("Enter Booking id");
        jf.add(t1);

        l2 = new JLabel("Full Name*");
        l2.setBounds(150,160,170,25);
        jf.add(l2);

        t2=new JTextField(20);
        t2.setBounds(320,160,250,25);t2.setToolTipText("Enter Full Name");
        jf.add(t2);

        l3 = new JLabel("Address*");
        l3.setBounds(150,200,170,25);
        jf.add(l3);

        t3=new JTextField(20);
        t3.setBounds(320,200,250,25);t3.setToolTipText("Enter Address");
        jf.add(t3);

        l4 = new JLabel("Phone Number*");
        l4.setBounds(150,240,170,25);
        jf.add(l4);

        t4=new JTextField(20);
        t4.setBounds(320,240,250,25);t4.setToolTipText("Enter Phone Number");
        jf.add(t4);

        l5 = new JLabel("Email ID*");
        l5.setBounds(150,280,170,25);
        jf.add(l5);

        t5=new JTextField(20);
        t5.setBounds(320,280,250,25);t5.setToolTipText("Enter Email ID");
        jf.add(t5);

        l7 = new JLabel("Description*");
        l7.setBounds(150,320,170,25);
        jf.add(l7);

        t7=new JTextField(20);
        t7.setBounds(320,320,250,25);t7.setToolTipText("Enter Description");
        jf.add(t7);


        l8 = new JLabel("Select Date*");
        l8.setBounds(150,360,170,25);
        jf.add(l8);

        datemodel = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.today", "today");
        p.put("text.month", "month");
        p.put("text.year", "year");
        JDatePanelImpl datePanel = new JDatePanelImpl(datemodel, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datemodel.setSelected(true);
        datePicker.setBounds(320,360,250,25);
        datePicker.setToolTipText("Date");
        jf.add(datePicker);

        l9 = new JLabel("Room*");
        l9.setBounds(150,400,170,25);
        jf.add(l9);

        c1=new JComboBox();
        c1.setBounds(320,400,250,25);c1.setToolTipText("Select Room");
        c1.addItem("Select Room");
        try {
            con=db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select rtitle from room_manager where availability=1");
            while (rs.next()) {
                String mrd = rs.getString("rtitle");
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
        b0.setBounds(150,450,110,35);b0.setToolTipText("click to open MR details");
        jf.add(b0); b0.addActionListener(this);

        b1 = new JButton("Update");
        b1.setBounds(300,450,110,35);b1.setToolTipText("click to update MR details");
        jf.add(b1);b1.addActionListener(this);

        b2 = new JButton("Clear");
        b2.setBounds(450,450,110,35);b2.setToolTipText("click to clear all textfilds");
        jf.add(b2);b2.addActionListener(this);

        b3 = new JButton("All");
        b3.setBounds(600,450,110,35);b3.setToolTipText("click to view all MR details");
        jf.add(b3); b3.addActionListener(this);

        b4 = new JButton("Delete");
        b4.setBounds(750,450,110,35);b4.setToolTipText("click to Delete MR details");
        jf.add(b4); b4.addActionListener(this);

        scrlPane.setBounds(80,520,900,600);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("BID");
        model.addColumn("FULLNAME");
        model.addColumn("ADDRESS");
        model.addColumn("MOBILE");
        model.addColumn("EMAIL");
        model.addColumn("DESCRIPTION");
        model.addColumn("ROOM");
        model.addColumn("BOOKEDDATE");
        model.addColumn("TDATE");

        jf.setTitle("Update Booking");
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
            if(((t1.getText()).equals("")))
            {
                JOptionPane.showMessageDialog(this,"Please enter booking id  !","Warning!!!",JOptionPane.WARNING_MESSAGE);
            }
            else
            {//fetch
                try
                {
                    int foundrec = 0;
                    con=db.getConnection();
                    System.out.println("Connected to database.");
                    ps=con.prepareStatement("select * from room_booking where b_id='"+t1.getText()+"' ");
                    rs=ps.executeQuery();
                    while(rs.next())
                    {
                        t1.setText(rs.getString(1));
                        t2.setText(rs.getString(2));
                        t3.setText(rs.getString(3));
                        t4.setText(rs.getString(4));
                        t5.setText(rs.getString(5));
                        t7.setText(rs.getString(6));
                        datemodel.setValue(rs.getDate(8));
                        c1.setSelectedItem(rs.getString(7));

                        foundrec = 1;
                    }
                    if (foundrec == 0)
                    {
                        JOptionPane.showMessageDialog(null,"Record is not available","Dialog",JOptionPane.WARNING_MESSAGE);
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

        else if(ae.getSource()==b1)
        {//update

            String email=t5.getText();
            Pattern p=Pattern.compile("[_a-z_A-Z_0-9]*[0-9]*@[a-zA-Z0-9]*.[a-zA-Z0-9]*");
            Matcher m=p.matcher(email);
            boolean matchFound=m.matches();

            if(((t1.getText()).equals(""))&&((t2.getText()).equals("")))
            {
                JOptionPane.showMessageDialog(this,"Please enter mr id or name !","Warning!!!",JOptionPane.ERROR_MESSAGE);
            }
            else if(((t2.getText()).equals(""))||((t3.getText()).equals(""))||((t4.getText()).equals(""))||((t5.getText()).equals("")))
            {
                JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.ERROR_MESSAGE);
            }

            else
            {
                try
                {
                    con=db.getConnection();
                    System.out.println("Connected to database.");
                    ps=con.prepareStatement("select * from  room_availbility where  status='availble' and  room=? and adate=?");
                    ps.setDate(2,(Date)datePicker.getModel().getValue());
                    ps.setString(1, c1.getSelectedItem().toString());
                    ResultSet rsnew = ps.executeQuery();
                    if(rsnew.next()){


                        stmt=con.createStatement();
                        String str1="UPDATE room_booking SET fullname='"+t2.getText()+"',address='"+t3.getText()+"',mobile='"+t4.getText()+"',email='"+t5.getText()+"',description='"+t7.getText()+"',room='"+c1.getSelectedItem().toString()+"',bdate='"+datePicker.getModel().getValue()+"' where b_id='"+t1.getText()+"' ";
                        stmt.executeUpdate(str1);



                        ps=con.prepareStatement("update room_availbility set status='booked' where room=? and adate=?");
                        ps.setDate(2,(Date)datePicker.getModel().getValue());
                        ps.setString(1, c1.getSelectedItem().toString());
                        ps.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Record is updated");
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                        t7.setText("");
                        con.close();
                    }

                    else{
                        JOptionPane.showMessageDialog(this,"* Room is not availble on that date"," Warning ", JOptionPane.WARNING_MESSAGE);

                    }
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

    }


    public static void main(String args[])
    {
        new UpdateRoomBooking();
    }

}