import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateRoomType extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1,l2;
    JTextField t1;
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