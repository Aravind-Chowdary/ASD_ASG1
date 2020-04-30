import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClerkMenu extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1;
    GridBagLayout gbl;
    JMenuBar mbar;
    public ClerkMenu()
    {
        jf = new JFrame();
        jf.setLayout(null);

        gbl=new GridBagLayout();
        jf.setLayout(gbl);

        l1=new JLabel("Welcome To Room Booking Portal");
        l1.setFont(new Font("Times New Roman",Font.BOLD,30));
        jf.add(l1);

        mbar = new JMenuBar();
        jf.setJMenuBar(mbar);

        jf.setTitle("Clerk Menu");
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
        new ClerkMenu();
    }
}
