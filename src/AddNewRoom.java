import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class AddNewRoom extends JFrame implements ActionListener
{
    JFrame jf;
    Font f;
    JLabel l2,l3,l4,l5,l6,l7;
    JTextField t2,t3,t4,t5,t7;

    AddNewRoom(){
        jf=new JFrame();
        f = new Font("Times New Roman",Font.BOLD,20);
        jf.setLayout(null);

        l6=new JLabel("Add New Room");
        l6.setFont(new Font("Times New Roman",Font.BOLD,25));
        l6.setBounds(150,100,300,40);l6.setForeground(Color.black);
        jf.add(l6);

        l2 = new JLabel("Room name*");
        l2.setBounds(150,160,170,25);
        jf.add(l2);

        t2=new JTextField(20);
        t2.setBounds(320,160,250,25);
        t2.setToolTipText("Enter Room name");
        jf.add(t2);

        l3 = new JLabel("Room Size*");
        l3.setBounds(150,200,170,25);
        jf.add(l3);

        t3=new JTextField(20);
        t3.setBounds(320,200,250,25);
        t3.setToolTipText("Enter Room Size");
        jf.add(t3);

        l4 = new JLabel("Availbility*");
        //l3.setFont(f);
        l4.setBounds(150,240,170,25);
        jf.add(l4);

        t4=new JTextField(20);
        t4.setBounds(320,240,250,25);
        t4.setToolTipText("Availbility");
        jf.add(t4);

        l5 = new JLabel("Date*");
        //l3.setFont(f);
        l5.setBounds(150,280,170,25);
        jf.add(l5);


        t5=new JTextField(20);
        t5.setBounds(320,280,250,25);
        t5.setToolTipText("Date");
        jf.add(t5);

        l7 = new JLabel("Time*");
        //l3.setFont(f);
        l7.setBounds(150,320,170,25);
        jf.add(l7);

        t7=new JTextField(20);
        t7.setBounds(320,320,250,25);
        t7.setToolTipText("Time");
        jf.add(t7);

        jf.setTitle("Add New Room");
        //jf.setSize(900,700);
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
        new AddNewRoom();
    }


}