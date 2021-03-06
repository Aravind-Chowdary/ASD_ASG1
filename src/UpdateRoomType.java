import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateRoomType extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b0,b1,b2,b3,b4;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    Connection con;
    DB db =null;
    PreparedStatement ps;
    ResultSet rs;
    Statement stmt;
    UpdateRoomType()
    {
        jf=new JFrame();
        Dimension screen= Toolkit.getDefaultToolkit().getScreenSize();
        jf.setLayout(null);
        db = new DB();
        l1= new JLabel("Room Type id *");
        l1.setBounds(150,120,130,25);
        jf.add(l1);

        t1=new JTextField(20);
        t1.setBounds(320,120,200,25);
        t1.setToolTipText("Enter Room Type id");
        jf.add(t1);

        l2 = new JLabel(" Room Type Name*");
        l2.setBounds(150,160,170,25);
        jf.add(l2);

        t2 = new JTextField(20);
        t2.setBounds(320,160,200,25);
        t2.setToolTipText("Enter Room Type Name");
        jf.add(t2);

        b0 = new JButton("Open");
        b0.setBounds(150,230,110,35);
        jf.add(b0);
        b0.addActionListener(this);

        b1 = new JButton("Update");
        b1.setBounds(300,230,110,35);
        jf.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Clear");
        b2.setBounds(450,230,110,35);
        jf.add(b2);
        b2.addActionListener(this);

        b3 = new JButton("All");
        b3.setBounds(600,230,110,35);
        jf.add(b3);
        b3.addActionListener(this);

        b4 = new JButton("Delete");
        b4.setBounds(750,230,110,35);
        jf.add(b4);
        b4.addActionListener(this);


        scrlPane.setBounds(80,380,600,300);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("Room_Type_ID");
        model.addColumn("Room_Type_NAME");

        jf.setTitle("Update Zone");
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
                JOptionPane.showMessageDialog(this, "Please enter room type id or name !", "Warning!!!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    int foundrec = 0;
                    con = db.getConnection();
                    System.out.println("Connected to database.");
                    ps = con.prepareStatement("select * from typemaster where id='" + t1.getText() + "' or roomtype='" + t2.getText() + "'");
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        t1.setText(rs.getString(1));
                        t2.setText(rs.getString(2));

                        foundrec = 1;
                    }
                    if (foundrec == 0) {
                        JOptionPane.showMessageDialog(null, "Record is not available", "Dialog", JOptionPane.WARNING_MESSAGE);
                    }
                    con.close();
                } catch (SQLException se) {
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null, "SQL Error:" + se);
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Error:" + e);
                }
            }
        } else if (ae.getSource() == b1) {//update


            if (((t1.getText()).equals("")) && ((t2.getText()).equals(""))) {
                JOptionPane.showMessageDialog(this, "Please enter  id or name !", "Warning!!!", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    con = db.getConnection();
                    System.out.println("Connected to database.");
                    stmt = con.createStatement();
                    String str1 = "UPDATE typemaster SET roomtype='" + t2.getText() + "' where id=" + t1.getText() + "  ";
                    stmt.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null, "Record is updated");
                    t1.setText("");
                    t2.setText("");
                    con.close();
                } catch (SQLException se) {
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null, "SQL Error:" + se);
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Error:" + e);
                }
            }
        } else if (ae.getSource() == b2) {
            t1.setText("");
            t2.setText("");
        } else if (ae.getSource() == b4) {//delete
            if (((t1.getText()).equals("")) && ((t2.getText()).equals(""))) {
                JOptionPane.showMessageDialog(this, "Please enter  id or name !", "Warning!!!", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    con = db.getConnection();
                    System.out.println("Connected to database.");
                    ps=con.prepareStatement("delete from typemaster where id='"+t1.getText()+"' or roomtype='"+t2.getText()+"'");
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record is deleted.");
                    t1.setText("");
                    t2.setText("");
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

        else if(ae.getSource()==b3) {//list

            if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
            int r = 0;
            try {
                con = db.getConnection();
                System.out.println("Connected to database.");
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery("SELECT * from typemaster");
                while (rs.next()) {
                    model.insertRow(r++, new Object[]{rs.getString(1), rs.getString(2)});
                }
                con.close();
            } catch (SQLException se) {
                System.out.println(se);
                JOptionPane.showMessageDialog(null, "SQL Error" + se);
            }
        }

    }
    public static void main(String args[])
    {
        new UpdateRoomType();
    }
}