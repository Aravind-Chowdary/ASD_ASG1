
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Login extends JFrame implements ActionListener {
    JFrame jf;
    Font f;
    Login()
    {
        jf=new JFrame();
        f = new Font("Times New Roman",Font.BOLD,20);
        jf.setLayout(null);
    }
    public void actionPerformed(ActionEvent ae)
    {

    }

    public static void main(String args[])
    {
        new Login();

    }
}
