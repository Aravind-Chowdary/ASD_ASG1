import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUser extends JFrame implements ActionListener
{

    JFrame jf;
    JLabel l1,l2;
    JTextField t2;
    AddUser(){
        jf = new JFrame();
        jf.setLayout(null);

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