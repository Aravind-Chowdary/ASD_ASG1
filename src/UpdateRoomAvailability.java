import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateRoomAvailability extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1,l2;
    JTextField t1;
    JComboBox c1;
    DB db= null;
    Connection con;
    UpdateRoomAvailability(){
        jf = new JFrame();
        jf.setLayout(null);
        l1 = new JLabel("Assign Id *");
        l1.setBounds(150,90,130,25);
        jf.add(l1);

        t1=new JTextField(20);
        t1.setBounds(320,90,200,25);
        t1.setToolTipText("Id");
        jf.add(t1);

        l2 = new JLabel("Select Room *");
        l2.setBounds(150,120,130,25);
        jf.add(l2);

        c1=new JComboBox();
        c1.setBounds(320,120,200,25);c1.setToolTipText("Select Room");
        jf.add(c1);
        c1.addItem("Select Room");
        try {
            con=db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select rtitle from room_manager");
            while (rs.next()) {
                String round = rs.getString("rtitle");
                c1.addItem(round);
            }
            rs.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        jf.setTitle("Manage Bookings ");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String args[]){

    }
}