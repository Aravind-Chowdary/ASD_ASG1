import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class AddNewRoomType extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l2;
    JTextField t2;
    JButton b0,b1,b2;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    AddNewRoomType()
    {
        jf=new JFrame();
        jf.setLayout(null);

        l2 = new JLabel("Enter Room Type Name*");
        //l2.setFont(f);
        l2.setBounds(150,160,170,25);
        jf.add(l2);

        t2=new JTextField(20);
        t2.setBounds(320,160,200,25);t2.setToolTipText("Enter Room Type Name");
        jf.add(t2);

        b0 = new JButton("Save");
        b0.setBounds(150,230,110,35);
        b0.setToolTipText("Click to Save Room Type details");
        jf.add(b0);

        b1 = new JButton("Clear");
        b1.setBounds(300,230,110,35);
        b1.setToolTipText("Click to Clear all TextFields");
        jf.add(b1);

        b2= new JButton("All");
        b2.setBounds(450,230,110,35);
        b2.setToolTipText("Click to View all Room Type Details");
        jf.add(b2);

        scrlPane.setBounds(80,380,900,600);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("ID");
        model.addColumn("ROOMTYPE");
        jf.setTitle("Add New Room Type");
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
        new AddNewRoomType();
    }
}