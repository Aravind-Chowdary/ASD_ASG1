import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class AddNewRoomType extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l2,l3;
    JTextField t2;
    JButton b0,b1,b2;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    Font f;
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    Connection con;
    DB db = null;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    AddNewRoomType()
    {
        db = new DB();
        jf=new JFrame();
        f = new Font("Times New Roman",Font.BOLD,20);
        jf.setLayout(null);

        l3=new JLabel("Add New Room Type ");
        l3.setFont(new Font("Times New Roman",Font.BOLD,25));
        l3.setBounds(250,50,300,40);
        l3.setForeground(Color.blue);
        jf.add(l3);

        l2 = new JLabel("Enter Room Type Name*");
        //l2.setFont(f);
        l2.setBounds(150,160,170,25);
        jf.add(l2);

        t2=new JTextField(20);
        t2.setBounds(320,160,200,25);t2.setToolTipText("Enter Room Type Name");
        jf.add(t2);

        b0 = new JButton("Save");
        b0.setBounds(150,230,110,35);
        b0.setToolTipText("Click to Save Room Type details");
        jf.add(b0);
        b0.addActionListener(this);

        b1 = new JButton("Clear");
        b1.setBounds(300,230,110,35);
        b1.setToolTipText("Click to Clear all TextFields");
        b1.addActionListener(this);
        jf.add(b1);

        b2= new JButton("All");
        b2.setBounds(450,230,110,35);
        b2.setToolTipText("Click to View all Room Type Details");
        b2.addActionListener(this);
        jf.add(b2);

        scrlPane.setBounds(80,380,600,300);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("ID");
        model.addColumn("ROOMTYPE");
        jf.setTitle("Add New Room Type");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b0)
        {
            if(((t2.getText()).equals("")))
            {
                JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
            }

            else
            {
                try
                {
                    con=db.getConnection();
                    System.out.println("Connected to database.");
                    ps=con.prepareStatement("insert into typemaster (roomtype)values(?)");
                    ps.setString(1,t2.getText());
                    ps.executeUpdate();

                    int reply=JOptionPane.showConfirmDialog(null,"Room Type added successfully.Do you want add more Types?","Added Type",JOptionPane.YES_NO_OPTION);
                    //Conformation and select again to add the new room type
                    if (reply == JOptionPane.YES_OPTION)
                    {
                        jf.setVisible(false);
                        new AddNewRoomType();
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
            t2.setText("");
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
                rs = stmt.executeQuery("select * from typemaster order by roomtype asc" );
                while(rs.next())
                {
                    model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2) });
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
        new AddNewRoomType();
    }
}

