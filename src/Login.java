
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Login extends JFrame implements ActionListener {
    JFrame jf;
    JLabel l5,l1,l2;
    JTextField t1;
    JPasswordField p1;
    Font f;
    Login()
    {
        jf=new JFrame();
        f = new Font("Times New Roman",Font.BOLD,20);
        jf.setLayout(null);
        l5 = new JLabel("Login Here");l5.setFont(new Font("Times New Roman",Font.BOLD,30));
        l5.setBounds(300,100,300,40);
        jf.add(l5);

        l1 = new JLabel("User Name : "); l1.setFont(f);
        l1.setBounds(200,250,200,25);
        jf.add(l1);

        t1 = new JTextField(20);
        t1.setBounds(350,250,200,25);
        t1.setToolTipText("Enter Username");
        jf.add(t1);

        l2 = new JLabel("Password  : "); l2.setFont(f);
        l2.setBounds(200,300,200,25);
        jf.add(l2);

        p1 = new JPasswordField(20);
        p1.setBounds(350,300,200,25);
        p1.setToolTipText("Enter Password");
        jf.add(p1);

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
        new Login();

    }
}
