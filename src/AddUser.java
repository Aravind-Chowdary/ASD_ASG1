import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUser extends JFrame implements ActionListener
{

    JFrame jf;
    JLabel l1,l2,l3,l4,l5;
    JTextField t2,t3,t5;
    JComboBox c1;
    JButton b0,b1,b2;
    DB db =null;
    Font f;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    AddUser(){
        jf = new JFrame();
        jf.setLayout(null);
        db = new DB();
        f = new Font("Times New Roman",Font.BOLD,20);

        l1=new JLabel("Add New User");
        l1.setBounds(150,90,300,40);
        l1.setFont(new Font("Times New Roman",Font.BOLD,25));
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
        t5.setBounds(320,280,250,25);
        t5.setToolTipText("Enter email id");
        jf.add(t5);

        b0 = new JButton("Save",db.getImage("images/save.png"));
        b0.setBounds(150,350,110,35);b0.setToolTipText("click to save User details");
        jf.add(b0);b0.addActionListener(this);

        b1 = new JButton("Clear",db.getImage("images/clear.png"));
        b1.setBounds(300,350,110,35);b1.setToolTipText("click to clear all textfilds");
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
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String args[])
    {
        new AddUser();
    }
}