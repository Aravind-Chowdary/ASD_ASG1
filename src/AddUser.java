import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddUser extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1,l2,l3,l4,l5;
    JTextField t2,t5;
    JPasswordField t3;
    JComboBox c1;
    JButton b0,b1,b2;
    DB db =null;
    Connection con;
    PreparedStatement ps;
    Font f;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    Statement stmt;
    ResultSet rs;
    AddUser()
    {
        db = new DB();
        jf=new JFrame();
        f = new Font("Times New Roman",Font.BOLD,20);
        jf.setLayout(null);

        l1=new JLabel("Add New User");
        l1.setFont(new Font("Times New Roman",Font.BOLD,25));
        l1.setBounds(250,50,300,40);
        l1.setForeground(Color.blue);
        jf.add(l1);

        l2 = new JLabel("User Name*");
        l2.setBounds(150,160,170,25);
        jf.add(l2);

        t2=new JTextField(20);
        t2.setBounds(320,160,250,25);
        t2.setToolTipText("Enter user name");
        jf.add(t2);

        l3 = new JLabel("Password*");
        l3.setBounds(150,200,170,25);
        jf.add(l3);

        t3=new JPasswordField(20);
        t3.setBounds(320,200,250,25);t3.setToolTipText("Enter Password");
        jf.add(t3);

        l4 = new JLabel("Select Role*");
        l4.setBounds(150,240,170,25);
        jf.add(l4);

        c1=new JComboBox();
        c1.setBounds(320,240,250,25);c1.setToolTipText("Select Type");
        c1.addItem("select");
        c1.addItem("manager");
        c1.addItem("clerk");
        jf.add(c1);

        l5 = new JLabel(" Email id*");
        l5.setBounds(150,280,170,25);
        jf.add(l5);

        t5=new JTextField(20);
        t5.setBounds(320,280,250,25);t5.setToolTipText("Enter email id");
        jf.add(t5);

        b0 = new JButton("Save",db.getImage("images/save.png"));
        b0.setBounds(150,350,110,35);b0.setToolTipText("click to save User details");
        jf.add(b0);b0.addActionListener(this);

        b1 = new JButton("Clear",db.getImage("images/clear.png"));
        b1.setBounds(300,350,110,35);b1.setToolTipText("click to clear all textfields");
        jf.add(b1); b1.addActionListener(this);

        b2= new JButton("All",db.getImage("images/all.png"));
        b2.setBounds(450,350,110,35);b2.setToolTipText("click to view all User details");
        jf.add(b2); b2.addActionListener(this);

        scrlPane.setBounds(80,420,900,340);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("U_ID");
        model.addColumn("USER_NAME");
        model.addColumn("USER_PASSWORD");
        model.addColumn("USER_ROLE");
        model.addColumn("USER_EMAIL");

        jf.setTitle("Add New User");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b0)
        {
            String email=t5.getText();
            Pattern p=Pattern.compile("[_a-z_A-Z_0-9]+[0-9]*@[a-zA-Z0-9]+.[a-zA-Z0-9]+");
            Matcher m=p.matcher(email);
            boolean matchFound=m.matches();

            if(((t2.getText()).equals(""))||((t3.getText()).equals(""))||((t5.getText()).equals("")))
            {
                JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
            }
            else if(!matchFound)
            {
                JOptionPane.showMessageDialog(this,"Invalid email id!","Warning!!!",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                try
                {
                    con=db.getConnection();
                    System.out.println("Connected to database.");
                    ps=con.prepareStatement("insert into user_manager (username,password,role,email) values(?,?,?,?)");
                    ps.setString(1,t2.getText());
                    ps.setString(2,t3.getText());
                    ps.setString(3,c1.getSelectedItem().toString());
                    ps.setString(4,t5.getText());
                    ps.executeUpdate();

                    int reply=JOptionPane.showConfirmDialog(null,"User added successfully.Do you want add more Users?","Added User",JOptionPane.YES_NO_OPTION);

                    if (reply == JOptionPane.YES_OPTION)
                    {
                        jf.setVisible(false);
                        new AddUser();
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
                catch(Exception ae)
                {
                    System.out.println(ae);
                    JOptionPane.showMessageDialog(null,"Error:"+e);
                }
            }
        }
        else if(e.getSource()==b1) {
            t2.setText("");
            t3.setText("");
            t5.setText("");
        }
        else if(e.getSource()==b2)
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
                rs = stmt.executeQuery("select * from user_manager " );
                while(rs.next())
                {
                    model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5)});
                }
                con.close();
            }
            catch(SQLException se)
            {
                System.out.println(se);
                JOptionPane.showMessageDialog(null,"SQL Error:"+se);
            }
            catch(Exception ae)
            {
                System.out.println(ae);
                JOptionPane.showMessageDialog(null,"Error:"+e);
            }
        }
    }
    public static void main(String args[])
    {
        new AddUser();
    }
}