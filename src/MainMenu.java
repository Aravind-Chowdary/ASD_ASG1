import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener
{
    JFrame jf;
    JMenuBar mbar;
    JMenu m6,m7,m8,m9,m10;
    JMenuItem m6_1,m6_2,m7_1,m7_2,m8_1,m8_2,m9_1,m9_2,m10_1,m10_2,m10_3;
    GridBagLayout gbl;
    DB db=null;
    public MainMenu()
    {
        db = new DB();
        jf=new JFrame();
        gbl=new GridBagLayout(); // This Layout is used to place the components in a grid of rows and columns.

        mbar = new JMenuBar();
        jf.setJMenuBar(mbar);

        m6=new JMenu("RoomType");
        mbar.add(m6);
        m6_1 = new JMenuItem("Add New RoomType",db.getImage("images/addnew.png"));
        m6.add(m6_1);
        m6_2 = new JMenuItem("Manage Room Type",db.getImage("images/update.png"));
        m6.add(m6_2);


        m7=new JMenu("Rooms");
        mbar.add(m7);
        m7_1 = new JMenuItem("Add New Room",db.getImage("images/addnew.png"));
        m7.add(m7_1);
        m7_2 = new JMenuItem("Manage Room",db.getImage("images/update.png"));
        m7.add(m7_2);


        m6_1.addActionListener(this);
        m6_2.addActionListener(this);


        m7_1.addActionListener(this);
        m7_2.addActionListener(this);

        m9=new JMenu("Add Clerk");
        mbar.add(m9);
        m9_1 = new JMenuItem("Add Clerks",db.getImage("images/addnew.png"));
        m9.add(m9_1);

        m9_2 = new JMenuItem("Manage Clerks",db.getImage("images/update.png"));
        m9.add(m9_2);

        m9_1.addActionListener(this);
        m9_2.addActionListener(this);

        m10=new JMenu("Availability");
        mbar.add(m10);
        m10_1 = new JMenuItem("Assign Availability",db.getImage("images/addnew.png"));
        m10.add(m10_1);
        m10_2 = new JMenuItem("View Room Details",db.getImage("images/all.png"));
        m10.add(m10_2);
        m10_3 = new JMenuItem("Update Availability",db.getImage("images/update.png"));
        m10.add(m10_3);

        m8=new JMenu("Exit");
        mbar.add(m8);
        m8_1 = new JMenuItem("Exit",db.getImage("images/exit.png"));
        m8.add(m8_1);
        m8_1.addActionListener(this);
        m8_2 = new JMenuItem("Logout",db.getImage("images/pass.png"));
        m8.add(m8_2);
        m8_2.addActionListener(this);

        jf.setLayout(gbl);
        jf.setTitle("Main Menu");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==m6_1)
        {
            new AddNewRoomType();
        }
        else if(e.getSource()==m6_2)
        {
            new UpdateRoomType();
        }


        else if(e.getSource()==m7_1)
        {
            new AddNewRoom();
        }
        else if(e.getSource()==m7_2)
        {
            new UpdateRoom();
        }
        else if(e.getSource()==m8_1)
        {
            System.exit(0);
        }
        else if(e.getSource()==m8_2)
        {
            jf.setVisible(false);
            new Login();
        }
        else if(e.getSource()==m9_1)
        {
            new AddUser();
        }
        else if(e.getSource()==m9_2)
        {
            new UpdateUser();
        }
        else if(e.getSource()==m10_1)
        {
            new AssignRoomAvailability();
        }
        else if(e.getSource()==m10_2)
        {
            new AssignList();
        }
        else if(e.getSource()==m10_3)
        {
            new UpdateRoomAvailability();
        }
    }
    public static void main(String args[])
    {
        new MainMenu();
    }
}