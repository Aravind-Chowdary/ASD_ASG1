
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Login extends JFrame implements ActionListener {
    JFrame jf;
    JLabel l5;
    Font f;
    Login()
    {
        jf=new JFrame();
        f = new Font("Times New Roman",Font.BOLD,20);
        jf.setLayout(null);
        l5 = new JLabel("Login Here");l5.setFont(new Font("Times New Roman",Font.BOLD,30));
        l5.setBounds(300,100,300,40);
        jf.add(l5);
    }
    public void actionPerformed(ActionEvent ae)
    {

    }

    public static void main(String args[])
    {
        new Login();

    }
}
