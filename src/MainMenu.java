import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener
{
    JFrame jf;
    GridBagLayout gbl;
    public MainMenu()
    {
        jf=new JFrame();
        gbl=new GridBagLayout();
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

    }
    public static void main(String args[])
    {
        new MainMenu();
    }
}