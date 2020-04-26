import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener
{
    JFrame jf;
    JMenuBar mbar;
    JMenu m6,m7;
    JMenuItem m6_1,m6_2,m7_1,m7_2;
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
    }
    public static void main(String args[])
    {
        new MainMenu();
    }
}