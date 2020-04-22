import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class UpdateRoom extends JFrame implements ActionListener
{
    JFrame jf;
    UpdateRoom()
    {
        jf = new JFrame();
        jf.setLayout(null);

        jf.setTitle("Update Room");
        // jf.setSize(900,700);
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
        new UpdateRoom();
    }
}