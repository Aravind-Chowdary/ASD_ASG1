import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AssignList extends JFrame
{
    JFrame jf;
    DB db = null;
    JLabel ln;
    Connection con;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    Statement stmt;
    ResultSet rs;

    public AssignList(){
        db = new DB();
        jf = new JFrame();
        jf.setLayout(null);

        ln = new JLabel("List Of Available Room Details");
        ln.setFont(new Font("Times New Roman",Font.BOLD,25));
        ln.setForeground(Color.blue);
        ln.setBounds(300,30,350,25);
        jf.add(ln);

        scrlPane.setBounds(80,80,900,600);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("A_ID");
        model.addColumn("Room");
        model.addColumn("Date");
        model.addColumn("Type");
        model.addColumn("Time");
        int r = 0;
        try
        {
            con=db.getConnection();
            System.out.println("Connected to database.");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from room_availbility" );
            while(rs.next())
            {
                model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5) });
            }
            con.close();
        }
        catch(SQLException se)
        {
            System.out.println(se);
            JOptionPane.showMessageDialog(null,"SQL Error:"+se);
        }

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