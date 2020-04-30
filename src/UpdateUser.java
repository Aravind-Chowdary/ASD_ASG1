import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateUser extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1;
    JTextField t1;
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

