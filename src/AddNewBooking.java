import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewBooking extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1,l2;
    JTextField t2;
    AddNewBooking(){
        jf = new JFrame();
        jf.setLayout(null);

        l1=new JLabel("Add New Booking");
        l1.setFont(new Font("Times New Roman",Font.BOLD,25));
        l1.setBounds(250,50,300,40);
        l1.setForeground(Color.blue);
        jf.add(l1);

        l2 = new JLabel("Full Name*");
        l2.setBounds(150,160,170,25);
        jf.add(l2);

        t2=new JTextField(20);
        t2.setBounds(320,160,250,25);t2.setToolTipText("Enter Full Name");
        jf.add(t2);

        jf.setTitle("ADD NEW BOOKING");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

    }
    public  static void main(String args[]){

    }
}