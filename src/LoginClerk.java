import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class LoginClerk extends JFrame implements ActionListener
{
    JFrame jf;
    LoginClerk(){
        jf=new JFrame();
        jf.setLayout(null);

        jf.setTitle("Login");
        jf.setLocation(20,20);
        jf.setSize(800,600);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {

    }

    public static void main(String args[])
    {
        new LoginClerk();

    }

}
