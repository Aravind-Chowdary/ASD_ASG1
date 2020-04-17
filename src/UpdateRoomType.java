import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateRoomType extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1;
    UpdateRoomType()
    {
        jf=new JFrame();
        Dimension screen= Toolkit.getDefaultToolkit().getScreenSize();
        jf.setLayout(null);

        l1= new JLabel("Room Type id *");
        //l1.setFont(f);
        l1.setBounds(150,120,130,25);
        jf.add(l1);

        jf.setTitle("Update Zone");
        // jf.setSize(900,700);
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
        new UpdateRoomType();
    }
}