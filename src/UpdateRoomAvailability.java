import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Properties;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
public class UpdateRoomAvailability extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1,l2,l3,l4,l5;
    JButton b0,b1,b2,b3,b4;
    JTextField t1,t4;
    JComboBox c1,c2;
    DB db= null;
    Connection con;
    JDatePickerImpl datePicker;
    SqlDateModel datemodel;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    PreparedStatement ps;
    ResultSet rs;
    Statement stmt;
    UpdateRoomAvailability(){
        jf = new JFrame();
        jf.setLayout(null);
        l1 = new JLabel("Assign Id *");
        l1.setBounds(150,90,130,25);
        jf.add(l1);

        t1=new JTextField(20);
        t1.setBounds(320,90,200,25);
        t1.setToolTipText("Id");
        jf.add(t1);

        l2 = new JLabel("Select Room *");
        l2.setBounds(150,120,130,25);
        jf.add(l2);

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

        l3= new JLabel("Select Date *");
        l3.setBounds(150,160,170,25);
        jf.add(l3);

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

        l4= new JLabel("Enter Day Type*");
        l4.setBounds(150,200,210,25);
        jf.add(l4);

        c2= new JComboBox();
        c2.setBounds(320,200,200,25);
        c2.setToolTipText("Choose Type");
        c2.addItem("Select Day Type");
        c2.addItem("Holiday");
        c2.addItem("Weekend");
        c2.addItem("TermTime");
        jf.add(c2);

        l5 = new JLabel("Time *");
        l5.setBounds(150,240,210,25);
        jf.add(l5);

        t4=new JTextField(20);
        t4.setBounds(320,240,200,25);
        t4.setToolTipText("Time");
        jf.add(t4);

        b0 = new JButton("Open");
        b0.setBounds(150,300,110,35);b0.setToolTipText("click to open  details");
        jf.add(b0);

        b1 = new JButton("Update");
        b1.setBounds(300,300,110,35);b1.setToolTipText("click to update  details");
        jf.add(b1);

        b2 = new JButton("Clear");
        b2.setBounds(450,300,110,35);b2.setToolTipText("click to clear all textfilds");
        jf.add(b2);

        b3 = new JButton("All");
        b3.setBounds(600,300,110,35);b3.setToolTipText("click to view all  details");
        jf.add(b3);

        b4 = new JButton("Delete");
        b4.setBounds(750,300,110,35);b4.setToolTipText("click to delete  details");
        jf.add(b4);

        scrlPane.setBounds(80,380,900,600);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("A_ID");
        model.addColumn("Room");
        model.addColumn("Date");
        model.addColumn("Type");
        model.addColumn("Time");

        jf.setTitle("Manage Bookings ");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b0) {
            if (((t1.getText()).equals(""))) {
                JOptionPane.showMessageDialog(this, "Please enter  id or  !", "Warning!!!", JOptionPane.WARNING_MESSAGE);
            } else {//fetch
                try {
                    int foundrec = 0;
                    con = db.getConnection();
                    System.out.println("Connected to database.");
                    ps = con.prepareStatement("select * from room_availbility where aid='" + t1.getText() + "'");
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        t1.setText(rs.getString(1));
                        c1.setSelectedItem(rs.getString(2));
                        datemodel.setValue(rs.getDate(3));
                        c2.setSelectedItem(rs.getString(4));
                        t4.setText(rs.getString(5));

                        foundrec = 1;
                    }
                    if (foundrec == 0) {
                        JOptionPane.showMessageDialog(null, "Record is not available", "Dialog", JOptionPane.WARNING_MESSAGE);
                    }
                    con.close();
                } catch (SQLException se) {
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null, "SQL Error:" + se);
                }
            }
        }
        else if(ae.getSource()==b1) {

            if (t1.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "* Id is Missing !", "Warning!!!", JOptionPane.WARNING_MESSAGE);

            }
            if ((c1.getSelectedItem().toString().equals("Select Room")) || (c2.getSelectedItem().toString().equals("Select Day Type")) || datePicker.getModel().getValue() == "" || t4.getText() == "") {
                JOptionPane.showMessageDialog(this, "* Detail are Missing !", "Warning!!!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    con = db.getConnection();
                    System.out.println("Connected to database.");

                    ps = con.prepareStatement("update room_availbility set room=?,adate=?,dtype=?,atime=? where aid=?");
                    ps.setString(1, c1.getSelectedItem().toString());
                    ps.setDate(2, (Date) datePicker.getModel().getValue());
                    ps.setString(3, c2.getSelectedItem().toString());
                    ps.setString(4, t4.getText());
                    ps.setString(5, t1.getText());
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Record is updated");


                    con.close();
                } catch (SQLException se) {
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null, "SQL Error:" + se);
                }
            }
        }
        else if(ae.getSource()==b2)
        {
            t1.setText("");
            c1.setSelectedItem("Select Room");
            c2.setSelectedItem("Select Day Type");
            t4.setText("");

        }
        else if(ae.getSource()==b2)
        {
            t1.setText("");
            c1.setSelectedItem("Select Room");
            c2.setSelectedItem("Select Day Type");
            t4.setText("");

        }
        else if(ae.getSource()==b3)
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
                rs = stmt.executeQuery("select * from room_availbility " );
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
        }
    }
    public static void main(String args[]){

    }
}