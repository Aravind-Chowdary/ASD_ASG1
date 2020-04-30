import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateUser extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t5;
    JComboBox c1;
    UpdateUser(){
        jf = new JFrame();
        jf.setLayout(null);

        l1= new JLabel("User id *");
        l1.setBounds(150,120,130,25);
        jf.add(l1);

        t1=new JTextField(20);
        t1.setBounds(320,120,250,25);
        t1.setToolTipText("Enter User id");
        jf.add(t1);

        l2 = new JLabel("User name*");
        l2.setBounds(150,160,170,25);
        jf.add(l2);

        t2=new JTextField(20);
        t2.setBounds(320,160,250,25);
        t2.setToolTipText("Enter User name");
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
        c1.setBounds(320,240,250,25);
        c1.setToolTipText("Select Type");
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

        jf.setTitle("Update Users");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {

    }
    public static void main(String args[])
    {
        new UpdateUser();
    }
}

