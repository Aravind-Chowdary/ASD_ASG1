import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.ImageIcon;

public class DB {
    public Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://selene.hud.ac.uk/u1950905","u1950905","AK06mar19hj");
            if (con != null) {
                System.out.println("yes");
            }

        }catch(Exception e){System.out.println(e);}
        return con;
    }
    public ImageIcon getImage(String str)
    {
        return new ImageIcon(getClass().getClassLoader().getResource(str));
    }

}
