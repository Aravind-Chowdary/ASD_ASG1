import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.ImageIcon;

public class DB {
    public Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("https://selene.hud.ac.uk/phpmyadmin/db_structure.php?server=1&db=u1950905&token=724ba7cd7b938cd42594c6fc7c180759","U1950905","AK06mar19hj");
        }catch(Exception e){System.out.println(e);}
        return con;
    }
    public ImageIcon getImage(String str)
    {
        return new ImageIcon(getClass().getClassLoader().getResource(str));
    }

}
