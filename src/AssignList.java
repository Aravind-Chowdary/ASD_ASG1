import javax.swing.*;
import java.awt.*;

public class AssignList extends JFrame
{
    JFrame jf;
    public AssignList(){
        jf = new JFrame();
        jf.setLayout(null);


        jf.setTitle("List of Available Room Details");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }
    public static void main(String args[])
    {
        new AssignList();
    }
}