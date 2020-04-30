import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Statement;
import java.util.Properties;

public class UpdateRoomBooking extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5,t7,t8,t9;
    JComboBox c1;
    DB db = null;
    Connection con;
    JDatePickerImpl datePicker;
    SqlDateModel datemodel;
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


        jf.setTitle("Update Booking");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

    }
}