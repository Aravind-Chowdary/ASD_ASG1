import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class LoginClerk extends JFrame implements ActionListener {
    JFrame jf;
    JLabel l1, l2, l5;
    JTextField t1;
    JPasswordField p1;
    Font f;
    JButton b1, b2, b3, b4;
    DB db = null;
    Connection con;

    LoginClerk() {
        db = new DB();
        jf = new JFrame();
        f = new Font("Times New Roman", Font.BOLD, 20);
        jf.setLayout(null);

        l5 = new JLabel("Clerk Login Here");
        l5.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l5.setBounds(200, 100, 300, 40);
        jf.add(l5);

        l1 = new JLabel("User Name : ");
        l1.setFont(f);
        l1.setBounds(200, 250, 200, 25);
        jf.add(l1);

        t1 = new JTextField(20);
        t1.setBounds(350, 250, 200, 25);
        t1.setToolTipText("Enter Username");
        jf.add(t1);

        l2 = new JLabel("Password  : ");
        l2.setFont(f);
        l2.setBounds(200, 300, 200, 25);
        jf.add(l2);

        p1 = new JPasswordField(20);
        p1.setBounds(350, 300, 200, 25);
        p1.setToolTipText("Enter Password");
        jf.add(p1);

        b1 = new JButton("Login", db.getImage("images/Login.png"));
        b1.setBounds(200, 400, 100, 35);
        jf.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Clear", db.getImage("images/clear.png"));
        b2.setBounds(320, 400, 100, 35);
        jf.add(b2);
        b2.addActionListener(this);

        b3 = new JButton("Exit", db.getImage("images/exit.png"));
        b3.setBounds(440, 400, 100, 35);
        jf.add(b3);
        b3.addActionListener(this);

        b4 = new JButton("Back", db.getImage("images/exit.png"));
        b4.setBounds(560, 400, 100, 35);
        jf.add(b4);
        b4.addActionListener(this);

        jf.setTitle("Login");
        jf.setLocation(20, 20);
        jf.setSize(800, 600);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                String s = t1.getText();
                String s1 = new String(p1.getPassword());
                con = db.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from user_manager  where role='clerk' and username='" + s + "' and password='" + s1 + "'");

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "      Welcome !!! ", "WELCOME", JOptionPane.INFORMATION_MESSAGE);
                    jf.setVisible(false);
                    new ClerkMenu();
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, " Sorry !!! You are not valid user ...!!!", "WARNING", JOptionPane.ERROR_MESSAGE);
                t1.setText("");
                p1.setText("");
            }
        } else if (ae.getSource() == b2) {
            t1.setText("");
            p1.setText("");

        } else if (ae.getSource() == b3) {
            System.exit(0);
        } else if (ae.getSource() == b4) {
            jf.dispose();
            CRSHome.main(new String[]{});
        }


    }
    public static void main(String args[])
    {
        new LoginClerk();

    }

}
