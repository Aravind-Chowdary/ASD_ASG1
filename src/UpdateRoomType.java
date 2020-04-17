import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateRoomType extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b0,b1,b2,b3;

    UpdateRoomType()
    {
        jf=new JFrame();
        Dimension screen= Toolkit.getDefaultToolkit().getScreenSize();
        jf.setLayout(null);

        l1= new JLabel("Room Type id *");
        //l1.setFont(f);
        l1.setBounds(150,120,130,25);
        jf.add(l1);

        t1=new JTextField(20);
        t1.setBounds(320,120,200,25);
        t1.setToolTipText("Enter Room Type id");
        jf.add(t1);

        l2 = new JLabel(" Room Type Name*");
        //l2.setFont(f);
        l2.setBounds(150,160,170,25);
        jf.add(l2);

        t2 = new JTextField(20);
        t2.setBounds(320,160,200,25);
        t2.setToolTipText("Enter Room Type Name");
        jf.add(t2);

        b0 = new JButton("Open");
        b0.setBounds(150,230,110,35);
        jf.add(b0);

        b1 = new JButton("Update");
        b1.setBounds(300,230,110,35);
        jf.add(b1);

        b2 = new JButton("Clear");
        b2.setBounds(450,230,110,35);
        jf.add(b2);

        b3 = new JButton("All");
        b3.setBounds(600,230,110,35);
        jf.add(b3);


        jf.setTitle("Update Zone");
        // jf.setSize(900,700);
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
        new UpdateRoomType();
    }
}