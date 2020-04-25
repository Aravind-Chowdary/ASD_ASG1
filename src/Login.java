import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


class Login extends JFrame implements ActionListener {
    JFrame jf;                          // Declaring the JFrame variable
    JLabel l5,l1,l2,l3,l4;              // Declaring the Labels in Login page
    JTextField t1;                      // Declaring the Text field in Login page
    JPasswordField p1;                  // Declaring the Password field in Login page
    JButton b1,b2,b3,b4;                // Declaring the Buttons in Login page
    DB db=null;                         // Declaring the DB class
    int cnt=0,cnt1=0;                   //To count the login attempts
    Connection con=null;
    Font f; //
    Login()
    {
        db = new DB();
        jf=new JFrame();
        f = new Font("Times New Roman",Font.BOLD,20);
        jf.setLayout(null);
        l5 = new JLabel("Welcome");
        l5.setFont(new Font("Times New Roman",Font.BOLD,30));
        l5.setForeground(Color.WHITE);
        l5.setBounds(300,100,300,40);
        jf.add(l5);



        l1 = new JLabel("User Name : ");
        l1.setFont(f);
        l1.setForeground(Color.WHITE);
        l1.setBounds(200,250,200,25);
        jf.add(l1);

        t1 = new JTextField(20);
        t1.setBounds(350,250,200,25);
        t1.setToolTipText("Enter Username");
        jf.add(t1);


        l2 = new JLabel("Password  : ");
        l2.setFont(f);
        l2.setBounds(200,300,200,25);
        l2.setForeground(Color.WHITE);
        jf.add(l2);

        p1 = new JPasswordField(20);
        p1.setBounds(350,300,200,25);
        p1.setToolTipText("Enter Password");
        jf.add(p1);

        b1 = new JButton("Login",db.getImage("images/Login.png"));
        b1.setBounds(200,400,100,35);
        b1.setBackground(Color.WHITE);
        jf.add(b1);b1.addActionListener(this);

        b2 = new JButton("Clear");
        b2.setBounds(320,400,100,35);
        b2.setBackground(Color.WHITE);
        jf.add(b2);b2.addActionListener(this);

        b3 = new JButton("Exit");
        b3.setBounds(440,400,100,35);
        b3.setBackground(Color.WHITE);
        jf.add(b3);b3.addActionListener(this);

        b4 = new JButton("Back");
        b4.setBounds(560,400,100,35);
        b4.setBackground(Color.WHITE);
        jf.add(b4);b4.addActionListener(this);

        jf.setTitle("Login");
        jf.setLocation(20,20);
        jf.setSize(800,600);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.black);
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                String s = t1.getText();
                String s1 = new String(p1.getPassword());
                con = db.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from user_manager where role='manager' and username='" + s + "' and password='" + s1 + "'");

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, " Welcome to the room Booking portal ", "WELCOME", JOptionPane.INFORMATION_MESSAGE);
                    jf.setVisible(false);
                    new MainMenu();
                }

                else {
                    throw new Exception();
                }
            } catch (Exception e1) {
                cnt++;
                JOptionPane.showMessageDialog(null, " Sorry !!! You are not valid user ...!!!", "WARNING", JOptionPane.ERROR_MESSAGE);
                t1.setText("");
                p1.setText("");
            }
        }
        else if(ae.getSource()==b2)
        {
            t1.setText("");
            p1.setText("");
        }
        else if(ae.getSource()==b3)
        {
            System.exit(0);
        }
    }

    public static void main(String args[])
    {
        new Login();

    }
}
