import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class AssignRoomAvailability extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1,l2;
    JComboBox c1;
    DB db =null;
    Connection con;
    JDatePickerImpl datePicker;
    SqlDateModel datemodel;
    AssignRoomAvailability(){
        jf = new JFrame();
        jf.setLayout(null);

        l1 = new JLabel("Select Room *");
        l1.setBounds(150,120,130,25);
        jf.add(l1);

        c1=new JComboBox();
        c1.setBounds(320,120,200,25);c1.setToolTipText("Select Room");
        jf.add(c1);
        c1.addItem("Select Room");

        l2= new JLabel("Select Date *");
        //l1.setFont(f);
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
        //l1.setFont(f);
        l2.setBounds(150,160,170,25);
        jf.add(l2);

        jf.setTitle("Assign Day and Room Availability");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String args[])
    {
        new AssignRoomAvailability();
    }
}