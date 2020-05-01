import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClerkMenu extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1;
    GridBagLayout gbl;
    JMenuBar mbar;
    JMenu m5,m6,m10;
    JMenuItem m5_1,m5_2,m6_1,m6_2,m10_1,m10_2;
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

        m6=new JMenu("Book Room");
        mbar.add(m6);
        m6_1 = new JMenuItem("Add New Booking");
        m6.add(m6_1);
        m6_2 = new JMenuItem("View / Manage Room Booking");
        m6.add(m6_2);

        m6.addActionListener(this);
        m6_1.addActionListener(this);
        m6_2.addActionListener(this);

        m10=new JMenu("Rooms");
        mbar.add(m10);
        m10_1 = new JMenuItem("Search Rooms");
        m10.add(m10_1);
        m10_2 = new JMenuItem("View Available Rooms");
        m10.add(m10_2);

        m10.addActionListener(this);
        m10_1.addActionListener(this);
        m10_2.addActionListener(this);


        m5=new JMenu("Exit");
        mbar.add(m5);
        m5_1 = new JMenuItem("Exit");
        m5.add(m5_1);
        m5_2 = new JMenuItem("Logout");
        m5.add(m5_2);

        m5.addActionListener(this);
        m5_1.addActionListener(this);
        m5_2.addActionListener(this);


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
        if(ae.getSource()==m6_1)
        {
            new AddNewBooking();
        }
        else if(ae.getSource()==m6_2)
        {
            new UpdateRoomBooking();
        }
        else if(ae.getSource()==m10_1)
        {
            new SearchRoom();
        }
        else if(ae.getSource()==m10_2)
        {
            new AssignList();
        }
        else if(ae.getSource()==m5_1)
        {
            System.exit(0);
        }
        else if(ae.getSource()==m5_2)
        {
            jf.setVisible(false);
            new LoginClerk();
        }
    }

    public static void main(String args[])
    {
        new ClerkMenu();
    }
}
