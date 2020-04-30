import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchRoom extends JFrame implements ActionListener
{
    JFrame jf;
    Font f;
    SearchRoom(){
        jf=new JFrame();
        f = new Font("Times New Roman",Font.BOLD,15);
        jf.setLayout(null);

        jf.setTitle("Search Rooms ");
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
        new SearchRoom();
    }
}

